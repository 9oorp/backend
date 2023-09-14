package com.goorp.backend.repository;

import com.goorp.backend.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findById(Long postId);

    Optional<Post> findByCurriculumIdAndId(Long curriculumId, Long postId);

    List<Post> findByCurriculumId(Long curriculumId);

    @Transactional(readOnly = true)
    @EntityGraph(attributePaths = {"curriculum", "member"})
    Page<Post> findByMember_AccountId(String accountId, Pageable pageable);
}