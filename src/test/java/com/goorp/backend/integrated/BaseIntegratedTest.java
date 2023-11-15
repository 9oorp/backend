package com.goorp.backend.integrated;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goorp.backend.domain.Member;
import com.goorp.backend.dto.ApiResponseDto;
import com.goorp.backend.repository.MemberRepository;
import com.goorp.backend.repository.PostRepository;
import com.goorp.backend.service.MemberService;
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

    @Value("${jwt.secret}")
    private String secret;

    protected String getUserToken(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        String accessToken = JwtUtil.createAccessToken(member.getAccountId(), member.getName(), secret, 1000L);
        return "Bearer " + accessToken;
    }

    @BeforeAll
    static void setup(@Autowired DataSource dataSource) {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("/data-test.sql"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
