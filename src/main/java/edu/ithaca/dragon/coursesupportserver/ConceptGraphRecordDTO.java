package edu.ithaca.dragon.coursesupportserver;

import java.util.List;

public class ConceptGraphRecordDTO {
    private int conceptGraphId;
    private List<ConceptRecord> conceptRecords;
    private List<ConceptToConcept> conceptToConceptLinks;

    // Constructor
    public ConceptGraphRecordDTO(int conceptGraphId, List<ConceptRecord> conceptRecords, List<ConceptToConcept> conceptToConceptLinks) {
        this.conceptGraphId = conceptGraphId;
        this.conceptRecords = conceptRecords;
        this.conceptToConceptLinks = conceptToConceptLinks;
    }

    // Getters and Setters
    public int getConceptGraphId() {
        return conceptGraphId;
    }

    public void setConceptGraphId(int conceptGraphId) {
        this.conceptGraphId = conceptGraphId;
    }

    public List<ConceptRecord> getConceptRecords() {
        return conceptRecords;
    }

    public void setConceptRecords(List<ConceptRecord> conceptRecords) {
        this.conceptRecords = conceptRecords;
    }

    public List<ConceptToConcept> getConceptToConceptLinks() {
        return conceptToConceptLinks;
    }

    public void setConceptToConceptLinks(List<ConceptToConcept> conceptToConceptLinks) {
        this.conceptToConceptLinks = conceptToConceptLinks;
    }
}

