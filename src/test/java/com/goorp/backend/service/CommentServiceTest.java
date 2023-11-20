package com.goorp.backend.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.goorp.backend.domain.member.Member;
import com.goorp.backend.domain.post.Post;
import com.goorp.backend.domain.comment.model.CommentRequestDto;
import com.goorp.backend.integrated.BaseIntegratedTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommentServiceTest extends BaseIntegratedTest {
    @BeforeEach
    void setUp() {
        LocalDateTime now = LocalDateTime.of(2023, 11, 15, 12, 44, 1);

        Post post = Post.builder()
            .title("testTitle")
            .content("testContent")
            .classification("testClassification")
            .recruitNum(2)
            .contactUrl("testContactUrl")
            .status("1")
            .createdAt(now)
            .updatedAt(now)
            .build();

        Member member = Member.builder()
            .accountId("memberAccountId")
            .password("testPassword")
            .name("testName")
            .createdAt(LocalDate.from(now))
            .updatedAt(LocalDate.from(now))
            .build();
        memberRepository.save(member);
        postRepository.save(post);
    }

    @DisplayName("부모가 없는 댓글을 생성한다.")
    @Test
    void createComment() {
        // given
        CommentRequestDto commentRequestDto = new CommentRequestDto("댓글", null);
        // when
        commentService.createComment(1L, commentRequestDto, "memberAccountId");
        // then
        assertThat(commentRepository.findByPostId(1L)).hasSize(1);
        assertThat(commentRepository.findByPostId(1L).get(0).getContent()).isEqualTo("댓글");
    }

    @DisplayName("부모가 있는 댓글을 생성한다.")
    @Test
    void createReplyComment() {
        // given
        CommentRequestDto commentRequestDto1 = new CommentRequestDto("댓글", null);
        CommentRequestDto commentRequestDto2 = new CommentRequestDto("대댓글", 1L);
        // when
        commentService.createComment(1L, commentRequestDto1, "memberAccountId");
        commentService.createComment(1L, commentRequestDto2, "memberAccountId");
        // then
        assertThat(commentRepository.findByPostId(1L)).hasSize(2);
        assertThat(commentRepository.findByPostId(1L).get(0).getContent()).isEqualTo("댓글");
        assertThat(commentRepository.findByPostId(1L).get(1).getContent()).isEqualTo("대댓글");
    }
}