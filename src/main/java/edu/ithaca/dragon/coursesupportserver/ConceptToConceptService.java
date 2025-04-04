package edu.ithaca.dragon.coursesupportserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConceptToConceptService {

    @Autowired
    private ConceptToConceptRepository conceptToConceptRepository;

    public List<ConceptToConcept> findAll() {
        return conceptToConceptRepository.findAll();
    }

    public Optional<ConceptToConcept> findByConceptIds(int concept1Id, int concept2Id) {
        return conceptToConceptRepository.findByConceptIds(concept1Id, concept2Id);
    }

    public ConceptToConcept save(ConceptToConcept conceptToConcept) {
        return conceptToConceptRepository.save(conceptToConcept);
    }

    public ConceptToConcept update(ConceptToConcept conceptToConcept) {
        return conceptToConceptRepository.save(conceptToConcept);
    }

    public void deleteByConceptIds(int concept1Id, int concept2Id) {
        conceptToConceptRepository.deleteByConceptIds(concept1Id, concept2Id);
    }
}
