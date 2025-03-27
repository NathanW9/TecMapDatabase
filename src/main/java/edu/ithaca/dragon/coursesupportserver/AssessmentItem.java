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
@Table(name = "AssessmentItem")
public class AssessmentItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 10, scale = 2, nullable = false)
    private double maxPossibleKnowledgeEstimate;

    @Column(nullable = false)
    private int dataImportance;

    @ManyToMany
    @JoinTable(
        name = "ConceptToAssessmentItem",
        joinColumns = @JoinColumn(name = "AssessmentItemId"),
        inverseJoinColumns = @JoinColumn(name = "ConceptId")
    )
    private Set<ConceptRecord> conceptRecords = new HashSet<>();

    @ManyToMany(mappedBy = "assessmentItems")
    private Set<Student> students = new HashSet<>();

    // Getters and setters
}
