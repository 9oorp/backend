package com.goorp.backend.domain.member;

import com.goorp.backend.api.exception.EntityNotFoundException;
import com.goorp.backend.api.exception.ErrorCode;
import com.goorp.backend.api.exception.MemberException;
import com.goorp.backend.domain.member.exception.ConfirmPasswordNotMatchException;
import com.goorp.backend.domain.member.exception.InvalidPasswordException;
import com.goorp.backend.domain.member.model.MemberJoinDto;
import com.goorp.backend.domain.post.Post;
import com.goorp.backend.domain.post.PostRepository;
import com.goorp.backend.domain.post.model.PostResponseDto;
import com.goorp.backend.utils.JwtUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private final PostRepository postRepository;

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
            throw new ConfirmPasswordNotMatchException();
        }
        dto.setEncodingPassword(encoder.encode(dto.getPassword()));

        memberRepository.save(MemberJoinDto.joinDtoToMember(dto));
    }

    public Map<String, String> login(String accountId, String password) {
        // memberId 없음
        Member findMember = findMember(accountId);
        // password 틀림
        if (!encoder.matches(password, findMember.getPassword())) {
            throw new InvalidPasswordException();
        }
        // 로그인 정상 동작 refresh, access 토큰 발급
        String accessToken =jwtUtil.createAccessToken(findMember);
        String refreshToken = jwtUtil.createRefreshToken(findMember);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);
        return tokens;
    }

    public String refreshToAccessToken(Long memberId) {
        Member findMember = findMember(memberId);

        return jwtUtil.createAccessToken(findMember);
    }

    public List<PostResponseDto> getMemberPosts(String accountId) {
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "createdAt"));

        // 멤버 검색
        if(!memberRepository.existsByAccountId(accountId)) {
            throw new EntityNotFoundException(Member.class, accountId);
        }

        // 게시물 검색
        List<Post> findAllPost = postRepository.findByMemberAccountId(accountId, pageRequest)
            .getContent();

        // 게시물 DTO로 변환
        return findAllPost.stream()
            .map(PostResponseDto::of)
            .collect(Collectors.toList());
    }

    private Member findMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Member.class, id));
    }

    private Member findMember(String accountId) {
        return memberRepository.findByAccountId(accountId)
                .orElseThrow(() -> new EntityNotFoundException(Member.class, accountId));
    }
}