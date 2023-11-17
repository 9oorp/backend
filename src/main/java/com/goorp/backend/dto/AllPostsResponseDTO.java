package com.goorp.backend.dto;

import com.goorp.backend.domain.vo.Subject;
import com.goorp.backend.domain.vo.TechStack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AllPostsResponseDTO {

    private Long id;
    private String title;
    private Set<Subject> subject;
    private Set<TechStack> stack;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String memberName;
    private String accountId;
    private int commentNum;
}
