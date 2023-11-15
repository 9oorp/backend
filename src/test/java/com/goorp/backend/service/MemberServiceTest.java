package com.goorp.backend.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.goorp.backend.domain.Member;
import com.goorp.backend.dto.MemberJoinDto;
import com.goorp.backend.repository.MemberRepository;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @DisplayName("회원가입 정상작동 테스트")
    @Test
    void join() {
        // given
        MemberJoinDto memberJoinDto = new MemberJoinDto("hello1", "홍길동(풀스택 2회차)", "123456789!", "123456789!");
        memberService.join(memberJoinDto);
        // when
        Member findMember = memberRepository.findByAccountId("hello1").get();
        // then
        assertThat(findMember.getAccountId()).isEqualTo("hello1");
    }

    @DisplayName("로그인 기능 정상작동 테스트")
    @Test
    void login() {
        // given
        MemberJoinDto memberJoinDto = new MemberJoinDto("hello1", "홍길동(풀스택 2회차)", "123456789!", "123456789!");
        memberService.join(memberJoinDto);
        // when
        Map<String, String> tokenMap = memberService.login("hello1", "123456789!");
        // then
        assertThat(tokenMap.get("accessToken")).isNotNull();
        assertThat(tokenMap.get("refreshToken")).isNotNull();
    }

    @DisplayName("리프레쉬토큰을 입력받고 에세스토큰을 반환하는 메서드 정상작동 테스트")
    @Test
    void refreshToAccessToken() {
        // given
        MemberJoinDto memberJoinDto = new MemberJoinDto("hello1", "홍길동(풀스택 2회차)", "123456789!", "123456789!");
        memberService.join(memberJoinDto);
        // when
        String token = memberService.refreshToAccessToken(1L);
        // then
        assertThat(token).isNotNull();
    }
}