package com.goorp.backend.domain.post;

import com.goorp.backend.common.enums.Status;
import com.goorp.backend.common.enums.Subject;
import com.goorp.backend.common.enums.TechStack;
import com.goorp.backend.domain.member.Member;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
            String subject,
            String techStack,
            String status,
            String search,
            Pageable pageable) {

        BooleanBuilder builder = new BooleanBuilder(); // Querydsl 조건 빌더
//
//        // curriculumId 조건
//        if (curriculumId != null && curriculumId != 0) {
//            builder.and(post.curriculum.id.eq(curriculumId));
//        }
//
//        // classification 조건
//        if (classification != null) {
//            builder.and(post.classification.eq(classification));
//        }
//
//        // subject 조건
//        if (subject != null) {
//            Subject subjectEnum = Subject.valueOf(subject.toUpperCase());
//            builder.and(post.subjects.contains(subjectEnum));
//        }
//
//        // techStack 조건
//        if (techStack != null) {
//            TechStack stackEnum = TechStack.valueOf(techStack.toUpperCase());
//            builder.and(post.stacks.contains(stackEnum));
//        }
//
//        // status 조건
//        if (status != null) {
//            if ("1".equals(status)) {
//                builder.and(post.status.eq("0").or(post.status.eq("1")));
//            } else {
//                builder.and(post.status.eq(status));
//            }
//        }
//
//        // search 조건
//        if (search != null) {
//            builder.and(post.title.containsIgnoreCase(search)
//                    .or(post.content.containsIgnoreCase(search)));
//        }

        //if 모양 더 확인하기.
        //메소드로 만드는 것 필요한지.

        QueryResults<Post> queryResults = queryFactory
                .selectFrom(post)
                .leftJoin(post.member, member)
                .fetchJoin()
                .leftJoin(post.curriculum, curriculum)
                .fetchJoin()
                .leftJoin(post.stacks)
                .fetchJoin()
                .leftJoin(post.subjects)
                .fetchJoin()
                .where(eqCurriculum(builder, curriculumId), eqClassification(builder, classification), eqSubject(builder, subject), eqTechStack(builder, techStack), eqStatus(builder, Status.valueOf(status)), eqSearch(builder, search))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Post> content = queryResults.getResults();
        long total = queryResults.getTotal();
        Page<Post> result = new PageImpl<>(content, pageable, total);

        return result;
    }

    private BooleanBuilder eqCurriculum(BooleanBuilder builder, Long curriculumId) {
        if (curriculumId != null && curriculumId != 1) {
            builder.and(post.curriculum.id.eq(curriculumId));
        }
        return builder;
    }

    private BooleanBuilder eqClassification(BooleanBuilder builder, String classification) {
        if (classification != null) {
            builder.and(post.classification.eq(classification));
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

    private BooleanBuilder eqStatus(BooleanBuilder builder, Status status) {
        if (status != null) {
            if (Status.COMPLETED.equals(status)) {
                builder.and(post.status.eq(String.valueOf(Status.RECRUITING))
                        .or(post.status.eq(String.valueOf(Status.COMPLETED))));
            } else {
                builder.and(post.status.eq(String.valueOf(status)));
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
