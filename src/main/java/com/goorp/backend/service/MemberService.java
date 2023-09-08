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

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;
    @Value(value = "${jwt.secret}")
    private String key;
    private Long expireTimeMs = 1000 * 60 * 60L;

    public String join(String memberId, String password, String passwordConfirm, String name) {
        // memberId 중복 체크
        memberRepository.findByMemberId(memberId)
                .ifPresent(member -> {
                    throw new MemberException(ErrorCode.ID_DUPLICATED, memberId + " 이미 존재 합니다.");
                });
        // password 확인
        if (!password.equals(passwordConfirm)) {
            throw new MemberException(ErrorCode.PASSWORD_NOT_SAME, "passwordConfirm이 password와 다릅니다!");
        }

        // 저장
        LocalDate now = LocalDate.now();
        Member member = Member.builder()
                .memberId(memberId)
                .password(encoder.encode(password))
                .name(name)
                .createdAt(now)
                .updatedAt(now)
                .build();

        memberRepository.save(member);
        return "SUCCESS";
    }

    public String login(String memberId, String password) {
        // memberId 없음
        Member findMember = memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new MemberException(ErrorCode.ID_NOT_FOUNT, memberId + " 가 없습니다."));
        // password 틀림
        if (!encoder.matches(password, findMember.getPassword())) {
            throw new MemberException(ErrorCode.INVALID_PASSWORD, "비밀번호가 틀립니다.");
        }
        // 로그인 정상 동작
        return JwtUtil.createToken(findMember.getMemberId(), findMember.getName(), key, expireTimeMs);
    }
}