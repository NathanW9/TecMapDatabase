package edu.ithaca.dragon.coursesupportserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@ContextConfiguration
public class ConceptRecordRepositoryIntegrationTest {

    @Autowired
    private ConceptRecordRepository conceptRecordRepository;

    @Autowired
    private AssessmentItemRepository assessmentItemRepository;

    private ConceptRecord conceptRecord;
    private AssessmentItem assessmentItem;

    @BeforeEach
    public void setUp() {
        // Create concept record and assessment item for integration test
        conceptRecord = new ConceptRecord();
        conceptRecord.setLabel("Concept 1");

        assessmentItem = new AssessmentItem();
        assessmentItem.setMaxPossibleKnowledgeEstimate(100);
        assessmentItem.setDataImportance(5);
    }

    @Test
    public void testSaveAndRetrieveConceptRecord() {
        // Save entities
        conceptRecord = conceptRecordRepository.save(conceptRecord);
        assessmentItem = assessmentItemRepository.save(assessmentItem);

        // Establish relationship
        conceptRecord.getAssessmentItems().add(assessmentItem);
        assessmentItem.getConceptRecords().add(conceptRecord);

        conceptRecordRepository.save(conceptRecord);

        // Retrieve and assert
        Optional<ConceptRecord> retrievedConceptRecord = conceptRecordRepository.findById(conceptRecord.getId());
        assertTrue(retrievedConceptRecord.isPresent());
        assertEquals("Concept 1", retrievedConceptRecord.get().getLabel());
        assertEquals(1, retrievedConceptRecord.get().getAssessmentItems().size());
    }
}
