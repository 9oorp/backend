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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final CurriculumRepository curriculumRepository;
    private final MemberRepository memberRepository;
    @Autowired
    public PostService(PostRepository postRepository, CurriculumRepository curriculumRepository, MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.curriculumRepository = curriculumRepository;
        this.memberRepository = memberRepository;
    }

    // CREATE
    @Transactional
    public void createPost(PostRequestDTO requestDTO, Long curriculumId, Long memberId) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, curriculumId + " 가 없습니다."));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, memberId + " 가 없습니다."));

        Post post = convertToEntity(requestDTO).toBuilder()
                .curriculum(curriculum)
                .member(member)
                .build();

        Post savedPost = postRepository.save(post);
        convertToResponseDTO(savedPost);
    }

    // READ
    public void findPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, postId + " 가 없습니다."));
        convertToResponseDTO(post);
    }

//    // READ
//    public List<PostResponseDTO> findAllPostsByCurriculum(Long curriculumId) {
//        List<Post> posts = postRepository.findByCurriculumId(curriculumId);
//        return posts.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
//    }

    // UPDATE
    @Transactional
    public void updatePost(Long postId, PostRequestDTO requestDTO, Long curriculumId, Long memberId) {
        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, postId + " 가 없습니다."));

        Curriculum curriculum = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, curriculumId + " 가 없습니다."));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, memberId + " 가 없습니다."));

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
                .updatedAt(LocalDate.now())
                .build();

        postRepository.save(updatedPost);
        convertToResponseDTO(updatedPost);
    }

    // DELETE
    @Transactional
    public void deletePost(Long postId) {
        postRepository.findById(postId)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, postId + " 가 없습니다."));
        postRepository.deleteById(postId);
    }

    private void convertToResponseDTO(Post post) {
        if (post == null) return;

        new PostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getClassification(),
                post.getSubject(),
                post.getStack(),
                post.getRecruitNum(),
                post.getContactUrl(),
                post.getStatus(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getCurriculum().getName(),
                post.getMember().getName()
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
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();
    }
}