package com.goorp.backend.domain.comment;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT DISTINCT c FROM Comment c LEFT JOIN FETCH c.replies WHERE c.post.id = :postId")
    List<Comment> findByPostId(@Param("postId") Long postId);
}