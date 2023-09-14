package com.goorp.backend.controller;

import com.goorp.backend.domain.Post;
import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.dto.PostRequestDTO;
import com.goorp.backend.dto.PostResponseDTO;
import com.goorp.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        postService.createPost(requestDTO, curriculumId, memberId);
        return ApiResponseDto.builder()
                .ok(true)
                .data(Map.of("message", "post 생성 성공"))
                .build();
    }

    // READ
    @GetMapping("/posts/{postId}")
    public ApiResponseDto getPostById(@PathVariable Long postId) {
        Post postById = postService.findPostById(postId);
        PostResponseDTO postResponseDTO = postService.PostToResponseDTO(postById);
        return ApiResponseDto.builder()
                .ok(true)
                .data(Map.of("message", "단일 post 조회 성공", "post", postResponseDTO))
                .build();
    }

    // READ
    // 페이지 넘버는 추후에
//    @GetMapping
//    public ResponseEntity<List<PostResponseDTO>> getAllPostsByCurriculum(@RequestParam Long curriculumId) {
//        List<PostResponseDTO> posts = postService.findAllPostsByCurriculum(curriculumId);
//        return ResponseEntity.ok(posts);
//    }

    // UPDATE
    @PutMapping("/posts/{postId}")
    public ApiResponseDto updatePost(@PathVariable Long postId, @RequestBody PostRequestDTO requestDTO, @RequestParam Long curriculumId, @RequestParam Long memberId) {
        postService.updatePost(postId, requestDTO, curriculumId, memberId);
        return ApiResponseDto.builder()
                .ok(true)
                .data(Map.of("message", "post 업데이트 성공"))
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