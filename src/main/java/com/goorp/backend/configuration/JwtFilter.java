package com.goorp.backend.configuration;

import com.goorp.backend.utils.JwtUtil;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.AntPathMatcher;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    private final String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 현재 요청 URL 가져오기
        String requestURI = request.getRequestURI();

        // GET요청은 토큰 검증하지 않고 통과
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }

        // 토큰 검증이 필요한 URL 패턴 목록
        List<String> protectedPaths = List.of(
                "/api/posts/**",
                "/api/posts/**/comments/**"
        );

        // 현재 요청 URL이 토큰 검증이 필요한 URL 패턴 중 하나와 일치하는지 확인
        boolean isProtectedPath = protectedPaths.stream().anyMatch(path -> antPathMatcher.match(path, requestURI));
        final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("authorization : {}", authorization);

        // 토큰 있으면 만료 확인
        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.split(" ")[1];
            JwtUtil.isExpired(token, secretKey);

            // 토큰 검증이 필요한 요청에서만 사용자 인증 정보 설정
            if (isProtectedPath) {
                // memberId 토큰에서 꺼내기

                String accountId = JwtUtil.getAccountId(token, secretKey);
                String memberName = JwtUtil.getMemberName(token, secretKey);

                // 권한 부여
                MemberDetails memberDetails = new MemberDetails(accountId, memberName);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(memberDetails, null, List.of(new SimpleGrantedAuthority("MEMBER")));
                // Detail 설정
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                filterChain.doFilter(request, response);
                return;
            }
        } else if (isProtectedPath) {
            // 토큰이 없는데, 토큰 검증이 필요한 URL에 접근한 경우
            log.error("토큰 없음");
            throw new JwtException("토큰 없음");
        }
        filterChain.doFilter(request, response);
    }
}