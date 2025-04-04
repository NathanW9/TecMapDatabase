package edu.ithaca.dragon.coursesupportserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = CoursesupportserverApplication.class)
@AutoConfigureMockMvc
class ConceptGraphControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConceptGraphRepository conceptGraphRepository;

    @MockBean
    private ConceptRecordRepository conceptRecordRepository;

    @MockBean
    private ConceptToConceptRepository conceptToConceptRepository;

    @InjectMocks
    private ConceptGraphService conceptGraphService;

    @BeforeEach
    void setUp() {
        // Mock data
        ConceptGraph conceptGraph = new ConceptGraph();
        conceptGraph.setId(1);
        
        ConceptRecord conceptRecord1 = new ConceptRecord();
        conceptRecord1.setId(1);
        conceptRecord1.setLabel("Concept 1");
        
        ConceptRecord conceptRecord2 = new ConceptRecord();
        conceptRecord2.setId(2);
        conceptRecord2.setLabel("Concept 2");

        ConceptToConcept conceptToConcept1 = new ConceptToConcept();
        conceptToConcept1.setConcept1(conceptRecord1);
        conceptToConcept1.setConcept2(conceptRecord2);
        conceptToConcept1.setDataImportance(0.5);
        
        when(conceptGraphRepository.findById(1)).thenReturn(Optional.of(conceptGraph));
        when(conceptRecordRepository.findByConceptGraphId(1)).thenReturn(Arrays.asList(conceptRecord1, conceptRecord2));
        when(conceptToConceptRepository.findByConceptGraphId(1)).thenReturn(Arrays.asList(conceptToConcept1));
    }

    @Test
    void testGetConceptGraphRecord() throws Exception {
        // Perform a GET request to the /api/concept-graphs/1 endpoint
        mockMvc.perform(get("/api/concept-graphs/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.conceptGraphId").value(1))
                .andExpect(jsonPath("$.conceptRecords.length()").value(2))  // Expecting two concept records
                .andExpect(jsonPath("$.conceptRecords[0].label").value("Concept 1"))
                .andExpect(jsonPath("$.conceptRecords[1].label").value("Concept 2"))
                .andExpect(jsonPath("$.conceptToConceptLinks.length()").value(1))  // Expecting one concept-to-concept link
                .andExpect(jsonPath("$.conceptToConceptLinks[0].dataImportance").value(0.5));
    }
}
