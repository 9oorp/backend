package com.goorp.backend.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String classification;
    private List<String> subject;
    private List<String> stack;
    private int recruitNum;
    private String contactUrl;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String curriculumName;
    private String memberName;
    private String accountId;
}