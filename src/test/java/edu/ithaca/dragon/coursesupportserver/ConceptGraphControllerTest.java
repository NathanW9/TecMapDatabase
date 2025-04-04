package edu.ithaca.dragon.coursesupportserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ConceptGraphController.class)
public class ConceptGraphControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetConceptGraph() throws Exception {
        // Test the GET request with a valid concept graph ID
        mockMvc.perform(get("/api/concept-graphs/1"))  // Change the ID as needed
                .andExpect(status().isOk()) // Expect HTTP 200 OK
                .andExpect(content().contentType("application/json"))  // Expect JSON response
                .andExpect(jsonPath("$.conceptGraphId").value(1))  // Check if conceptGraphId is 1
                .andExpect(jsonPath("$.conceptRecords").isArray())  // Ensure conceptRecords is an array
                .andExpect(jsonPath("$.conceptRecords[0].id").value(1));  // Check first ConceptRecord ID
    }

    @Test
    public void testGetConceptGraphNotFound() throws Exception {
        // Test the GET request with a non-existing concept graph ID
        mockMvc.perform(get("/api/concept-graphs/999"))  // Use a non-existent ID
                .andExpect(status().isNotFound());  // Expect HTTP 404 Not Found
    }
}
