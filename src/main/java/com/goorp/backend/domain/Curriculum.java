package com.goorp.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Curriculum {

    @Id
    @Column(name = "CURRICULUM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate createdAt;
    @Column(nullable = false)
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "curriculum")
    private List<Post> posts = new ArrayList<>();
}
