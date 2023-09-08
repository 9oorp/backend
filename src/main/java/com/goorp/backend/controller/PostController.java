package com.goorp.backend.controller;

import com.goorp.backend.dto.PostRequestDTO;
import com.goorp.backend.dto.PostResponseDTO;
import com.goorp.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/curriculum/{curriculumId}")
public class PostController {

    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // CREATE
    @PostMapping("/posts")
    public ResponseEntity<PostResponseDTO> createPost(@PathVariable Long curriculumId, @RequestBody PostRequestDTO requestDTO) {
        PostResponseDTO post = postService.createPost(curriculumId, requestDTO);
        return ResponseEntity.ok(post);
    }

    // READ
    // 페이지 넘버는 추후에
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostResponseDTO> getPostByCurriculumAndId(@PathVariable Long curriculumId, @PathVariable Long postId) {
        PostResponseDTO post = postService.findPostByCurriculumAndId(curriculumId, postId);
        return ResponseEntity.ok(post);
    }

    // READ
    // 페이지 넘버는 추후에
    @GetMapping("/posts")
    public ResponseEntity<List<PostResponseDTO>> getAllPostsByCurriculum(@PathVariable Long curriculumId) {
        List<PostResponseDTO> posts = postService.findAllPostsByCurriculum(curriculumId);
        return ResponseEntity.ok(posts);
    }

    // UPDATE
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostResponseDTO> updatePost(@PathVariable Long curriculumId, @PathVariable Long postId, @RequestBody PostRequestDTO requestDTO) {
        PostResponseDTO updatedPost = postService.updatePost(curriculumId, postId, requestDTO);
        return ResponseEntity.ok(updatedPost);
    }

    // DELETE
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long curriculumId, @PathVariable Long postId) {
        postService.deletePost(curriculumId, postId);
        return ResponseEntity.noContent().build();
    }
}