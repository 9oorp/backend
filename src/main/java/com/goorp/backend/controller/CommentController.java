package com.goorp.backend.controller;

import com.goorp.backend.configuration.MemberDetails;
import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.dto.CommentRequestDto;
import com.goorp.backend.dto.CommentResponseDto;
import com.goorp.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // CREATE
    @PostMapping("/{postId}/comments")
    public ApiResponseDto createComment(
        @PathVariable Long postId,
        @RequestBody CommentRequestDto commentRequestDto) {
        CommentResponseDto savedComment = commentService.createComment(postId, commentRequestDto);
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
    public ApiResponseDto deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        commentService.deleteComment(postId, commentId);
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("message", "comment 삭제 성공"))
            .build();
    }

}
