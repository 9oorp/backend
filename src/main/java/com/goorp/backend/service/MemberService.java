package com.goorp.backend.service;

import com.goorp.backend.domain.Member;
import com.goorp.backend.exception.AppException;
import com.goorp.backend.exception.ErrorCode;
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
        // memberId 중복 체크, password 확인
        memberRepository.findByMemberId(memberId)
                .ifPresent(member -> {
                    throw new RuntimeException(memberId + " 이미 존재 합니다.");
                });
        // password 확인
        if (!password.equals(passwordConfirm)) {
            throw new RuntimeException("비밀번호가 다릅니다!");
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
                .orElseThrow(() -> new AppException(ErrorCode.MEMBER_NAME_NOT_FOUNT, memberId + " 이 없습니다."));
        // password 틀림
        if(!encoder.matches(password, findMember.getPassword())) {
            throw new AppException(ErrorCode.PASSWORD_NOT_CONFIRM, "패스워드를 잘못 입력 했습니다.");
        }
        // 로그인 정상 동작
        return JwtUtil.createToken(findMember.getMemberId(), findMember.getName(), key, expireTimeMs);
    }
}
