package com.goorp.backend.domain.post;

import com.goorp.backend.api.exception.EntityNotFoundException;
import com.goorp.backend.domain.curriculum.Curriculum;
import com.goorp.backend.domain.member.Member;
import com.goorp.backend.domain.post.model.PostRequestDto;
import com.goorp.backend.domain.post.model.PostResponseDto;
import com.goorp.backend.domain.post.model.AllPostResponseDto;
import com.goorp.backend.api.exception.ErrorCode;
import com.goorp.backend.api.exception.PostException;
import com.goorp.backend.domain.curriculum.CurriculumRepository;
import com.goorp.backend.domain.member.MemberRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CurriculumRepository curriculumRepository;
    private final MemberRepository memberRepository;

    // CREATE
    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Curriculum curriculum = findCurriculum(requestDto.getCurriculumId());
        Member member = findMember(requestDto.getAccountId());

        Post post = requestDto.toEntity().toBuilder()
            .curriculum(curriculum)
            .member(member)
            .build();

        if (post.getStatus().equals("모집중")) {
            post.changeStatus("0");
        } else if (post.getStatus().equals("모집종료")) {
            post.changeStatus("1");
        }

        Post savedPost = postRepository.save(post);
        return PostResponseDto.of(savedPost);
    }

    // READ
    public PostResponseDto findPostById(Long postId) {
        Post post = findPost(postId);
        return PostResponseDto.of(post);
    }

    // READ
    public List<AllPostResponseDto> findAllPostsByCurriculum(
        Long curriculumId,
        int page,
        String classification,
        String sort,
        String stdsub,
        String stack,
        String status,
        String search
    ) {
        Specification<Post> spec = PostSpecification.filter(curriculumId, classification, stdsub,
            stack, status, search);
        Pageable pageable = PageRequest.of(page, 20, Sort.by(Sort.Direction.DESC, "updatedAt"));
        Page<Post> postPage = postRepository.findAll(spec, pageable);
        // Convert Post to PostResponseDTO
        return postPage.getContent().stream().map(AllPostResponseDto::of)
            .collect(Collectors.toList());
    }

    // UPDATE
    @Transactional
    public PostResponseDto updatePost(Long postId, PostRequestDto requestDTO) {
        Post existingPost = findPost(postId);
        Curriculum curriculum = findCurriculum(requestDTO.getCurriculumId());
        Member member = findMember(requestDTO.getAccountId());

        Post updatedPost = existingPost.toBuilder()
            .title(requestDTO.getTitle())
            .content(requestDTO.getContent())
            .classification(requestDTO.getClassification())
            .subjects(requestDTO.getSubject())
            .stacks(requestDTO.getStack())
            .recruitNum(requestDTO.getRecruitNum())
            .contactUrl(requestDTO.getContactUrl())
            .status(requestDTO.getStatus())
            .curriculum(curriculum)
            .member(member)
            .updatedAt(LocalDateTime.now())
            .build();

        if (updatedPost.getStatus().equals("모집중")) {
            updatedPost.changeStatus("0");
        } else if (updatedPost.getStatus().equals("모집종료")) {
            updatedPost.changeStatus("1");
        }

        postRepository.save(updatedPost);
        return PostResponseDto.of(updatedPost);
    }

    // DELETE
    @Transactional
    public void deletePost(Long postId) {
        if(postRepository.existsById(postId)) {
            postRepository.deleteById(postId);
        } else {
            throw new EntityNotFoundException(Post.class, postId);
        }
    }

    public long countAllPostsByCurriculum(
        Long curriculumId,
        String classification,
        String stdsub,
        String stack,
        String status,
        String search
    ) {
        Specification<Post> spec = PostSpecification.filter(curriculumId, classification, stdsub, stack, status, search);
        return postRepository.count(spec);
    }

    private Post findPost(Long postId) {
        return postRepository.findById(postId)
            .orElseThrow(() -> new EntityNotFoundException(Post.class, postId));
    }

    private Member findMember(String accountId) {
        return memberRepository.findByAccountId(accountId)
            .orElseThrow(() -> new EntityNotFoundException(Member.class, accountId));
    }

    private Curriculum findCurriculum(Long curriculumId) {
        return curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new EntityNotFoundException(Curriculum.class, curriculumId));
    }
}