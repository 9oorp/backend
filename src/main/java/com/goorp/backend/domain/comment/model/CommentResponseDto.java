package com.goorp.backend.domain.comment.model;

import com.goorp.backend.domain.comment.Comment;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentResponseDto {

    private Long id;
    private String content;
    private int commentGroup;
    private int depth;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CommentResponseDto of(Comment comment) {
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