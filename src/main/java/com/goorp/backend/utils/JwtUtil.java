package com.goorp.backend.utils;

import com.goorp.backend.common.enums.RoleType;
import com.goorp.backend.domain.member.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import java.util.Date;
import javax.crypto.SecretKey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {

    @Value("${jwt.secret}")
    private String key;
    private final AesBytesEncryptor aesBytesEncryptor;

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

    public Long getMemberId(String token) {
        Claims claims = getClaims(token);
        String encryptedMemberId = claims.get("memberId", String.class);
        byte[] decodedMemberIdBytes = Base64.getDecoder().decode(encryptedMemberId);
        String decryptedMemberId = new String(aesBytesEncryptor.decrypt(decodedMemberIdBytes));
        return Long.parseLong(decryptedMemberId);
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

    public String createAccessToken(Member member, long expireTimeMs) {
        Claims claims = Jwts.claims();
        claims.put("memberId",memberIdEncoder(member.getId()));
        claims.put("accountId", member.getAccountId());
        claims.put("memberName", member.getName());
        claims.put("role", RoleType.USER.toString());
        claims.put("type", "access");

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
            .signWith(getSecretKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    public String createRefreshToken(Member member, long expireTimeMs) {
        Claims claims = Jwts.claims();
        claims.put("memberId", memberIdEncoder(member.getId()));
        claims.put("type", "refresh");

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
            .signWith(getSecretKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    private String memberIdEncoder(Long memberId) {
        byte[] encrypt = aesBytesEncryptor.encrypt(memberId.toString().getBytes());
        return Base64.getEncoder().encodeToString(encrypt);
    }
}
