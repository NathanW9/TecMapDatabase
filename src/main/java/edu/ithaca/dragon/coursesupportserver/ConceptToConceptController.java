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

    // GET a specific ConceptToConcept by composite ID (ConceptRecord1, ConceptRecord2)
    @GetMapping("/{concept1Id}/{concept2Id}")
    public ResponseEntity<ConceptToConcept> getConceptToConceptById(@PathVariable int concept1Id, @PathVariable int concept2Id) {
        Optional<ConceptToConcept> conceptToConcept = conceptToConceptService.findByConceptIds(concept1Id, concept2Id);
        return conceptToConcept.map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST a new ConceptToConcept
    @PostMapping
    public ConceptToConcept createConceptToConcept(@RequestBody ConceptToConcept conceptToConcept) {
        return conceptToConceptService.save(conceptToConcept);
    }

    // PUT to update an existing ConceptToConcept by composite ID
    @PutMapping("/{concept1Id}/{concept2Id}")
    public ResponseEntity<ConceptToConcept> updateConceptToConcept(@PathVariable int concept1Id, @PathVariable int concept2Id, @RequestBody ConceptToConcept conceptToConcept) {
        Optional<ConceptToConcept> existingConceptToConcept = conceptToConceptService.findByConceptIds(concept1Id, concept2Id);
        if (existingConceptToConcept.isPresent()) {
            conceptToConcept.setConceptGraph(existingConceptToConcept.get().getConceptGraph()); // Keep ConceptGraph ID
            ConceptToConcept updated = conceptToConceptService.update(conceptToConcept);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a ConceptToConcept by composite ID
    @DeleteMapping("/{concept1Id}/{concept2Id}")
    public ResponseEntity<Void> deleteConceptToConcept(@PathVariable int concept1Id, @PathVariable int concept2Id) {
        Optional<ConceptToConcept> existingConceptToConcept = conceptToConceptService.findByConceptIds(concept1Id, concept2Id);
        if (existingConceptToConcept.isPresent()) {
            conceptToConceptService.deleteByConceptIds(concept1Id, concept2Id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
