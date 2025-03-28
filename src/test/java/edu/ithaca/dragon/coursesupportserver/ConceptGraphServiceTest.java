package edu.ithaca.dragon.coursesupportserver;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

public class ConceptGraphServiceTest {

    @Test
    public void testFindById() {
        ConceptGraphRepository repository = mock(ConceptGraphRepository.class);
        ConceptGraphService service = new ConceptGraphService(repository);
        
        ConceptGraph conceptGraph = new ConceptGraph("Test Graph");
        when(repository.findById(1L)).thenReturn(Optional.of(conceptGraph));
        
        Optional<ConceptGraph> result = service.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Test Graph", result.get().getName());
    }
}
