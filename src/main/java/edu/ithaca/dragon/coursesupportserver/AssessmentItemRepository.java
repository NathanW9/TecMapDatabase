package edu.ithaca.dragon.coursesupportserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentItemRepository extends JpaRepository<AssessmentItem, Integer> {
}
