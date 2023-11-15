package com.goorp.backend.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.goorp.backend.domain.vo.Subject;
import com.goorp.backend.domain.vo.TechStack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponseDTO {

    private Long id;
    private String title;
    private String content;
    private String classification;
    private Set<Subject> subject;
    private Set<TechStack> stack;
    private int recruitNum;
    private String contactUrl;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String curriculumName;
    private String memberName;
    private String accountId;
}