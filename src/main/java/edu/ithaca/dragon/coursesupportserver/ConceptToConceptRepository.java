package edu.ithaca.dragon.coursesupportserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConceptToConceptRepository extends JpaRepository<ConceptToConcept, Long> {

    // Method to find ConceptToConcept by both concept IDs
    Optional<ConceptToConcept> findByConceptIds(int concept1Id, int concept2Id);

    // Method to delete ConceptToConcept by both concept IDs
    void deleteByConceptIds(int concept1Id, int concept2Id);

    // Query to find all concept-to-concept links by concept graph ID
    List<ConceptToConcept> findByConceptGraphId(int conceptGraphId);
}
