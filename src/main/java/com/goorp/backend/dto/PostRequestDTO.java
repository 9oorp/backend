package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostRequestDTO {
    private String title;
    private String content;
    private String classification;
    private String subject;
    private int recruitNum;
    private String contactUrl;
    private String status;
    private Long curriculumId;
    private Long memberId;
}
