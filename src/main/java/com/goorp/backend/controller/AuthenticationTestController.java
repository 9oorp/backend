package com.goorp.backend.controller;

import com.goorp.backend.configuration.MemberDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class AuthenticationTestController {
    @PostMapping("/class/{class-id}/posts")
    public String test(Authentication authentication) {
        if (authentication.getPrincipal() instanceof MemberDetails) {
            MemberDetails memberDetails = (MemberDetails) authentication.getPrincipal();
            String memberId = memberDetails.getMemberId();
            String memberName = memberDetails.getMemberName();
            log.info("memberId = {},memberName = {} ",memberId, memberName);
            return memberName + " (" + memberId + ") 인증되었습니다.";
        }
        return "인증되지 않은 사용자 입니다.";
    }
}
