package edu.ithaca.dragon.coursesupportserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConceptRecordService {

    @Autowired
    private ConceptRecordRepository conceptRecordRepository;

    public List<ConceptRecord> getAllConceptRecords() {
        return conceptRecordRepository.findAll();
    }

    public Optional<ConceptRecord> getConceptRecordById(int id) {
        return conceptRecordRepository.findById(id);
    }

    public ConceptRecord addConceptRecord(ConceptRecord conceptRecord) {
        return conceptRecordRepository.save(conceptRecord);
    }

    public void deleteConceptRecord(int id) {
        conceptRecordRepository.deleteById(id);
    }

    public ConceptRecord updateConceptRecord(int id, ConceptRecord conceptRecord) {
        conceptRecord.setId(id);
        return conceptRecordRepository.save(conceptRecord);
    }
}