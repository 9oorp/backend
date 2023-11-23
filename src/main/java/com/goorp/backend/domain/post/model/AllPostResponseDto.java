package com.goorp.backend.domain.post.model;

import com.goorp.backend.common.enums.Status;
import com.goorp.backend.common.enums.Subject;
import com.goorp.backend.common.enums.TechStack;
import com.goorp.backend.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AllPostResponseDto {

    private Long id;
    private String title;
    private Set<Subject> subject;
    private Set<TechStack> stack;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String memberName;
    private String curriculumName;
    private int commentNum;

    public static AllPostResponseDto of(Post post) {
        return new AllPostResponseDto(
                post.getId(),
                post.getTitle(),
                post.getSubjects(),
                post.getStacks(),
                post.getStatus(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getCurriculum().getName(),
                post.getMember().getName(),
                post.getComments().size()
        );
    }
}
