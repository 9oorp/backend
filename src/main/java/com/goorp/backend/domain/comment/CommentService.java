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
            .orElseThrow(() -> new CommentException(ErrorCode.ID_NOT_FOUNT, "postId 가 없습니다."));

        Member member = memberRepository.findByAccountId(accountId)
            .orElseThrow(
                () -> new CommentException(ErrorCode.NOT_FOUND_MEMBER,"멤버 ID를 찾을 수 없습니다: " + accountId));

        Comment comment = getComment(request, member, post);
        comment = commentRepository.save(comment);
        comment.updateCommentGroup();
        return commentResponseDto(comment);
    }

    // READ
    public List<CommentResponseDto> getAllComments(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(CommentResponseDto::of).toList();
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

    private Comment getComment(CommentRequestDto request, Member member, Post post) {
        Comment comment;
        if (request.hasParentComment()) {
            Comment parentComment = commentRepository.findById((long) request.getParentCommentId())
                .orElseThrow(() -> new CommentException(ErrorCode.NOT_FOUND_COMMENT, "부모 댓글 ID를 찾을 수 없습니다: " + request.getParentCommentId()));
            comment = Comment.replyToComment(request.getContent(), member, post, parentComment);
        } else {
            comment = Comment.createComment(request.getContent(), member, post);
        }
        return comment;
    }

    private CommentResponseDto commentResponseDto(Comment comment) {
        if (comment == null) {
            return null;
        }
        return CommentResponseDto.of(comment);
    }
}






