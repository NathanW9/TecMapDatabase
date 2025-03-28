package edu.ithaca.dragon.coursesupportserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conceptGraph")
public class ConceptGraphController {

    private final ConceptGraphService conceptGraphService;

    @Autowired
    public ConceptGraphController(ConceptGraphService conceptGraphService) {
        this.conceptGraphService = conceptGraphService;
    }

    // GET all ConceptGraphs
    @GetMapping
    public List<ConceptGraph> getAllConceptGraphs() {
        return conceptGraphService.findAll();
    }

    // GET a specific ConceptGraph by ID
    @GetMapping("/{id}")
    public ResponseEntity<ConceptGraph> getConceptGraphById(@PathVariable Long id) {
        Optional<ConceptGraph> conceptGraph = conceptGraphService.findById(id);
        if (conceptGraph.isPresent()) {
            return ResponseEntity.ok(conceptGraph.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST a new ConceptGraph
    @PostMapping
    public ConceptGraph createConceptGraph(@RequestBody ConceptGraph conceptGraph) {
        return conceptGraphService.save(conceptGraph);
    }

    // PUT to update an existing ConceptGraph
    @PutMapping("/{id}")
    public ResponseEntity<ConceptGraph> updateConceptGraph(@PathVariable Long id, @RequestBody ConceptGraph conceptGraph) {
        Optional<ConceptGraph> existingConceptGraph = conceptGraphService.findById(id);
        if (existingConceptGraph.isPresent()) {
            conceptGraph.setId(id);  // Ensure the correct ID is set
            ConceptGraph updated = conceptGraphService.update(conceptGraph);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a ConceptGraph by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConceptGraph(@PathVariable Long id) {
        Optional<ConceptGraph> existingConceptGraph = conceptGraphService.findById(id);
        if (existingConceptGraph.isPresent()) {
            conceptGraphService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
