package com.goorp.backend.domain.post.model;

import java.time.LocalDateTime;

import com.goorp.backend.common.enums.Classification;
import com.goorp.backend.common.enums.Status;
import com.goorp.backend.domain.post.Post;
import com.goorp.backend.common.enums.Subject;
import com.goorp.backend.common.enums.TechStack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private Classification classification;
    private Set<Subject> subject;
    private Set<TechStack> stack;
    private int recruitNum;
    private String contactUrl;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String curriculumName;
    private String memberName;
    private String accountId;

    public static PostResponseDto of(Post post) {
        return new PostResponseDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getClassification(),
                post.getSubjects(),
                post.getStacks(),
                post.getRecruitNum(),
                post.getContactUrl(),
                post.getStatus(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getCurriculum().getName(),
                post.getMember().getName(),
                post.getMember().getAccountId()
        );
    }
}