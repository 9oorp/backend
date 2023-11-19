package com.goorp.backend.domain.post;

import com.goorp.backend.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepository {

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
}
