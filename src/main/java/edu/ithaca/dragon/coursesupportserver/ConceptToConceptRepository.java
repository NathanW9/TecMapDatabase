package edu.ithaca.dragon.coursesupportserver;

import com.example.demo.entity.ConceptToConcept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptToConceptRepository extends JpaRepository<ConceptToConcept, Integer> {
}
