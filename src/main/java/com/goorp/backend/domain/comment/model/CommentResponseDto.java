package com.goorp.backend.domain.comment.model;

import com.goorp.backend.domain.comment.Comment;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentResponseDto {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long memberId;
    private String accountId;
    private List<CommentResponseDto> replies;

    public static CommentResponseDto of(Comment comment) {
        List<CommentResponseDto> replies = comment.getReplies() != null
            ? comment.getReplies().stream()
            .map(CommentResponseDto::of)
            .collect(Collectors.toList())
            : Collections.emptyList();

        return new CommentResponseDto(
            comment.getId(),
            comment.getContent(),
            comment.getCreatedAt(),
            comment.getUpdatedAt(),
            comment.getMember().getId(),
            comment.getMember().getName(),
            replies
        );
    }
}