package edu.ithaca.dragon.coursesupportserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConceptToConceptService {

    private final ConceptToConceptRepository conceptToConceptRepository;

    @Autowired
    public ConceptToConceptService(ConceptToConceptRepository conceptToConceptRepository) {
        this.conceptToConceptRepository = conceptToConceptRepository;
    }

    // Method to retrieve all ConceptToConcept entries
    public List<ConceptToConcept> findAll() {
        return conceptToConceptRepository.findAll();
    }

    // Method to retrieve a specific ConceptToConcept by its ID (Composite ID)
    public Optional<ConceptToConcept> findById(int id) {
        return conceptToConceptRepository.findById(id);
    }

    // Method to save a new ConceptToConcept entry
    public ConceptToConcept save(ConceptToConcept conceptToConcept) {
        return conceptToConceptRepository.save(conceptToConcept);
    }

    // Method to delete a ConceptToConcept entry
    public void deleteById(Long id) {
        conceptToConceptRepository.deleteById(id);
    }

    // Method to update a ConceptToConcept entry
    public ConceptToConcept update(ConceptToConcept conceptToConcept) {
        return conceptToConceptRepository.save(conceptToConcept);
    }
}