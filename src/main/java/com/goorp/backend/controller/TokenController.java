package com.goorp.backend.controller;

import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.exception.ErrorCode;
import com.goorp.backend.exception.MemberException;
import com.goorp.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class TokenController {

    private final MemberService memberService;

    @PostMapping("/refresh-token")
    public ApiResponseDto refreshAccessToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("controller 진입");
        // 토큰이 없을 때
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new MemberException(ErrorCode.NOT_FOUND_TOKEN, "리프레시 토큰이 없음");
        }
        String refreshToken = authorizationHeader.split(" ")[1];
        // 리프레시 토큰이 아님
        if (!memberService.isRefreshToken(refreshToken)) {
            throw new MemberException(ErrorCode.NOT_REFRESH_TOKEN, "리프레시 토큰 아님");
        }

        String accessToken = memberService.refreshToAccessToken(refreshToken);

        return ApiResponseDto.builder()
            .ok(true)
            .data(Map.of("accessToken", accessToken))
            .build();
    }
}