package edu.ithaca.dragon.coursesupportserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConceptRecordServiceTest {

    @Mock
    private ConceptRecordRepository conceptRecordRepository;

    @Mock
    private AssessmentItemRepository assessmentItemRepository;

    @InjectMocks
    private ConceptRecordService conceptRecordService;

    private ConceptRecord conceptRecord;
    private AssessmentItem assessmentItem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks

        // Sample concept record and assessment item for testing
        conceptRecord = new ConceptRecord();
        conceptRecord.setId(1);
        conceptRecord.setLabel("Concept 1");

        assessmentItem = new AssessmentItem();
        assessmentItem.setId(1);
        assessmentItem.setMaxPossibleKnowledgeEstimate(100);
        assessmentItem.setDataImportance(5);

        // Set up the relationship between conceptRecord and assessmentItem
        Set<ConceptRecord> conceptSet = new HashSet<>();
        conceptSet.add(conceptRecord);
        assessmentItem.setConceptRecords(conceptSet);
        conceptRecord.setAssessmentItems(Set.of(assessmentItem));
    }

    @Test
    public void testGetAllConceptRecords() {
        // Arrange
        List<ConceptRecord> mockList = List.of(conceptRecord);
        when(conceptRecordRepository.findAll()).thenReturn(mockList);

        // Act
        List<ConceptRecord> result = conceptRecordService.getAllConceptRecords();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Concept 1", result.get(0).getLabel());
    }

    @Test
    public void testGetConceptRecordById_Found() {
        // Arrange
        when(conceptRecordRepository.findById(1)).thenReturn(Optional.of(conceptRecord));

        // Act
        Optional<ConceptRecord> result = conceptRecordService.getConceptRecordById(1);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Concept 1", result.get().getLabel());
    }

    @Test
    public void testAddConceptRecord() {
        // Arrange
        when(conceptRecordRepository.save(conceptRecord)).thenReturn(conceptRecord);

        // Act
        ConceptRecord result = conceptRecordService.addConceptRecord(conceptRecord);

        // Assert
        assertNotNull(result);
        assertEquals("Concept 1", result.getLabel());
        verify(conceptRecordRepository, times(1)).save(conceptRecord);
    }

    @Test
    public void testUpdateConceptRecord() {
        // Arrange
        ConceptRecord updatedConceptRecord = new ConceptRecord();
        updatedConceptRecord.setId(1);
        updatedConceptRecord.setLabel("Updated Concept");

        when(conceptRecordRepository.save(updatedConceptRecord)).thenReturn(updatedConceptRecord);

        // Act
        ConceptRecord result = conceptRecordService.updateConceptRecord(1, updatedConceptRecord);

        // Assert
        assertNotNull(result);
        assertEquals("Updated Concept", result.getLabel());
        verify(conceptRecordRepository, times(1)).save(updatedConceptRecord);
    }

    @Test
    public void testDeleteConceptRecord() {
        // Act
        conceptRecordService.deleteConceptRecord(1);

        // Assert
        verify(conceptRecordRepository, times(1)).deleteById(1);
    }

    // Test for assessment item relationship with conceptRecord
    @Test
    public void testAddAssessmentItemToConceptRecord() {
        // Arrange
        Set<AssessmentItem> assessmentItems = new HashSet<>();
        assessmentItems.add(assessmentItem);

        when(assessmentItemRepository.save(assessmentItem)).thenReturn(assessmentItem);

        // Act
        Set<AssessmentItem> result = conceptRecord.getAssessmentItems();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(assessmentItem));
    }
}