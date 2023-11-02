package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentRequestDto {

    private String content;
    private int group;
    private int groupCnt;
    private int depth;
    private Long postId;
    private String memberName;
}