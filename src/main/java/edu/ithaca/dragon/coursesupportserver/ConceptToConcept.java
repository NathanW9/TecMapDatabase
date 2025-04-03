package edu.ithaca.dragon.coursesupportserver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ConceptToConcept")
public class ConceptToConcept {
    @Id
    @ManyToOne
    @JoinColumn(name = "ConceptId1", nullable = false)
    private ConceptRecord concept1;

    @Id
    @ManyToOne
    @JoinColumn(name = "ConceptId2", nullable = false)
    private ConceptRecord concept2;

    @ManyToOne
    @JoinColumn(name = "ConceptGraphId", nullable = false)
    private ConceptGraph conceptGraph;

     @Column(name = "DataImportance")
    private double dataImportance;

    // Getters and setters
    public ConceptRecord getConcept1() {
        return concept1;
    }

    public void setConcept1(ConceptRecord concept1) {
        this.concept1 = concept1;
    }

    public ConceptRecord getConcept2() {
        return concept2;
    }

    public void setConcept2(ConceptRecord concept2) {
        this.concept2 = concept2;
    }

    public ConceptGraph getConceptGraph() {
        return conceptGraph;
    }

    public void setConceptGraph(ConceptGraph conceptGraph) {
        this.conceptGraph = conceptGraph;
    }

    public double getDataImportance() {
        return dataImportance;
    }

    public void setDataImportance(double dataImportance) {
        this.dataImportance = dataImportance;
    }
}
