package com.goorp.backend.controller;

import com.goorp.backend.dto.MemberJoinDto;
import com.goorp.backend.dto.MemberLoginDto;
import com.goorp.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> join(@RequestBody MemberJoinDto dto) {
        memberService.join(dto.getMemberId(), dto.getPassword(), dto.getPasswordConfirm(), dto.getMemberName());
//        log.info("회원가입 성공");
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberLoginDto dto) {
        log.info("로그인 컨트롤러 실행");
        String token = memberService.login(dto.getMemberId(), dto.getPassword());
        return ResponseEntity.ok(token);
    }
}
