package edu.ithaca.dragon.coursesupportserver;

import com.example.demo.entity.AssessmentItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentItemRepository extends JpaRepository<AssessmentItem, Integer> {
}
