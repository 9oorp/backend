package com.goorp.backend.controller;

import com.goorp.backend.domain.Post;
import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.dto.MemberJoinDto;
import com.goorp.backend.dto.MemberLoginDto;
import com.goorp.backend.dto.PostResponseDTO;
import com.goorp.backend.repository.PostRepository;
import com.goorp.backend.service.MemberService;
import com.goorp.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;
    private final PostService postService;
    private final PostRepository postRepository;

    @PostMapping("/join")
    public ApiResponseDto join(@Validated @RequestBody MemberJoinDto dto) {

        memberService.join(dto.getAccountId(), dto.getPassword(), dto.getPasswordConfirm(), dto.getMemberName());
        return ApiResponseDto.builder()
                .ok(true)
                .data(Map.of("message", "회원가입 성공"))
                .build();
    }
    @PostMapping("/login")
    public ApiResponseDto login(@Validated @RequestBody MemberLoginDto dto) {
        Map<String, String> tokens = memberService.login(dto.getAccountId(), dto.getPassword());
        return ApiResponseDto.builder()
                .ok(true)
                .data(Map.of("accessToken", tokens.get("accessToken"), "refreshToken", tokens.get("refreshToken")))
                .build();
    }

    @GetMapping("/{accountId}/posts")
    public ApiResponseDto getMemberPosts(@PathVariable String accountId) {
        PageRequest pageRequest = PageRequest.of(0, 8, Sort.by(Sort.Direction.DESC, "createdAt"));
        List<Post> findAllPost = postRepository.findByMember_AccountId(accountId, pageRequest).getContent();
        List<PostResponseDTO> posts = findAllPost.stream()
                .map(postService::PostToResponseDTO)
                .toList();

        return ApiResponseDto.builder()
                .ok(true)
                .data(Map.of("Posts",posts))
                .build();
    }
}