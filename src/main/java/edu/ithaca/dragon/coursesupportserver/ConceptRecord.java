package edu.ithaca.dragon.coursesupportserver;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ConceptRecord")
public class ConceptRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String label;

    @Column(nullable = false)
    private int dataImportance;

    @ManyToMany
    @JoinTable(
        name = "ConceptToConcept",
        joinColumns = @JoinColumn(name = "ConceptId1"),
        inverseJoinColumns = @JoinColumn(name = "ConceptId2")
    )
    private Set<ConceptRecord> relatedConcepts = new HashSet<>();

    @ManyToMany(mappedBy = "conceptRecords")
    private Set<AssessmentItem> assessmentItems = new HashSet<>();

    // Getters and setters
}
