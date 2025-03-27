package edu.ithaca.dragon.coursesupportserver;

import com.example.demo.entity.ConceptRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptRecordRepository extends JpaRepository<ConceptRecord, Integer> {
}
