package edu.ithaca.dragon.coursesupportserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConceptGraphService {

    @Autowired
    private ConceptGraphRepository conceptGraphRepository;

    @Autowired
    private ConceptRecordRepository conceptRecordRepository;

    @Autowired
    private ConceptToConceptRepository conceptToConceptRepository;

    // Fetch the ConceptGraphRecordDTO by conceptGraphId
    public ConceptGraphRecordDTO getConceptGraphRecord(int conceptGraphId) {
        // Fetch the concept graph by its ID
        Optional<ConceptGraph> conceptGraphOptional = conceptGraphRepository.findById(conceptGraphId);
        if (conceptGraphOptional.isPresent()) {
            ConceptGraph conceptGraph = conceptGraphOptional.get();

            // Fetch all concept records related to this concept graph
            List<ConceptRecord> conceptRecords = conceptRecordRepository.findByConceptGraphId(conceptGraphId);

            // Fetch all concept-to-concept links related to this concept graph
            List<ConceptToConcept> conceptToConceptLinks = conceptToConceptRepository.findByConceptGraphId(conceptGraphId);

            // Return the DTO containing the concept graph data
            return new ConceptGraphRecordDTO(conceptGraphId, conceptRecords, conceptToConceptLinks);
        }

        return null;  // If concept graph not found
    }
}
