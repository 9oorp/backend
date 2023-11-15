package com.goorp.backend.controller;

import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.dto.PostRequestDto;
import com.goorp.backend.dto.PostResponseDto;
import com.goorp.backend.service.PostService;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // CREATE
    @PostMapping("/posts")
    public ApiResponseDto createPost(@RequestBody PostRequestDto requestDTO) {
        PostResponseDto responseDTO = postService.createPost(requestDTO);
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("message", "post 생성 성공", "post", responseDTO))
            .build();
    }

    // READ
    @GetMapping("/posts/{postId}")
    public ApiResponseDto getPostById(@PathVariable Long postId) {
        PostResponseDto postResponseDTO = postService.findPostById(postId);
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("message", "단일 post 조회 성공", "post", postResponseDTO))
            .build();
    }

    // READ
    @GetMapping("/curriculum/{curriculumId}/posts")
    public ResponseEntity<ApiResponseDto> getAllPostsByCurriculum(
        @PathVariable Long curriculumId,
        @RequestParam int page,
        @RequestParam String classification,
        @RequestParam String sort,
        @RequestParam(required = false) String subject,
        @RequestParam(required = false) String stack,
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String search
    ) {
        List<PostResponseDto> postResponseDto = postService.findAllPostsByCurriculum(curriculumId,
            page, classification, sort, subject, stack, status, search);

        long totalCount = postService.countAllPostsByCurriculum(curriculumId, classification,
            subject, stack, status, search);

        return ResponseEntity.ok(
            ApiResponseDto.builder()
                .ok(true)
                .data(Map.of("message", "포스트 목록 조회 성공",
                    "posts", postResponseDto,
                    "totalCount", totalCount))
                .build()
        );
    }

    // UPDATE
    @PutMapping("/posts/{postId}")
    public ApiResponseDto updatePost(@PathVariable Long postId,
        @RequestBody PostRequestDto requestDTO) {
        PostResponseDto postResponseDTO = postService.updatePost(postId, requestDTO);
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("message", "post 업데이트 성공", "post", postResponseDTO))
            .build();
    }

    // DELETE
    @DeleteMapping("/posts/{postId}")
    public ApiResponseDto deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("message", "post 삭제 성공"))
            .build();
    }
}