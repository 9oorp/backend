package com.goorp.backend.domain.comment;

import com.goorp.backend.domain.member.Member;
import com.goorp.backend.domain.post.Post;
import com.goorp.backend.domain.comment.model.CommentRequestDto;
import com.goorp.backend.domain.comment.model.CommentResponseDto;
import com.goorp.backend.api.exception.CommentException;
import com.goorp.backend.api.exception.ErrorCode;
import com.goorp.backend.domain.member.MemberRepository;
import com.goorp.backend.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    // CREATE
    @Transactional
    public CommentResponseDto createComment(Long postId, CommentRequestDto request, String accountId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new CommentException(ErrorCode.NOT_FOUND_POST, "postId 가 없습니다."));

        Member member = memberRepository.findByAccountId(accountId)
            .orElseThrow(
                () -> new CommentException(ErrorCode.NOT_FOUND_MEMBER,"멤버 ID를 찾을 수 없습니다: " + accountId));

        Comment parentComment = null;
        if (request.getParentCommentId() != null) {
            parentComment = commentRepository.findById(request.getParentCommentId())
                .orElseThrow(() -> new CommentException(ErrorCode.ID_NOT_FOUNT, "parentCommentId 가 없습니다."));

            if (parentComment.getParentComment() != null) {
                throw new CommentException(ErrorCode.NESTED_REPLY_EXCEPTION, "대댓글의 댓글은 허용되지 않습니다.");
            }
        }

        Comment comment = Comment.createComment(request.getContent(), member, post, parentComment);
        comment = commentRepository.save(comment);
        return CommentResponseDto.of(comment);
    }

    // READ
    public List<CommentResponseDto> getAllComments(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream()
            .filter(comment -> !comment.isReply())
            .map(CommentResponseDto::of)
            .toList();
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
}