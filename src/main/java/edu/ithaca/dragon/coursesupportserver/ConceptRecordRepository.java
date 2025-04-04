package edu.ithaca.dragon.coursesupportserver;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptRecordRepository extends JpaRepository<ConceptRecord, Integer> {
    List<ConceptRecord> findByConceptGraphId(int conceptGraphId);
}
