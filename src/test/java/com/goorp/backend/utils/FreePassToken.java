package com.goorp.backend.utils;

import com.goorp.backend.configuration.RoleType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class FreePassToken {
    @Autowired
    JwtUtil jwtUtil;
    @Test
    void createFreePassToken() {
        long MaxExpireTimeMs = 1000L * 60 * 60 * 24 * 365 * 10;  // 10년

        String freePassToken = jwtUtil.createAccessToken("hello1", "홍길동(풀스택 2회차)", RoleType.USER,
            MaxExpireTimeMs);
        log.info("freePassToken = {}", freePassToken);
        // eyJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50SWQiOiJoZWxsbzEiLCJtZW1iZXJOYW1lIjoi7ZmN6ri464-ZKO2SgOyKpO2DnSAy7ZqM7LCoKSIsInJvbGUiOiJVU0VSIiwidHlwZSI6ImFjY2VzcyIsImlhdCI6MTY5OTQyMzA0OCwiZXhwIjoyMDE0NzgzMDQ4fQ.tYF1GofuknHoS5ac-v9aRQVlVn9wdqXDICSlmMJsd_8
    }
}
