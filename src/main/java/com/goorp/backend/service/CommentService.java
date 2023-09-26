package com.goorp.backend.service;

import com.goorp.backend.domain.Comment;
import com.goorp.backend.domain.Member;
import com.goorp.backend.domain.Post;
import com.goorp.backend.dto.CommentDto;
import com.goorp.backend.exception.CommentException;
import com.goorp.backend.exception.ErrorCode;
import com.goorp.backend.repository.CommentRepository;
import com.goorp.backend.repository.MemberRepository;
import com.goorp.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;


    @Autowired
    public CommentService(CommentRepository commentRepository, PostRepository postRepository, MemberRepository memberRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    // CREATE
    @Transactional
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new CommentException(ErrorCode.ID_NOT_FOUNT, "postId 가 없습니다."));

        Member member = memberRepository.findByName(commentDto.getMemberName())
                .orElseThrow(() -> new CommentException(ErrorCode.ID_NOT_FOUNT, "MemberName 이 없습니다."));

        Comment comment = Comment.builder()
                .post(post)
                .member(member)
                .content(commentDto.getContent())
                .group(commentDto.getGroup())
                .groupCnt(commentDto.getGroupCnt())
                .depth(commentDto.getDepth())
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();

        Comment savedComment = commentRepository.save(comment);
        return commentDto(savedComment);
    }

    // READ
    public List<CommentDto> getAllComments(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(this::commentDto).collect(Collectors.toList());
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

    public CommentDto commentDto(Comment comment){
        if (comment==null) return null;

        return new CommentDto(
                comment.getId(),
                comment.getContent(),
                comment.getGroup(),
                comment.getGroupCnt(),
                comment.getDepth(),
                comment.getCreatedAt(),
                comment.getUpdatedAt(),
                comment.getPost().getId(),
                comment.getMember().getName()
        );
    }

}





