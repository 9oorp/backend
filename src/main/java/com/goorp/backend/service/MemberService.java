package com.goorp.backend.service;

import com.goorp.backend.domain.Member;
import com.goorp.backend.exception.ErrorCode;
import com.goorp.backend.exception.MemberException;
import com.goorp.backend.repository.MemberRepository;
import com.goorp.backend.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
@RequiredArgsConstructor

@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;
    @Value(value = "${jwt.secret}")
    private String key;
    private Long accessExpireTimeMs = 60 * 60 * 1000L; // 2시간
    private Long refreshExpireTimeMs = 2 * 7 * 24 * 60 * 60 * 1000L;  // 2주

    @Transactional
    public String join(String accountId, String password, String passwordConfirm, String name) {
        // memberId 중복 체크
        memberRepository.findByAccountId(accountId)
                .ifPresent(member -> {
                    throw new MemberException(ErrorCode.ID_DUPLICATED, accountId + " 이미 존재 합니다.");
                });
        // password 확인
        if (!password.equals(passwordConfirm)) {
            throw new MemberException(ErrorCode.PASSWORD_NOT_SAME, "passwordConfirm이 password와 다릅니다!");
        }

        // 저장
        LocalDate now = LocalDate.now();
        Member member = Member.builder()
                .accountId(accountId)
                .password(encoder.encode(password))
                .name(name)
                .createdAt(now)
                .updatedAt(now)
                .build();

        memberRepository.save(member);
        return "SUCCESS";
    }

    @Transactional(readOnly = true)
    public Map<String, String> login(String memberId, String password) {
        // memberId 없음
        Member findMember = memberRepository.findByAccountId(memberId)
                .orElseThrow(() -> new MemberException(ErrorCode.ID_NOT_FOUNT, "ID가 틀립니다."));
        // password 틀림
        if (!encoder.matches(password, findMember.getPassword())) {
            throw new MemberException(ErrorCode.INVALID_PASSWORD, "비밀번호가 틀립니다.");
        }
        // 로그인 정상 동작 refresh, access 토큰 발급
        String accessToken = JwtUtil.createAccessToken(findMember.getAccountId(), findMember.getName(), key, accessExpireTimeMs);
        String refreshToken = JwtUtil.createRefreshToken(findMember.getAccountId(), key, refreshExpireTimeMs);
        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);
        return tokens;
    }

    public boolean isRefreshToken(String token) {
        if (!JwtUtil.getType(token, key).equals("refresh")) {
            return false;
        }
        return true;
    }

    public boolean isRefreshExpired(String token) {
        if (JwtUtil.isExpired(token, key)) {
            return false;
        }
        return true;
    }

    public String createAccessToken(String token) {
        String accountId = JwtUtil.getAccountId(token, key);
        Member findMember = memberRepository.findByAccountId(accountId)
                .orElseThrow(() -> new MemberException(ErrorCode.ID_NOT_FOUNT, accountId + " 가 없습니다."));
        return JwtUtil.createAccessToken(findMember.getAccountId(), findMember.getName(), key, accessExpireTimeMs);
    }
}