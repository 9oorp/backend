package com.goorp.backend.controller;

import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.dto.PostRequestDTO;
import com.goorp.backend.dto.PostResponseDTO;
import com.goorp.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ApiResponseDto createPost(@RequestBody PostRequestDTO requestDTO) {
        PostResponseDTO responseDTO = postService.createPost(requestDTO);
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("message", "post 생성 성공", "post", responseDTO))
            .build();
    }

    // READ
    @GetMapping("/posts/{postId}")
    public ApiResponseDto getPostById(@PathVariable Long postId) {
        PostResponseDTO postResponseDTO = postService.findPostById(postId);
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
        @RequestParam(required = false) String stdsub,
        @RequestParam(required = false) String stack,
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String search
    ) {
        List<PostResponseDTO> postResponseDTO = postService.findAllPostsByCurriculum(curriculumId,
            page, classification, sort, stdsub, stack, status, search);

        long totalCount = postService.countAllPostsByCurriculum(curriculumId, classification,
            stdsub, stack, status, search);

        return ResponseEntity.ok(
            ApiResponseDto.builder()
                .ok(true)
                .data(Map.of("message", "포스트 목록 조회 성공",
                    "posts", postResponseDTO,
                    "totalCount", totalCount))
                .build()
        );
    }

    // UPDATE
    @PutMapping("/posts/{postId}")
    public ApiResponseDto updatePost(@PathVariable Long postId,
        @RequestBody PostRequestDTO requestDTO) {
        PostResponseDTO postResponseDTO = postService.updatePost(postId, requestDTO);
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