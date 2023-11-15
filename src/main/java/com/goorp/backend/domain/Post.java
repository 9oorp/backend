package com.goorp.backend.domain;

import java.time.LocalDateTime;
import com.goorp.backend.domain.vo.Subject;
import com.goorp.backend.domain.vo.TechStack;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Set;


@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @Column(name = "POST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Lob
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String classification;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "post_subject",
            joinColumns = @JoinColumn(name = "post_id")
    )
    @Enumerated(EnumType.STRING)
    private Set<Subject> subjects = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "post_stack",
            joinColumns = @JoinColumn(name = "post_id")
    )
    @Enumerated(EnumType.STRING)
    private Set<TechStack> stacks = new HashSet<>();
    @Column(nullable = false)
    private int recruitNum;
    private String contactUrl;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRICULUM_ID")
    private Curriculum curriculum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    public void changeStatus(String newStatus) {
        this.status = newStatus;
    }

}
