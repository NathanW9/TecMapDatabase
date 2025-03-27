package edu.ithaca.dragon.coursesupportserver;

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

    // Getters and setters
}
