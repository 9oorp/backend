package com.goorp.backend.configuration;

import com.goorp.backend.utils.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    private final AuthenticationEntryPoint entryPoint;
    private final JwtUtil jwtUtil;

    private final Map<String, List<String>> skipPatterns = new HashMap<>();
    private final PathMatcher pathMatcher = new AntPathMatcher();

    public JwtFilter(AuthenticationEntryPoint entryPoint, JwtUtil jwtUtil) {
        this.entryPoint = entryPoint;
        this.jwtUtil = jwtUtil;

        skipPatterns.put("GET", Arrays.asList(
            "/api/curriculum/**/posts",
            "/api/posts/**",
            "/api/posts/**/comments"
        ));

        skipPatterns.put("POST", Arrays.asList(
            "/api/members/login",
            "/api/members/join"
        ));
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String requestMethod = request.getMethod();
        String requestURI = request.getRequestURI();
        List<String> patterns = skipPatterns.getOrDefault(requestMethod, Collections.emptyList());

        boolean isH2Console = requestURI.startsWith("/h2-console/");
        boolean isSkipUrl = patterns.stream().anyMatch(pattern -> pathMatcher.match(pattern, requestURI));
        return isH2Console || isSkipUrl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain)
        throws ServletException, IOException {

        try {
            String token = getToken(request);
            if (token == null) {
                log.error("토큰이 존재하지 않음");
                throw new InsufficientAuthenticationException("토큰이 존재하지 않습니다.", null);
            }
            if (validateToken(token)) {
                String accountId = jwtUtil.getAccountId(token);
                String memberName = jwtUtil.getMemberName(token);
                String role = jwtUtil.getRole(token);
                RoleType roleType = RoleType.valueOf(role);
                MemberDetails memberDetails = new MemberDetails(accountId, memberName, roleType);

                UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(memberDetails, null,
                        getAuthorities(role));

                authentication.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (AuthenticationException e) {
            SecurityContextHolder.clearContext();
            entryPoint.commence(request, response, e);
            return;
        }

        chain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        log.debug("bearerToken = {}", bearerToken);
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtUtil.getSecretKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            log.error("ExpiredJwtException JWT 만료");
            throw new InsufficientAuthenticationException("토큰 만료", e);
        } catch (UnsupportedJwtException e) {
            log.error("UnsupportedJwtException JWT 지원되지 않는 형식");
            throw new BadCredentialsException("JWT 지원되지 않는 형식", e);
        } catch (MalformedJwtException e) {
            log.error("MalformedJwtException JWT 구조가 올바르지 않는 형식");
            throw new BadCredentialsException("JWT 구조가 올바르지 않는 형식", e);
        } catch (SignatureException e) {
            log.error("SignatureException JWT 서명이 유효하지 않음");
            throw new BadCredentialsException("JWT 서명이 유효하지 않음", e);
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException 메서드에 전달된 인자가 부적절함");
            throw new InsufficientAuthenticationException("메서드에 전달된 인자가 부적절함", e);
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }
}