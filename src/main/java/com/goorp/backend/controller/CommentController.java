package com.goorp.backend.controller;

import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.dto.CommentDto;
import com.goorp.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // CREATE
    @PostMapping("/{postId}/comments")
    public ApiResponseDto createComment(@PathVariable Long postId, @RequestBody CommentDto commentDto) {
        CommentDto savedComment = commentService.createComment(postId, commentDto);
        return ApiResponseDto.builder()
                .ok(true)
                .data(Map.of("message", "comment 생성 성공", "comment", savedComment))
                .build();
    }

    // READ
    @GetMapping("/{postId}/comments")
    public ApiResponseDto getAllComments(@PathVariable Long postId) {
        List<CommentDto> comments = commentService.getAllComments(postId);
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