package com.goorp.backend.domain.post;

import com.goorp.backend.common.enums.Classification;
import com.goorp.backend.common.enums.Status;
import com.goorp.backend.common.enums.Subject;
import com.goorp.backend.common.enums.TechStack;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import static com.goorp.backend.domain.curriculum.QCurriculum.curriculum;
import static com.goorp.backend.domain.member.QMember.member;
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

    public Page<Post> findByMemberAccountId(String accountId, PageRequest pageRequest) {
        return jpaPostRepository.findByMemberAccountId(accountId, pageRequest);
    }

    public Page<Post> findAll(
            Long curriculumId,
            String classification,
            String subject,
            String techStack,
            String status,
            String search,
            Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        List<Post> content = queryFactory
                .selectFrom(post)
                .leftJoin(post.member, member).fetchJoin()
                .leftJoin(post.curriculum, curriculum).fetchJoin()
                .leftJoin(post.stacks).fetchJoin()
                .leftJoin(post.subjects).fetchJoin()
                .where(
                        eqCurriculum(builder, curriculumId),
                        eqClassification(builder, classification),
                        eqSubject(builder, subject),
                        eqTechStack(builder, techStack),
                        eqStatus(builder, status),
                        eqSearch(builder, search)
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(content, pageable, content.size());
    }

    private BooleanBuilder eqCurriculum(BooleanBuilder builder, Long curriculumId) {
        if (curriculumId != null && curriculumId != 1) {
            builder.and(post.curriculum.id.eq(curriculumId));
        }
        return builder;
    }

    private BooleanBuilder eqClassification(BooleanBuilder builder, String classification) {
        if (classification != null) {
            Classification classificationEnum = Classification.valueOf(classification.toUpperCase());
            builder.and(post.classification.eq(classificationEnum));
        }
        return builder;
    }

    private BooleanBuilder eqSubject(BooleanBuilder builder, String subject) {
        if (subject != null) {
            Subject subjectEnum = Subject.valueOf(subject.toUpperCase());
            builder.and(post.subjects.contains(subjectEnum));
        }
        return builder;
    }

    private BooleanBuilder eqTechStack(BooleanBuilder builder, String techStack) {
        if (techStack != null) {
            TechStack techStackEnum = TechStack.valueOf(techStack.toUpperCase());
            builder.and(post.stacks.contains(techStackEnum));
        }
        return builder;
    }

    private BooleanBuilder eqStatus(BooleanBuilder builder, String status) {
        if (status != null) {
            Status statusEnum = Status.valueOf(status.toUpperCase());
            if (Status.COMPLETED.equals(statusEnum)) {
                builder.and(post.status.eq(Status.RECRUITING)
                        .or(post.status.eq(Status.COMPLETED)));
            } else {
                builder.and(post.status.eq(statusEnum));
            }
        }
        return builder;
    }

    private BooleanBuilder eqSearch(BooleanBuilder builder, String search) {
        if (search != null) {
            builder.and(
                    post.title.containsIgnoreCase(search)
                            .or(post.content.containsIgnoreCase(search))
            );
        }
        return builder;
    }
}
