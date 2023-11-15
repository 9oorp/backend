package com.goorp.backend.repository;

import com.goorp.backend.domain.Post;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

    Optional<Post> findById(Long postId);

    @EntityGraph(attributePaths = {"curriculum", "member"})
    Page<Post> findByMemberAccountId(String accountId, Pageable pageable);

    long count(Specification<Post> spec);
}