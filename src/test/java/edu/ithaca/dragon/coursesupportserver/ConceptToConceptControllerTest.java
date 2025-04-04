package edu.ithaca.dragon.coursesupportserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ConceptToConceptController.class)
class ConceptToConceptControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConceptToConceptService conceptToConceptService;

    private ConceptToConcept conceptToConcept;

    @BeforeEach
    void setUp() {
        conceptToConcept = new ConceptToConcept();
        conceptToConcept.setDataImportance(10.0);
        // Add more fields as necessary
    }

    @Test
    void testGetAllConceptToConcepts() throws Exception {
        when(conceptToConceptService.findAll()).thenReturn(List.of(conceptToConcept));

        mockMvc.perform(get("/api/conceptToConcept"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dataImportance").value(10.0));
        verify(conceptToConceptService, times(1)).findAll();
    }

    @Test
    void testGetConceptToConceptById() throws Exception {
        int concept1Id = 1;
        int concept2Id = 2;
        when(conceptToConceptService.findByConceptIds(concept1Id, concept2Id)).thenReturn(Optional.of(conceptToConcept));

        mockMvc.perform(get("/api/conceptToConcept/{concept1Id}/{concept2Id}", concept1Id, concept2Id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dataImportance").value(10.0));
        verify(conceptToConceptService, times(1)).findByConceptIds(concept1Id, concept2Id);
    }

    @Test
    void testCreateConceptToConcept() throws Exception {
        when(conceptToConceptService.save(any(ConceptToConcept.class))).thenReturn(conceptToConcept);

        mockMvc.perform(post("/api/conceptToConcept")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"dataImportance\": 10.0 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dataImportance").value(10.0));
        verify(conceptToConceptService, times(1)).save(any(ConceptToConcept.class));
    }

    @Test
    void testUpdateConceptToConcept() throws Exception {
        int concept1Id = 1;
        int concept2Id = 2;
        when(conceptToConceptService.findByConceptIds(concept1Id, concept2Id)).thenReturn(Optional.of(conceptToConcept));
        when(conceptToConceptService.update(any(ConceptToConcept.class))).thenReturn(conceptToConcept);

        mockMvc.perform(put("/api/conceptToConcept/{concept1Id}/{concept2Id}", concept1Id, concept2Id)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"dataImportance\": 15.0 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dataImportance").value(10.0));
        verify(conceptToConceptService, times(1)).update(any(ConceptToConcept.class));
    }

    @Test
    void testDeleteConceptToConcept() throws Exception {
        int concept1Id = 1;
        int concept2Id = 2;
        doNothing().when(conceptToConceptService).deleteByConceptIds(concept1Id, concept2Id);

        mockMvc.perform(delete("/api/conceptToConcept/{concept1Id}/{concept2Id}", concept1Id, concept2Id))
                .andExpect(status().isNoContent());
        verify(conceptToConceptService, times(1)).deleteByConceptIds(concept1Id, concept2Id);
    }
}
