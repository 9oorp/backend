package com.goorp.backend.service;

import com.goorp.backend.domain.Curriculum;
import com.goorp.backend.domain.Post;
import com.goorp.backend.dto.PostRequestDTO;
import com.goorp.backend.dto.PostResponseDTO;
import com.goorp.backend.exception.ErrorCode;
import com.goorp.backend.exception.PostException;
import com.goorp.backend.repository.CurriculumRepository;
import com.goorp.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final CurriculumRepository curriculumRepository;
    @Autowired
    public PostService(PostRepository postRepository, CurriculumRepository curriculumRepository) {
        this.postRepository = postRepository;
        this.curriculumRepository = curriculumRepository;
    }

    // CREATE
    @Transactional
    public PostResponseDTO createPost(Long curriculumId, PostRequestDTO requestDTO) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId)
//                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 커리큘럼 ID 입니다"));
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUNT, "올바르지 않은 커리큘럼 ID 입니다"));

        Post post = convertToEntity(requestDTO).toBuilder().curriculum(curriculum).build();
        Post savedPost = postRepository.save(post);
        return convertToResponseDTO(savedPost);
    }

    // READ
    public PostResponseDTO findPostByCurriculumAndId(Long curriculumId, Long postId) {
        // Ensure Curriculum exists
        curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 커리큘럼 ID 입니다"));

        Post post = postRepository.findByCurriculumIdAndId(curriculumId, postId)
                .orElseThrow(() -> new IllegalArgumentException("검색 결과가 존재하지 않습니다"));
        return convertToResponseDTO(post);
    }

    // READ
    public List<PostResponseDTO> findAllPostsByCurriculum(Long curriculumId) {
        List<Post> posts = postRepository.findByCurriculumId(curriculumId);
        return posts.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    // UPDATE
    @Transactional
    public PostResponseDTO updatePost(Long curriculumId, Long postId, PostRequestDTO requestDTO) {
        Curriculum curriculum = curriculumRepository.findById(curriculumId)
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 커리큘럼 ID 입니다"));

        Post existingPost = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 게시글을 찾을 수 없습니다."));

        Post updatedPost = existingPost.toBuilder()
                .title(requestDTO.getTitle())
                .content(requestDTO.getContent())
                .classification(requestDTO.getClassification())
                .subject(requestDTO.getSubject())
                .recruitNum(requestDTO.getRecruitNum())
                .contactUrl(requestDTO.getContactUrl())
                .status(requestDTO.getStatus())
                .updatedAt(LocalDate.now())
                .curriculum(curriculum)
                .build();

        postRepository.save(updatedPost);
        return convertToResponseDTO(updatedPost);
    }

    // DELETE
    @Transactional
    public void deletePost(Long curriculumId, Long postId) {
        postRepository.findByCurriculumIdAndId(curriculumId, postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 게시글을 찾을 수 없습니다."));
        postRepository.deleteById(postId);
    }

    private PostResponseDTO convertToResponseDTO(Post post) {
        if (post == null) return null;

        return new PostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getClassification(),
                post.getSubject(),
                post.getRecruitNum(),
                post.getContactUrl(),
                post.getStatus(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getCurriculum().getName()
        );
    }

    private Post convertToEntity(PostRequestDTO requestDTO) {
        if (requestDTO == null) return null;

        Curriculum curriculum = null;
        if (requestDTO.getCurriculumId() != null) {
            curriculum = curriculumRepository.findById(requestDTO.getCurriculumId())
                    .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 커리큘럼 ID 입니다: " + requestDTO.getCurriculumId()));
        }

        Post post = Post.builder()
                .title(requestDTO.getTitle())
                .content(requestDTO.getContent())
                .classification(requestDTO.getClassification())
                .subject(requestDTO.getSubject())
                .recruitNum(requestDTO.getRecruitNum())
                .contactUrl(requestDTO.getContactUrl())
                .status(requestDTO.getStatus())
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .curriculum(curriculum)
                .build();

        return post;
    }
}