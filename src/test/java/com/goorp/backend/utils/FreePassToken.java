package com.goorp.backend.utils;

import com.goorp.backend.configuration.RoleType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class FreePassToken {
    @Autowired
    JwtUtil jwtUtil;
    @Test
    void createFreePassToken() {
        long MaxExpireTimeMs = 1000L * 60 * 60 * 24 * 365 * 10;  // 10년

        String freePassToken = jwtUtil.createAccessToken("hello1", "홍길동(풀스택 2회차)", RoleType.USER,
            MaxExpireTimeMs);
        log.info("freePassToken = {}", freePassToken);
    }

    @Test
    void createFreePassTokenByRefreshToken() {
        long MaxExpireTimeMs = 1000L * 60 * 60 * 24 * 365 * 10;  // 10년

        String refreshFreePassToken = jwtUtil.createRefreshToken("hello1", MaxExpireTimeMs);
        log.info("refreshFreePassToken = {}", refreshFreePassToken);
    }
}
