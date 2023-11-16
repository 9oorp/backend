package com.goorp.backend.domain.comment;

import com.goorp.backend.common.login.MemberDetails;
import com.goorp.backend.api.response.ApiResponseDto;
import com.goorp.backend.domain.comment.model.CommentRequestDto;
import com.goorp.backend.domain.comment.model.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // CREATE
    @PostMapping("/{postId}/comments")
    public ApiResponseDto createComment(
        @PathVariable Long postId,
        @RequestBody CommentRequestDto commentRequestDto,
        @AuthenticationPrincipal MemberDetails memberDetails
        ) {
        CommentResponseDto savedComment = commentService.createComment(postId, commentRequestDto, memberDetails.getAccountId());
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("message", "comment 생성 성공", "comment", savedComment))
            .build();
    }

    // READ
    @GetMapping("/{postId}/comments")
    public ApiResponseDto getAllComments(@PathVariable Long postId) {
        List<CommentResponseDto> comments = commentService.getAllComments(postId);
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("message", "comment 조회 성공", "comments", comments))
            .build();
    }

    // DELETE
    @DeleteMapping("/{postId}/comments/{commentId}")
    public ApiResponseDto deleteComment(
        @PathVariable Long postId,
        @PathVariable Long commentId
    ) {
        commentService.deleteComment(postId, commentId);
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("message", "comment 삭제 성공"))
            .build();
    }
}
