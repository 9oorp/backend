package com.goorp.backend.domain.comment;

import com.goorp.backend.api.exception.CommentException;
import com.goorp.backend.api.exception.ErrorCode;
import com.goorp.backend.domain.comment.model.CommentRequestDto;
import com.goorp.backend.domain.comment.model.CommentResponseDto;
import com.goorp.backend.domain.comment.model.CommentUpdateDto;
import com.goorp.backend.domain.member.Member;
import com.goorp.backend.domain.member.MemberRepository;
import com.goorp.backend.domain.post.Post;
import com.goorp.backend.domain.post.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        Post post = finPostByPostId(postId);
        Member member = findMemberByMemberId(accountId);

        Comment parentComment = null;
        if (request.getParentCommentId() != null) {
            parentComment = commentRepository.findById(request.getParentCommentId())
                .orElseThrow(() -> new CommentException(ErrorCode.ID_NOT_FOUND, "parentCommentId 가 없습니다."));

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

    // UPDATE
    public CommentResponseDto updateComment(Long commentId, CommentUpdateDto commentUpdateDto, Long memberId) {
        // 검증하고 댓글 내용 업데이트
        Comment comment = findCommentByCommentId(commentId);
        validateCommentAuthor(memberId, comment);
        comment.updateComment(commentUpdateDto.getContent());
        return CommentResponseDto.of(comment);
    }

    // DELETE
    @Transactional
    public void deleteComment(Long postId, Long commentId, Long memberId) {
        finPostByPostId(postId);
        Comment findComment = findCommentByCommentId(commentId);
        validateCommentAuthor(memberId, findComment);

        commentRepository.deleteById(commentId);
    }

    private static void validateCommentAuthor(Long memberId, Comment comment) {
        if (!comment.validation(memberId)) {
            throw new CommentException(ErrorCode.UNAUTHORIZED, "댓글 작성자가 아닙니다.");
        }
    }

    private Comment findCommentByCommentId(Long commentId) {
        return commentRepository.findById(commentId)
            .orElseThrow(() -> new CommentException(ErrorCode.ID_NOT_FOUND, "commentId 가 없습니다."));
    }

    private Member findMemberByMemberId(String accountId) {
        return memberRepository.findByAccountId(accountId)
            .orElseThrow(
                () -> new CommentException(ErrorCode.NOT_FOUND_MEMBER,"멤버 ID를 찾을 수 없습니다: " + accountId));
    }

    private Post finPostByPostId(Long postId) {
        return postRepository.findById(postId)
            .orElseThrow(() -> new CommentException(ErrorCode.ID_NOT_FOUND, "postId 가 없습니다."));
    }
}