package com.goorp.backend.repository;

import com.goorp.backend.domain.Post;
import com.goorp.backend.domain.vo.Subject;
import com.goorp.backend.domain.vo.TechStack;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.SetJoin;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class PostSpecification {

    public static Specification<Post> filter(
        Long curriculumId,
        String classification,
        String subject,
        String techStack,
        String status,
        String search
    ) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // curriculumId가 0일떄는 전체조회이므로 0일때는 조건을 추가하지 않고 0이 아니면 조건을 추가한다.
            if (curriculumId == 1) {
            } else {
                predicates.add(
                    criteriaBuilder.equal(root.get("curriculum").get("id"), curriculumId));
            }

            if (classification != null) {
                predicates.add(criteriaBuilder.equal(root.get("classification"), classification));
            }

            if (subject != null) {
                Subject subjectEnum = Subject.valueOf(subject.toUpperCase());
                SetJoin<Post, Subject> subjectsJoin = root.joinSet("subjects", JoinType.LEFT);
                predicates.add(subjectsJoin.in(subjectEnum));
            }


            if (techStack != null) {
                TechStack stackEnum = TechStack.valueOf(techStack.toUpperCase());
                SetJoin<Post, TechStack> stacksJoin = root.joinSet("stacks", JoinType.LEFT);
                predicates.add(stacksJoin.in(stackEnum));
            }

            if (status != null) {
                if ("1".equals(status)) {
                    // status가 "1"인 경우, status값이 "0" 또는 "1"인 Post를 모두 조회
                    Predicate statusZero = criteriaBuilder.equal(root.get("status"), "0");
                    Predicate statusOne = criteriaBuilder.equal(root.get("status"), "1");
                    predicates.add(criteriaBuilder.or(statusZero, statusOne));
                } else {
                    predicates.add(criteriaBuilder.equal(root.get("status"), status));
                }
            }

            if (search != null) {
                Predicate titlePredicate = criteriaBuilder.like(root.get("title"),
                    "%" + search + "%");
                Predicate contentPredicate = criteriaBuilder.like(root.get("content"),
                    "%" + search + "%");
                predicates.add(criteriaBuilder.or(titlePredicate, contentPredicate));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}