package com.goorp.backend.repository;

import com.goorp.backend.domain.Post;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class PostSpecification {

    public static Specification<Post> filter(
        Long curriculumId,
        String classification,
        String stdsub,
        String stack,
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

            // 다른 조건들도 비슷한 방식으로 추가할 수 있습니다.
            if (classification != null) {
                predicates.add(criteriaBuilder.equal(root.get("classification"), classification));
            }

            if (stdsub != null) {
                predicates.add(criteriaBuilder.like(root.get("subject"), "%" + stdsub + "%"));
            }

            //            if (stdsub != null) {
//                String[] keywords = stack.split(",");
//                List<Predicate> stackPredicates = new ArrayList<>();
//                for (String keyword : keywords) {
//                    stackPredicates.add(criteriaBuilder.like(root.get("stdsub"), "%" + keyword.trim() + "%"));
//                }
//                predicates.add(criteriaBuilder.and(stackPredicates.toArray(new Predicate[0])));
//            }

            if (stack != null) {
                predicates.add(criteriaBuilder.like(root.get("stack"), "%" + stack + "%"));
            }
//            if (stack != null) {
//                String[] keywords = stack.split(",");
//                List<Predicate> stackPredicates = new ArrayList<>();
//                for (String keyword : keywords) {
//                    stackPredicates.add(criteriaBuilder.like(root.get("stack"), "%" + keyword.trim() + "%"));
//                }
//                predicates.add(criteriaBuilder.and(stackPredicates.toArray(new Predicate[0])));
//            }

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