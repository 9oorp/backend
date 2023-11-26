package com.goorp.backend.domain.post.model;

import com.goorp.backend.common.enums.Classification;
import com.goorp.backend.common.enums.Status;
import com.goorp.backend.common.enums.Subject;
import com.goorp.backend.common.enums.TechStack;
import com.goorp.backend.domain.post.Post;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostRequestDto {

    private String title;
    private String content;
    private String classification;
    private String subject;
    private String techStack;
    private int recruitNum;
    private String contactUrl;
    private String status;
    private Long curriculumId;
    private String accountId;

    public Set<Subject> getSubject() {
        return Arrays.stream(extract(subject))
                .map(String::trim)
                .map(Subject::valueOf)
                .collect(Collectors.toSet());
    }

    public Set<TechStack> getStack() {
       return Arrays.stream(extract(techStack))
                .map(String::trim)
                .map(TechStack::valueOf)
                .collect(Collectors.toSet());
    }

    private String[] extract(String fullStr) {
        fullStr = fullStr.replace("[", "");
        fullStr = fullStr.replace("]", "");
        return fullStr.split(",");
    }

    public Classification getClassification(){
        return Classification.valueOf(classification);
    }

    public Status getStatus(){
        return Status.valueOf(status);
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .classification(getClassification())
                .subjects(getSubject())
                .stacks(getStack())
                .recruitNum(recruitNum)
                .contactUrl(contactUrl)
                .status(getStatus())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}