package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentDto {

    private Long id;
    private String content;
    private int group;
    private int groupCnt;
    private int depth;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long postId;
    private String memberName;

}
