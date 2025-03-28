package edu.ithaca.dragon.coursesupportserver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conceptToConcept")
public class ConceptToConceptController {

    private final ConceptToConceptService conceptToConceptService;

    @Autowired
    public ConceptToConceptController(ConceptToConceptService conceptToConceptService) {
        this.conceptToConceptService = conceptToConceptService;
    }

    // GET all ConceptToConcept entries
    @GetMapping
    public List<ConceptToConcept> getAllConceptToConcepts() {
        return conceptToConceptService.findAll();
    }

    // GET a specific ConceptToConcept by ID
    @GetMapping("/{id}")
    public ResponseEntity<ConceptToConcept> getConceptToConceptById(@PathVariable Long id) {
        Optional<ConceptToConcept> conceptToConcept = conceptToConceptService.findById(id);
        if (conceptToConcept.isPresent()) {
            return ResponseEntity.ok(conceptToConcept.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST a new ConceptToConcept
    @PostMapping
    public ConceptToConcept createConceptToConcept(@RequestBody ConceptToConcept conceptToConcept) {
        return conceptToConceptService.save(conceptToConcept);
    }

    // PUT to update an existing ConceptToConcept
    @PutMapping("/{id}")
    public ResponseEntity<ConceptToConcept> updateConceptToConcept(@PathVariable Long id, @RequestBody ConceptToConcept conceptToConcept) {
        Optional<ConceptToConcept> existingConceptToConcept = conceptToConceptService.findById(id);
        if (existingConceptToConcept.isPresent()) {
            conceptToConcept.setConceptGraph(existingConceptToConcept.get().getConceptGraph()); // Keep ConceptGraph ID
            ConceptToConcept updated = conceptToConceptService.update(conceptToConcept);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a ConceptToConcept by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConceptToConcept(@PathVariable Long id) {
        Optional<ConceptToConcept> existingConceptToConcept = conceptToConceptService.findById(id);
        if (existingConceptToConcept.isPresent()) {
            conceptToConceptService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}