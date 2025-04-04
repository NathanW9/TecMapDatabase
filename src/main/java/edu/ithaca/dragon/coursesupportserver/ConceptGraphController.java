package edu.ithaca.dragon.coursesupportserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/concept-graphs")
public class ConceptGraphController {

    @Autowired
    private ConceptGraphService conceptGraphService;

    @GetMapping("/{conceptGraphId}")
    public ResponseEntity<ConceptGraphRecordDTO> getConceptGraph(@PathVariable int conceptGraphId) {
        // Fetch the concept graph record
        ConceptGraphRecordDTO conceptGraphRecord = conceptGraphService.getConceptGraphRecord(conceptGraphId);

        // If the concept graph record is found, return it, otherwise return 404 Not Found
        if (conceptGraphRecord != null) {
            return ResponseEntity.ok(conceptGraphRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
