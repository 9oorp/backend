package com.goorp.backend.dto;

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
}