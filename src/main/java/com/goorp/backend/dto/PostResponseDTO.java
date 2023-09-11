package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponseDTO {
    private Long id;
    private String title;
    private String content;
    private String classification;
    private String subject;
    private int recruitNum;
    private String contactUrl;
    private String status;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String curriculumName;
}