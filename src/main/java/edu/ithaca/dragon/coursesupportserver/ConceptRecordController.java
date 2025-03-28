package edu.ithaca.dragon.coursesupportserver;

import com.example.demo.entity.ConceptRecord;
import com.example.demo.service.ConceptRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/concept-records")
public class ConceptRecordController {

    @Autowired
    private ConceptRecordService conceptRecordService;

    @GetMapping
    public List<ConceptRecord> getAllConceptRecords() {
        return conceptRecordService.getAllConceptRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConceptRecord> getConceptRecordById(@PathVariable int id) {
        Optional<ConceptRecord> conceptRecord = conceptRecordService.getConceptRecordById(id);
        return conceptRecord.map(ResponseEntity::ok)
                            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ConceptRecord addConceptRecord(@RequestBody ConceptRecord conceptRecord) {
        return conceptRecordService.addConceptRecord(conceptRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConceptRecord> updateConceptRecord(@PathVariable int id, @RequestBody ConceptRecord conceptRecord) {
        return ResponseEntity.ok(conceptRecordService.updateConceptRecord(id, conceptRecord));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConceptRecord(@PathVariable int id) {
        conceptRecordService.deleteConceptRecord(id);
        return ResponseEntity.noContent().build();
    }
}