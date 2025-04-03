package edu.ithaca.dragon.coursesupportserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ConceptToConceptRepository extends JpaRepository<ConceptToConcept, Integer> {
    Optional<ConceptToConcept> findByConcept1AndConcept2(ConceptRecord concept1, ConceptRecord concept2);
}
