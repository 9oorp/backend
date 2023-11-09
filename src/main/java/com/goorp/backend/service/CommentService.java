package com.goorp.backend.service;

import com.goorp.backend.domain.Comment;
import com.goorp.backend.domain.Member;
import com.goorp.backend.domain.Post;
import com.goorp.backend.dto.CommentRequestDto;
import com.goorp.backend.dto.CommentResponseDto;
import com.goorp.backend.exception.CommentException;
import com.goorp.backend.exception.ErrorCode;
import com.goorp.backend.repository.CommentRepository;
import com.goorp.backend.repository.MemberRepository;
import com.goorp.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;


    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository,
        MemberRepository memberRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    // CREATE
    @Transactional
    public CommentResponseDto createComment(Long postId, CommentRequestDto request,
        String accountId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new IllegalArgumentException("포스트 ID를 찾을 수 없습니다: " + postId));

        Member member = memberRepository.findByAccountId(accountId)
            .orElseThrow(
                () -> new IllegalArgumentException("멤버 ID를 찾을 수 없습니다: " + accountId));

        Comment comment;
        if (request.hasParentComment()) {
            Comment parentComment = commentRepository.findById((long) request.getParentCommentId())
                .orElseThrow(() -> new IllegalArgumentException(
                    "부모 댓글 ID를 찾을 수 없습니다: " + request.getParentCommentId()));
            comment = Comment.replyToComment(request.getContent(), member, post, parentComment);
        } else {
            comment = Comment.createComment(request.getContent(), member, post);
        }

        comment = commentRepository.save(comment);
        comment.updateCommentGroup();

        return commentResponseDto(comment);
    }

    // READ
    public List<CommentResponseDto> getAllComments(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(this::commentResponseDto).collect(Collectors.toList());
    }

    // DELETE
    @Transactional
    public void deleteComment(Long postId, Long commentId) {
        postRepository.findById(postId)
            .orElseThrow(() -> new CommentException(ErrorCode.ID_NOT_FOUNT, "postId 가 없습니다."));
        commentRepository.findById(commentId)
            .orElseThrow(() -> new CommentException(ErrorCode.ID_NOT_FOUNT, "commentId 가 없습니다."));
        commentRepository.deleteById(commentId);
    }

    private CommentResponseDto commentResponseDto(Comment comment) {
        if (comment == null) {
            return null;
        }
        return new CommentResponseDto(
            comment.getId(),
            comment.getContent(),
            comment.getCommentGroup(),
            comment.getDepth(),
            comment.getCreatedAt(),
            comment.getUpdatedAt()
        );
    }
}






