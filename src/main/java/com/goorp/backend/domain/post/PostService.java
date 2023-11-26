package com.goorp.backend.domain.post;

import com.goorp.backend.api.exception.CommentException;
import com.goorp.backend.api.exception.ErrorCode;
import com.goorp.backend.api.exception.PostException;
import com.goorp.backend.domain.curriculum.Curriculum;
import com.goorp.backend.domain.curriculum.CurriculumRepository;
import com.goorp.backend.domain.member.Member;
import com.goorp.backend.domain.member.MemberRepository;
import com.goorp.backend.domain.post.model.AllPostResponseDto;
import com.goorp.backend.domain.post.model.PostRequestDto;
import com.goorp.backend.domain.post.model.PostResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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
    public PostResponseDto updatePost(Long postId, PostRequestDto requestDTO, Long memberId) {
        Post existingPost = findPost(postId);
        Curriculum curriculum = findCurriculum(requestDTO.getCurriculumId());
        findMember(requestDTO.getAccountId());
        validatePostAuthor(memberId, existingPost);
        existingPost.update(requestDTO, curriculum);

        postRepository.save(existingPost);
        return PostResponseDto.of(existingPost);
    }

    // DELETE
    @Transactional
    public void deletePost(Long postId, Long memberId) {
        Post findPost = findPost(postId);
        validatePostAuthor(memberId, findPost);
        postRepository.deleteById(postId);
    }

    private static void validatePostAuthor(Long memberId, Post post) {
        if (!post.validation(memberId)) {
            throw new CommentException(ErrorCode.UNAUTHORIZED, "포스트 작성자가 아닙니다.");
        }
    }

    private Post findPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUND, id + " 가 없습니다."));
    }

    private Member findMember(String accountId) {
        return memberRepository.findByAccountId(accountId)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUND, accountId + " 가 없습니다."));
    }

    private Curriculum findCurriculum(Long id) {
        return curriculumRepository.findById(id)
                .orElseThrow(() -> new PostException(ErrorCode.ID_NOT_FOUND, id + " 가 없습니다."));
    }
}