package com.goorp.backend.integrated;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.goorp.backend.domain.post.Post;
import com.goorp.backend.domain.post.model.PostResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

public class PostIntegratedTest extends BaseIntegratedTest {

    private boolean matchesToEntity(PostResponseDto postResponseDTO, Post post) {
        if (postResponseDTO.getId().equals(post.getId())
                && postResponseDTO.getTitle().equals(post.getTitle())
                && postResponseDTO.getContent().equals(post.getContent())
                && postResponseDTO.getMemberName().equals(post.getMember().getName())
                && postResponseDTO.getCreatedAt().equals(post.getCreatedAt())
                && postResponseDTO.getUpdatedAt().equals(post.getUpdatedAt())) {
            return true;
        }
        return false;
    }

    @Test
    @DisplayName("게시물 단건 조회 - 성공")
    void getSingleResult() throws Exception {
        Long postId = 1L;
        String url = "/api/posts/" + postId;

        MvcResult mvcResult = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        PostResponseDto postResponseDTO = extractFromResponse(mvcResult, "post", PostResponseDto.class);
        Post post = postRepository.findById(postId).get();
        assertThat(matchesToEntity(postResponseDTO, post)).isTrue();
    }

    @Test
    @DisplayName("게시물 복수 조회 - 성공")
    void getResultList() throws Exception {

    }

    @Test
    @DisplayName("게시물 생성 - 성공")
    void create() throws Exception {

    }

    @Test
    @DisplayName("게시물 생성 - 실패")
    void createFail() {

    }

    @Test
    @DisplayName("게시물 수정 - 성공")
    void update() {

    }

    @Test
    @DisplayName("게시물 삭제 - 성공")
    void delete() {

    }
}
