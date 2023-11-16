package com.goorp.backend.domain.comment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentRequestDto {

    private String content;
    private int parentCommentId;  // 0이면 댓글, 0이 아니면 대댓글

    public boolean hasParentComment() {
        return parentCommentId > 0;
    }
}