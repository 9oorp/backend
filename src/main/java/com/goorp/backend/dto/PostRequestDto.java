package com.goorp.backend.dto;

import com.goorp.backend.domain.Post;
import com.goorp.backend.domain.vo.Subject;
import com.goorp.backend.domain.vo.TechStack;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .classification(classification)
                .subjects(getSubject())
                .stacks(getStack())
                .recruitNum(recruitNum)
                .contactUrl(contactUrl)
                .status(status)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}