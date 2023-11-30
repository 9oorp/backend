package com.goorp.backend.domain.comment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentRequestDto {

    private String content;
    private Long parentCommentId;  // null이면 댓글, null이 아니면 대댓글
}