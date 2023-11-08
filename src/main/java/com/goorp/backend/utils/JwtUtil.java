package com.goorp.backend.utils;

import com.goorp.backend.configuration.RoleType;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import javax.crypto.SecretKey;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String key;

    // Base64 인코딩된 문자열을 SecretKey 객체로 변환하는 메서드
    public SecretKey getSecretKey() {
        byte[] decodedKey = Base64.getDecoder().decode(key);
        return Keys.hmacShaKeyFor(decodedKey);
    }


    public String getMemberName(String token) {
        return getClaims(token).get("memberName", String.class);
    }

    public String getAccountId(String token) {
        return getClaims(token).get("accountId", String.class);
    }

    public String getType(String token) {
        return getClaims(token).get("type", String.class);
    }

    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSecretKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public String createAccessToken(String accountId, String memberName, RoleType roleType,
        long expireTimeMs) {
        Claims claims = Jwts.claims();
        claims.put("accountId", accountId);
        claims.put("memberName", memberName);
        claims.put("role", roleType.name());
        claims.put("type", "access");

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
            .signWith(getSecretKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    public String createRefreshToken(String accountId, long expireTimeMs) {
        Claims claims = Jwts.claims();
        claims.put("accountId", accountId);
        claims.put("type", "refresh");

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
            .signWith(getSecretKey(), SignatureAlgorithm.HS256)
            .compact();
    }
}
