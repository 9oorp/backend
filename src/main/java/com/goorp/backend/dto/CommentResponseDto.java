package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentResponseDto {
    private Long id;
    private String content;
    private int group;
    private int groupCnt;
    private int depth;
    private Long postId;
    private String memberName;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}