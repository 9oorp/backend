package com.goorp.backend.controller;

import com.goorp.backend.configuration.MemberDetails;
import com.goorp.backend.configuration.RoleType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// TODO 배포할때 삭제 예정
@Slf4j
@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @GetMapping("/someEndpoint/1")
    public String tokenTest1() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MemberDetails memberDetails = (MemberDetails) authentication.getPrincipal();

        log.info("accountId={} name={} 인가 권한{}", memberDetails.getAccountId(), memberDetails.getMemberName(), memberDetails.getRoleType().toString());
        return "Check the token details!";
    }

    @GetMapping("/someEndpoint/2")
    public String tokenTest2(@AuthenticationPrincipal MemberDetails memberDetails) {
        String accountId = memberDetails.getAccountId();
        String memberName = memberDetails.getMemberName();
        RoleType roleType = memberDetails.getRoleType();

        log.info("accountId={} name={} 인가 권한{}", accountId, memberName, roleType.toString());
        return "Check the token details!";
    }
}