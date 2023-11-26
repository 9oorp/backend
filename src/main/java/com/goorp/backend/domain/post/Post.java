package com.goorp.backend.domain.post;

import com.goorp.backend.common.enums.Classification;
import com.goorp.backend.common.enums.Status;
import com.goorp.backend.common.enums.Subject;
import com.goorp.backend.common.enums.TechStack;
import com.goorp.backend.domain.comment.Comment;
import com.goorp.backend.domain.curriculum.Curriculum;
import com.goorp.backend.domain.member.Member;
import com.goorp.backend.domain.post.model.PostRequestDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import org.hibernate.annotations.BatchSize;

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

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Classification classification;

    @Column(nullable = false)
    private int recruitNum;
    private String contactUrl;
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

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    public  boolean validation(Long memberId) {
        return this.getMember().getId().equals(memberId);
    }

    public void update(PostRequestDto requestDTO, Curriculum curriculum) {
        this.title = requestDTO.getTitle();
        this.content = requestDTO.getContent();
        this.classification = requestDTO.getClassification();
        this.subjects = requestDTO.getSubject();
        this.stacks = requestDTO.getStack();
        this.recruitNum = requestDTO.getRecruitNum();
        this.contactUrl = requestDTO.getContactUrl();
        this.status = requestDTO.getStatus();
        this.curriculum = curriculum;
        this.updatedAt = LocalDateTime.now();
    }
}
