package com.goorp.backend.repository;

import com.goorp.backend.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByCurriculumIdAndId(Long curriculumId, Long postId);

    List<Post> findByCurriculumId(Long curriculumId);

}
