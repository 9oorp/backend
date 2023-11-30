package com.goorp.backend.domain.member;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByAccountId(String accountId);

    Optional<Member> findByName(String name);

    boolean existsByAccountId(String accountId);
}