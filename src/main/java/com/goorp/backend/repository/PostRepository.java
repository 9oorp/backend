package com.goorp.backend.repository;

import com.goorp.backend.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

    @Query("select p from Post p " +
            "join fetch p.member " +
            "join fetch p.curriculum " +
            "join fetch p.stacks " +
            "join fetch p.subjects " +
            "where p.id = :postId")
    Optional<Post> findById(@Param("postId") Long postId);

    @EntityGraph(attributePaths = {"member", "stacks", "subjects"})
    Page<Post> findAll(Specification<Post> spec, Pageable pageable);


    @EntityGraph(attributePaths = {"curriculum", "member"})
    Page<Post> findByMember_AccountId(String accountId, Pageable pageable);

    long count(Specification<Post> spec);
}