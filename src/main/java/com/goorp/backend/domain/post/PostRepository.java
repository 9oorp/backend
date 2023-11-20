package com.goorp.backend.domain.post;

import com.goorp.backend.domain.member.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;
import java.util.Optional;

import static com.goorp.backend.domain.post.QPost.*;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final JPAQueryFactory queryFactory;
    private final JpaPostRepository jpaPostRepository;

    public Post save(Post post) {
        return jpaPostRepository.save(post);
    }

    public void delete(Post post) {
        jpaPostRepository.delete(post);
    }

    public void deleteById(Long id) {
        jpaPostRepository.deleteById(id);
    }

    public Optional<Post> findById(Long id) {
        return jpaPostRepository.findById(id);
    }

    public long count(Specification<Post> spec) {
        return jpaPostRepository.count(spec);
    }

    public Page<Post> findAll(Specification<Post> spec, Pageable pageable) {
        return jpaPostRepository.findAll(spec, pageable);
    }

    public Page<Post> findByMemberAccountId(String accountId, PageRequest pageRequest) {
        return jpaPostRepository.findByMemberAccountId(accountId, pageRequest);
    }

    public Page<Post> findAll(
            Long curriculumId,
            String classification,
            String sort,
            String stdsub,
            String stack,
            String status,
            String search,
            Pageable pageable) {
        //
        return null;
    }
}
