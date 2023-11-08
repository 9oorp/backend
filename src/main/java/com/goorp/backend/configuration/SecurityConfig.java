package com.goorp.backend.configuration;

import com.goorp.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
    private final AuthenticationEntryPoint entryPoint = new JwtAuthenticationEntryPoint();
    @Autowired
    private JwtUtil jwtUtil;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // 보안 설정
        http.
            cors().configurationSource(corsConfigurationSource())
            .and()
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            // 인가 설정
            .authorizeHttpRequests()
            .antMatchers(HttpMethod.GET, "/api/curriculum/**/posts", "/api/posts/**", "/api/posts/**/comments").permitAll()
            .antMatchers(HttpMethod.POST, "/api/members/join", "/api/members/login").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .anyRequest().authenticated()
            .and()
            // JWT 필터 설정
            .addFilterBefore(new JwtFilter(entryPoint, jwtUtil),
                UsernamePasswordAuthenticationFilter.class)
            .headers().frameOptions().disable() // X-Frame-Options 헤더 비활성화
            .and()
            // jwt 에러 처리
            .exceptionHandling(handler -> handler.authenticationEntryPoint(entryPoint));
        return http.build();
    }

    // CORS 관련 설정
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://9oorp.store");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}