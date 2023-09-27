package com.goorp.backend.repository;

import com.goorp.backend.domain.Post;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

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

            // curriculumId는 항상 null이 아니므로, 이에 대한 Predicate를 추가합니다.
            predicates.add(criteriaBuilder.equal(root.get("curriculum").get("id"), curriculumId));

            // 다른 조건들도 비슷한 방식으로 추가할 수 있습니다.
            if (classification != null) {
                predicates.add(criteriaBuilder.equal(root.get("classification"), classification));
            }

            if (stdsub != null) {
                predicates.add(criteriaBuilder.like(root.get("subject"), "%" + stdsub + "%"));
            }

            if (stack != null) {
                predicates.add(criteriaBuilder.like(root.get("stack"), "%" + stack + "%"));
            }

            if (status != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }

            if (search != null) {
                Predicate titlePredicate = criteriaBuilder.like(root.get("title"), "%" + search + "%");
                Predicate contentPredicate = criteriaBuilder.like(root.get("content"), "%" + search + "%");
                predicates.add(criteriaBuilder.or(titlePredicate, contentPredicate));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }


}
