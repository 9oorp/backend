package com.goorp.backend.controller;

import com.goorp.backend.configuration.MemberDetails;
import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.dto.MemberJoinDto;
import com.goorp.backend.dto.MemberLoginDto;
import com.goorp.backend.dto.PostResponseDTO;
import com.goorp.backend.service.MemberService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ApiResponseDto join(@Validated @RequestBody MemberJoinDto dto) {
        memberService.join(dto);
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
            .data(Map.of("accessToken", tokens.get("accessToken"), "refreshToken",
                tokens.get("refreshToken")))
            .build();
    }

    @GetMapping("/{accountId}/posts")
    public ApiResponseDto getMemberPosts(
        @PathVariable String accountId,
        @AuthenticationPrincipal MemberDetails memberDetails
    ) {
        List<PostResponseDTO> posts = memberService.getMemberPosts(accountId, memberDetails);
        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("Posts", posts))
            .build();
    }
}