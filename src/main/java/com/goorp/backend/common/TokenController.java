package com.goorp.backend.common;

import com.goorp.backend.common.login.MemberDetails;
import com.goorp.backend.api.response.ApiResponseDto;
import com.goorp.backend.domain.member.MemberService;
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