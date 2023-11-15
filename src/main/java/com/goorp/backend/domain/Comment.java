package com.goorp.backend.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String content;
    @Column
    private int commentGroup;
    @Column
    private int depth;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public static Comment createComment(String content, Member member, Post post) {
        return Comment.builder()
            .content(content)
            .commentGroup(0)
            .depth(1)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .member(member)
            .post(post)
            .build();
    }

    public static Comment replyToComment(String content, Member member, Post post, Comment parent) {
        return Comment.builder()
            .content(content)
            .commentGroup(parent.getCommentGroup())
            .depth(2)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .member(member)
            .post(post)
            .build();
    }

    public void updateCommentGroup() {
        if (this.commentGroup == 0) {
            this.commentGroup = this.id.intValue();
        }
    }
}
