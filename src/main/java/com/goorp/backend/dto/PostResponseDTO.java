package com.goorp.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
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
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String curriculumName;
    private String memberName;
    private String accountId;
}