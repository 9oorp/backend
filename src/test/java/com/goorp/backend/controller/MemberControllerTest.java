package com.goorp.backend.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goorp.backend.dto.MemberJoinDto;
import com.goorp.backend.dto.MemberLoginDto;
import com.goorp.backend.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class MemberControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    MemberService memberService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입 성공")
    void join() throws Exception {
        String id = "1234";
        String name = "hello";
        String password = "hello1";
        String passwordConfirm = "hello1";

        mockMvc.perform(post("/api/members/join")
                        .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(new MemberJoinDto(id, name, password, passwordConfirm))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("회원가입 실패 - id 중복")
    void join_fail_id() throws Exception {
        String id = "123";
        String name = "hello";
        String password = "hello1";
        String passwordConfirm = "hello1";

        mockMvc.perform(post("/api/members/join")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new MemberJoinDto(id, name, password, passwordConfirm))))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    @DisplayName("회원가입 실패 - 비밀번호 확인 실패")
    void join_fail_password() throws Exception {
        String id = "1";
        String name = "hello";
        String password = "hello1";
        String passwordConfirm = "hello2";

        mockMvc.perform(post("/api/members/join")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new MemberJoinDto(id, name, password, passwordConfirm))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인 성공")
    void login_success() throws Exception {
        String memberId = "123";
        String password = "1234";

        mockMvc.perform(post("/api/members/login")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new MemberLoginDto(memberId, password))))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("로그인 실패 - memberId 없음")
    void login_fail1() throws Exception {
        String memberId = "aaaa";
        String password = "hello1";

        mockMvc.perform(post("/api/members/login")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new MemberLoginDto(memberId, password))))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("로그인 실패 - password 확인 불가")
    void login_fail2() throws Exception {
        String memberId = "123";
        String password = "hello1";

        mockMvc.perform(post("/api/members/login")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new MemberLoginDto(memberId, password))))
                .andDo(print())
                .andExpect(status().isConflict());
    }
}