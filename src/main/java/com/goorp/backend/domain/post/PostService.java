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
@RequiredArgsConstructor
@Transactional(readOnly = true)
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
        String subject,
        String techStack,
        String status,
        String search
    ) {
        Pageable pageable = PageRequest.of(page, 20, Sort.by(Sort.Direction.DESC, "updatedAt"));
        Page<Post> postPage = postRepository.findAll(curriculumId, classification, subject, techStack, status, search, pageable);
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

        postRepository.save(updatedPost);
        return PostResponseDto.of(updatedPost);
    }

    // DELETE
    @Transactional
    public void deletePost(Long postId) {
        findPost(postId);
        postRepository.deleteById(postId);
    }
}