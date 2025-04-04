package edu.ithaca.dragon.coursesupportserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ConceptToConceptServiceTest {

    @Mock
    private ConceptToConceptRepository conceptToConceptRepository;

    @InjectMocks
    private ConceptToConceptService conceptToConceptService;

    private ConceptToConcept conceptToConcept;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Setting up a sample ConceptToConcept object for testing
        conceptToConcept = new ConceptToConcept();
        conceptToConcept.setDataImportance(10.0);
        // Add more fields as necessary
    }

    @Test
    void testFindAll() {
        // Arrange
        when(conceptToConceptRepository.findAll()).thenReturn(List.of(conceptToConcept));

        // Act
        var result = conceptToConceptService.findAll();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(conceptToConcept, result.get(0));
        verify(conceptToConceptRepository, times(1)).findAll();
    }

    @Test
    void testFindByConceptIds() {
        // Arrange
        int concept1Id = 1;
        int concept2Id = 2;
        when(conceptToConceptRepository.findByConceptIds(concept1Id, concept2Id))
                .thenReturn(Optional.of(conceptToConcept));

        // Act
        var result = conceptToConceptService.findByConceptIds(concept1Id, concept2Id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(conceptToConcept, result.get());
        verify(conceptToConceptRepository, times(1)).findByConceptIds(concept1Id, concept2Id);
    }

    @Test
    void testSaveConceptToConcept() {
        // Arrange
        when(conceptToConceptRepository.save(conceptToConcept)).thenReturn(conceptToConcept);

        // Act
        var result = conceptToConceptService.save(conceptToConcept);

        // Assert
        assertNotNull(result);
        assertEquals(conceptToConcept, result);
        verify(conceptToConceptRepository, times(1)).save(conceptToConcept);
    }

    @Test
    void testDeleteByConceptIds() {
        // Arrange
        int concept1Id = 1;
        int concept2Id = 2;
        doNothing().when(conceptToConceptRepository).deleteByConceptIds(concept1Id, concept2Id);

        // Act
        conceptToConceptService.deleteByConceptIds(concept1Id, concept2Id);

        // Assert
        verify(conceptToConceptRepository, times(1)).deleteByConceptIds(concept1Id, concept2Id);
    }

    @Test
    void testUpdateConceptToConcept() {
        // Arrange
        when(conceptToConceptRepository.save(conceptToConcept)).thenReturn(conceptToConcept);

        // Act
        var result = conceptToConceptService.update(conceptToConcept);

        // Assert
        assertNotNull(result);
        assertEquals(conceptToConcept, result);
        verify(conceptToConceptRepository, times(1)).save(conceptToConcept);
    }
}
