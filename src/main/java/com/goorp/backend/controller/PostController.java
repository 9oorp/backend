package com.goorp.backend.controller;

import com.goorp.backend.domain.Post;
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
    public ApiResponseDto createPost(@RequestBody PostRequestDTO requestDTO, @RequestParam Long curriculumId, @RequestParam Long memberId) {
        PostResponseDTO responseDTO = postService.createPost(requestDTO, curriculumId, memberId);
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
    @GetMapping
    public ResponseEntity<ApiResponseDto> getAllPostsByCurriculum(@RequestParam Long curriculumId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        List<PostResponseDTO> postResponseDTO = postService.findAllPostsByCurriculum(curriculumId, page, size);
        return ResponseEntity.ok(
                ApiResponseDto.builder()
                        .ok(true)
                        .data(Map.of("message", "포스트 목록 조회 성공", "posts", postResponseDTO))
                        .build()
        );
    }


    // UPDATE
    @PutMapping("/posts/{postId}")
    public ApiResponseDto updatePost(@PathVariable Long postId, @RequestBody PostRequestDTO requestDTO, @RequestParam Long curriculumId, @RequestParam Long memberId) {
        PostResponseDTO postResponseDTO = postService.updatePost(postId, requestDTO, curriculumId, memberId);
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