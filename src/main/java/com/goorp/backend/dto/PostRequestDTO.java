package com.goorp.backend.dto;

import com.goorp.backend.domain.vo.Subject;
import com.goorp.backend.domain.vo.TechStack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<Subject> getSubject() {
        return Arrays.stream(extract(subject))
                .map(String::trim)
                .map(Subject::valueOf)
                .collect(Collectors.toSet());
    }

    public Set<TechStack> getStack() {
       return Arrays.stream(extract(stack))
                .map(String::trim)
                .map(TechStack::valueOf)
                .collect(Collectors.toSet());
    }

    private String[] extract(String fullStr) {
        fullStr = fullStr.replace("[", "");
        fullStr = fullStr.replace("]", "");
        return fullStr.split(",");
    }

}