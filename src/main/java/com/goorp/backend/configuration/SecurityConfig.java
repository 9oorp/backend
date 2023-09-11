package com.goorp.backend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value(value = "${jwt.secret}")
    private String secretKey;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.
                httpBasic().disable()
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/api/class/**/posts","/api/posts/**/comments").authenticated()
                .antMatchers(HttpMethod.PUT, "/api/class/**/posts/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/api/class/**/posts/**", "/api/posts/**/comments/**").authenticated()
                .antMatchers(HttpMethod.PATCH, "/api/class/**/posts/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //jwt 사용하는 경우 사용
                .and()
<<<<<<< Updated upstream
                .addFilterBefore(new JwtExceptionFilter(),UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtFilter(secretKey), JwtExceptionFilter.class)
=======
                .addFilterBefore(new JwtFilter(secretKey),UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtExceptionFilter(), JwtFilter.class)
>>>>>>> Stashed changes
                .build();
    }
}