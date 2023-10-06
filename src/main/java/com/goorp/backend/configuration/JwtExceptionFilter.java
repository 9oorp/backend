package com.goorp.backend.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goorp.backend.dto.ApiErrorResponseDto;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (JwtException ex) {
            response.setStatus(HttpStatus.OK.value());

            ApiErrorResponseDto errorResponse = ApiErrorResponseDto.builder().ok(false).errorMessage(ex.getMessage()).build();
            String jsonResponse = objectMapper.writeValueAsString(errorResponse);

            // 2. 응답 본문 설정
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponse);
        }
    }
}
