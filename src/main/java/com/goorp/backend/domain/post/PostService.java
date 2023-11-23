package com.goorp.backend.domain.post;

import com.goorp.backend.common.enums.Classification;
import com.goorp.backend.common.enums.Status;
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
import org.springframework.beans.factory.annotation.Autowired;
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
public class PostService {

    private final PostRepository postRepository;
    private final CurriculumRepository curriculumRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public PostService(PostRepository postRepository, CurriculumRepository curriculumRepository,
        MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.curriculumRepository = curriculumRepository;
        this.memberRepository = memberRepository;
    }

    // CREATE
    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Curriculum curriculum = curriculumRepository.findById(requestDto.getCurriculumId())
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, " curriculum 이 없습니다."));

        Member member = memberRepository.findByAccountId(requestDto.getAccountId())
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, " memberId 가 없습니다."));

        Post post = requestDto.toEntity().toBuilder()
            .curriculum(curriculum)
            .member(member)
            .build();

//        if (post.getStatus().equals("모집중")) {
//            post.changeStatus("0");
//        } else if (post.getStatus().equals("모집종료")) {
//            post.changeStatus("1");
//        }

        Post savedPost = postRepository.save(post);
        return PostResponseDto.of(savedPost);
    }

    // READ
    public PostResponseDto findPostById(Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, postId + " 가 없습니다."));
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
//        Specification<Post> spec = PostSpecification.filter(curriculumId, classification, stdsub,
//            stack, status, search);
//        Specification<Post> spec = PostSpecification.filter(curriculumId, classification, stdsub,
//                stack, status, search);
        Pageable pageable = PageRequest.of(page, 20, Sort.by(Sort.Direction.DESC, "updatedAt"));
        Page<Post> postPage = postRepository.findAll(curriculumId, classification, sort, stdsub, stack, status, search, pageable);
        // Convert Post to PostResponseDTO
        return postPage.getContent().stream().map(AllPostResponseDto::of)
            .collect(Collectors.toList());
    }

    // UPDATE
    @Transactional
    public PostResponseDto updatePost(Long postId, PostRequestDto requestDTO) {
        Post existingPost = postRepository.findById(postId)
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, postId + " 가 없습니다."));

        Curriculum curriculum = curriculumRepository.findById(requestDTO.getCurriculumId())
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, "curriculumId 가 없습니다."));

        Member member = memberRepository.findByAccountId(requestDTO.getAccountId())
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, "memberId 가 없습니다."));

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

//        if (updatedPost.getStatus().equals("모집중")) {
//            updatedPost.changeStatus("0");
//        } else if (updatedPost.getStatus().equals("모집종료")) {
//            updatedPost.changeStatus("1");
//        }

        postRepository.save(updatedPost);
        return PostResponseDto.of(updatedPost);
    }

    // DELETE
    @Transactional
    public void deletePost(Long postId) {
        postRepository.findById(postId)
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, postId + " 가 없습니다."));
        postRepository.deleteById(postId);
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
}