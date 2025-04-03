package edu.ithaca.dragon.coursesupportserver.hidden;

import com.example.demo.entity.Cohort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Integer> {
}
