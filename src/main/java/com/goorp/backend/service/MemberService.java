package com.goorp.backend.service;

import com.goorp.backend.configuration.MemberDetails;
import com.goorp.backend.domain.Member;
import com.goorp.backend.domain.Post;
import com.goorp.backend.dto.MemberJoinDto;
import com.goorp.backend.dto.PostResponseDTO;
import com.goorp.backend.exception.ErrorCode;
import com.goorp.backend.exception.MemberException;
import com.goorp.backend.repository.MemberRepository;
import com.goorp.backend.repository.PostRepository;
import com.goorp.backend.utils.JwtUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    private final PostService postService;
    private final PostRepository postRepository;

    private final Long accessExpireTimeMs = 60 * 60 * 1000L; // 2시간
    private final Long refreshExpireTimeMs = 2 * 7 * 24 * 60 * 60 * 1000L;  // 2주

    @Transactional
    public void join(MemberJoinDto dto) {
        // memberId 중복 체크
        String accountId = dto.getAccountId();
        memberRepository.findByAccountId(accountId)
            .ifPresent(member -> {
                throw new MemberException(ErrorCode.ID_DUPLICATED, accountId + " 이미 존재 합니다.");
            });
        // password 확인
        if (!dto.getPassword().equals(dto.getPasswordConfirm())) {
            throw new MemberException(ErrorCode.PASSWORD_NOT_SAME,
                "passwordConfirm이 password와 다릅니다!");
        }
        dto.setEncodingPassword(encoder.encode(dto.getPassword()));

        memberRepository.save(MemberJoinDto.joinDtoToMember(dto));
    }

    public Map<String, String> login(String accountId, String password) {
        // memberId 없음
        Member findMember = memberRepository.findByAccountId(accountId)
            .orElseThrow(() -> new MemberException(ErrorCode.ID_NOT_FOUNT, "ID가 틀립니다."));
        // password 틀림
        if (!encoder.matches(password, findMember.getPassword())) {
            throw new MemberException(ErrorCode.INVALID_PASSWORD, "비밀번호가 틀립니다.");
        }
        // 로그인 정상 동작 refresh, access 토큰 발급
        String accessToken =jwtUtil.createAccessToken(findMember, accessExpireTimeMs);
        String refreshToken = jwtUtil.createRefreshToken(findMember, refreshExpireTimeMs);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);
        return tokens;
    }

    public String refreshToAccessToken(Long memberId) {
        Member findMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new MemberException(ErrorCode.ID_NOT_FOUNT, memberId + " 멤버가 존재하지 않습니다."));

        return jwtUtil.createAccessToken(findMember, accessExpireTimeMs);
    }

    public List<PostResponseDTO> getMemberPosts(String accountId, MemberDetails memberDetails) {
        PageRequest pageRequest = PageRequest.of(0, 8, Sort.by(Sort.Direction.DESC, "createdAt"));

        // 권한 확인
        if (!Objects.equals(memberDetails.getAccountId(), accountId)) {
            throw new MemberException(ErrorCode.UNAUTHORIZED, "권한이 없습니다.");
        }

        // 멤버 검색
        if(!memberRepository.existsByAccountId(accountId)) {
            throw new MemberException(ErrorCode.ID_NOT_FOUNT, accountId + " 가 존재하지 않습니다.");
        }

        // 게시물 검색
        List<Post> findAllPost = postRepository.findByMemberAccountId(accountId, pageRequest)
            .getContent();

        // 게시물 DTO로 변환
        return findAllPost.stream()
            .map(postService::convertToResponseDTO)
            .collect(Collectors.toList());
    }
}