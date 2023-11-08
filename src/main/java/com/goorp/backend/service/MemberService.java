package com.goorp.backend.service;

import com.goorp.backend.configuration.RoleType;
import com.goorp.backend.domain.Member;
import com.goorp.backend.exception.ErrorCode;
import com.goorp.backend.exception.MemberException;
import com.goorp.backend.repository.MemberRepository;
import com.goorp.backend.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;



@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    private Long accessExpireTimeMs = 60 * 60 * 1000L; // 2시간
    private Long refreshExpireTimeMs = 2 * 7 * 24 * 60 * 60 * 1000L;  // 2주

    @Transactional
    public void join(String accountId, String password, String passwordConfirm, String name) {
        // memberId 중복 체크
        memberRepository.findByAccountId(accountId)
            .ifPresent(member -> {
                throw new MemberException(ErrorCode.ID_DUPLICATED, accountId + " 이미 존재 합니다.");
            });
        // password 확인
        if (!password.equals(passwordConfirm)) {
            throw new MemberException(ErrorCode.PASSWORD_NOT_SAME,
                "passwordConfirm이 password와 다릅니다!");
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
    }

    @Transactional(readOnly = true)
    public Map<String, String> login(String accountId, String password) {
        // memberId 없음
        Member findAccount = memberRepository.findByAccountId(accountId)
            .orElseThrow(() -> new MemberException(ErrorCode.ID_NOT_FOUNT, "ID가 틀립니다."));
        // password 틀림
        if (!encoder.matches(password, findAccount.getPassword())) {
            throw new MemberException(ErrorCode.INVALID_PASSWORD, "비밀번호가 틀립니다.");
        }
        // 로그인 정상 동작 refresh, access 토큰 발급
        String accessToken =jwtUtil.createAccessToken(findAccount.getAccountId(),
            findAccount.getName(), RoleType.USER, accessExpireTimeMs);
        String refreshToken = jwtUtil.createRefreshToken(findAccount.getAccountId(),
            refreshExpireTimeMs);
        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);
        return tokens;
    }

    public String refreshToAccessToken(String accountId) {
        Member findMember = memberRepository.findByAccountId(accountId)
            .orElseThrow(() -> new MemberException(ErrorCode.ID_NOT_FOUNT, accountId + " 멤버가 존재하지 않습니다."));
        return jwtUtil.createAccessToken(findMember.getAccountId(), findMember.getName(),
            RoleType.USER, accessExpireTimeMs);
    }
}