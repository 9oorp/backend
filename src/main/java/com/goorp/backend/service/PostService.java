package com.goorp.backend.service;

import com.goorp.backend.domain.Curriculum;
import com.goorp.backend.domain.Member;
import com.goorp.backend.domain.Post;
import com.goorp.backend.dto.PostRequestDTO;
import com.goorp.backend.dto.PostResponseDTO;
import com.goorp.backend.exception.ErrorCode;
import com.goorp.backend.exception.PostException;
import com.goorp.backend.repository.CurriculumRepository;
import com.goorp.backend.repository.MemberRepository;
import com.goorp.backend.repository.PostRepository;
import com.goorp.backend.repository.PostSpecification;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public PostResponseDTO createPost(PostRequestDTO requestDTO) {
        Curriculum curriculum = curriculumRepository.findById(requestDTO.getCurriculumId())
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, " curriculum 이 없습니다."));

        Member member = memberRepository.findByAccountId(requestDTO.getAccountId())
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, " memberId 가 없습니다."));
        Post post = convertToEntity(requestDTO).toBuilder()
            .curriculum(curriculum)
            .member(member)
            .build();

        if (post.getStatus().equals("모집중")) {
            post.changeStatus("0");
        } else if (post.getStatus().equals("모집종료")) {
            post.changeStatus("1");
        }

        Post savedPost = postRepository.save(post);
        return convertToResponseDTO(savedPost);
    }

    // READ
    public PostResponseDTO findPostById(Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, postId + " 가 없습니다."));
        return convertToResponseDTO(post);
    }

    // READ
    public List<PostResponseDTO> findAllPostsByCurriculum(
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
        return postPage.getContent().stream().map(this::convertToResponseDTO)
            .collect(Collectors.toList());
    }

    // UPDATE
    @Transactional
    public PostResponseDTO updatePost(Long postId, PostRequestDTO requestDTO) {
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
            .subject(requestDTO.getSubject())
            .stack(requestDTO.getStack())
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
        return convertToResponseDTO(updatedPost);
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

    public PostResponseDTO convertToResponseDTO(Post post) {
        if (post == null) {
            return null;
        }

        List<String> subjectList = Arrays.stream(post.getSubject().split(","))
            .map(String::trim)
            .collect(Collectors.toList());

        List<String> stackList = Arrays.stream(post.getStack().split(","))
            .map(String::trim)
            .collect(Collectors.toList());

        return new PostResponseDTO(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            post.getClassification(),
            subjectList,
            stackList,
            post.getRecruitNum(),
            post.getContactUrl(),
            post.getStatus(),
            post.getCreatedAt(),
            post.getUpdatedAt(),
            post.getCurriculum().getName(),
            post.getMember().getName(),
            post.getMember().getAccountId()
        );
    }

    private Post convertToEntity(PostRequestDTO requestDTO) {
        return Post.builder()
            .title(requestDTO.getTitle())
            .content(requestDTO.getContent())
            .classification(requestDTO.getClassification())
            .subject(requestDTO.getSubject())
            .stack(requestDTO.getStack())
            .recruitNum(requestDTO.getRecruitNum())
            .contactUrl(requestDTO.getContactUrl())
            .status(requestDTO.getStatus())
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
    }
}