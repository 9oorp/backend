package com.goorp.backend.integrated;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goorp.backend.domain.member.Member;
import com.goorp.backend.api.response.ApiResponseDto;
import com.goorp.backend.domain.comment.CommentRepository;
import com.goorp.backend.domain.member.MemberRepository;
import com.goorp.backend.domain.post.PostRepository;
import com.goorp.backend.domain.comment.CommentService;
import com.goorp.backend.domain.member.MemberService;
import com.goorp.backend.utils.JwtUtil;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class BaseIntegratedTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected MemberService memberService;

    @Autowired
    protected MemberRepository memberRepository;

    @Autowired
    protected PostRepository postRepository;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected CommentRepository commentRepository;

    @Autowired
    protected CommentService commentService;

    @Autowired
    JwtUtil jwtUtil;

    static boolean isAlreadySetup = false;

    @Value("${jwt.secret}")
    private String secret;

    protected String getUserToken(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        String accessToken = jwtUtil.createAccessToken(member);
        return "Bearer " + accessToken;
    }

    @BeforeAll
    static void setup(@Autowired DataSource dataSource) {
        if(!isAlreadySetup) {
            try (Connection conn = dataSource.getConnection()) {
                ScriptUtils.executeSqlScript(conn, new ClassPathResource("/data-test.sql"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        isAlreadySetup = true;
    }

    /**
     * MvcResult로부터 값을 추출하는 메서드
     * @param mvcResult
     * @param key
     * @param clazz
     * @return
     * @param <T>
     * @throws Exception
     *
     * example
     * PostResponseDTO dto = extractFromResponse(mvcResult, "post", PostResponseDTO.class);
     * Integer totalCount = extractFromResponse(mvcResult, "totalCount", Integer.class);
     */
    protected <T> T extractFromResponse(MvcResult mvcResult, String key, Class<T> clazz) throws Exception {
        ApiResponseDto apiResponseDto = objectMapper.readValue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8), ApiResponseDto.class);
        String contentAsString = objectMapper.writeValueAsString(apiResponseDto.getData().get(key));
        return objectMapper.readValue(contentAsString, clazz);
    }
}
