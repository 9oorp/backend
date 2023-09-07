package com.goorp.backend.configuration;

import com.goorp.backend.service.MemberService;
import com.goorp.backend.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    private final MemberService memberService;
    private final String secretKey;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // UserName Token에서 꺼내기
        final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("authorization : {}", authorization);

        // 토큰 없을 때 블럭
        if (authorization == null || !authorization.startsWith("Bearer ") ) {
            log.error("authorization 이 없습니다.");
            filterChain.doFilter(request, response);
            return;
        }
        // 토큰 꺼내기
        String token = authorization.split(" ")[1];

        // 토큰 만료되었는지 여부
        if (JwtUtil.isExpired(token, secretKey)) {
            log.error("토큰이 만료 되었습니다.");
            filterChain.doFilter(request, response);
            return;
        }

        // memberId 토큰에서 꺼내기
        String memberId = JwtUtil.getMemberId(token, secretKey);
//        log.info("memberId = {}", memberId);

        String memberName = JwtUtil.getMemberName(token, secretKey);
//        log.info("memberName = {}", memberName);


        // 권한 부여
        MemberDetails memberDetails = new MemberDetails(memberId, memberName);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(memberDetails, null, List.of(new SimpleGrantedAuthority("MEMBER")));
        // Detail 설정
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}