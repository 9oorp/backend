package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostRequestDTO {
    private String title;
    private String content;
    private String classification;
    private String subject;
    private String stack;
    private int recruitNum;
    private String contactUrl;
    private String status;
    private Long curriculumId;
    private String accountId;
}