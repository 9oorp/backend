package com.goorp.backend.controller;

import com.goorp.backend.configuration.MemberDetails;
import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.service.MemberService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class TokenController {

    private final MemberService memberService;

    @PostMapping("/refresh-token")
    public ApiResponseDto refreshAccessToken(@AuthenticationPrincipal MemberDetails memberDetails) {
        Long memberId = memberDetails.getMemberId();
        String accessToken = memberService.refreshToAccessToken(memberId);

        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("accessToken", accessToken))
            .build();
    }
}