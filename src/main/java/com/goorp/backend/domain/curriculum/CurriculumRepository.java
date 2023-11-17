package com.goorp.backend.domain.curriculum;

import com.goorp.backend.domain.curriculum.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {

}
