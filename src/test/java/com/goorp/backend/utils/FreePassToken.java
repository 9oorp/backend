package com.goorp.backend.utils;

import com.goorp.backend.domain.Member;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@ActiveProfiles("test")
@Transactional
public class FreePassToken {
    private final long MaxExpireTimeMs = 1000L * 60 * 60 * 24 * 365 * 10;  // 10년
    @Autowired
    JwtUtil jwtUtil;
    Member member;

    @BeforeEach
    void setUp() {
            LocalDate now = LocalDate.now();
            member = Member.builder()
                .id(1L)
                .accountId("hello1")
                .password("123456789!")
                .name("홍길동(풀스택 2회차)")
                .createdAt(now)
                .updatedAt(now)
                .build();
    }

    @Test
    @Disabled
    @DisplayName("프리패스 에세스 토큰 생성하는 테스트입니다.")
    void createFreePassByAccessToken() {
        String freePassToken = jwtUtil.createAccessToken(member, MaxExpireTimeMs);
        log.info("accessFreePassToken = {}", freePassToken);
    }

    @Test
    @Disabled
    @DisplayName("프리패스 리프레쉬 토큰 생성하는 테스트입니다.")
    void createFreePassTokenByRefreshToken() {
        String refreshFreePassToken = jwtUtil.createRefreshToken(member, MaxExpireTimeMs);
        log.info("refreshFreePassToken = {}", refreshFreePassToken);
    }
}