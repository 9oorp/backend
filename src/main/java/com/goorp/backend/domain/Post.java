package com.goorp.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String classification;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private int recruitNum;
    private String contactUrl;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private LocalDate createdAt;
    @Column(nullable = false)
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "CURRICULUM_ID")
    private Curriculum curriculum;

}
