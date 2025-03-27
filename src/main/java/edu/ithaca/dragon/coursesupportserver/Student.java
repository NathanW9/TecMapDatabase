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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private String firstname;

    @Column(length = 50, nullable = false)
    private String lastname;

    @ManyToMany
    @JoinTable(
        name = "StudentToCohort",
        joinColumns = @JoinColumn(name = "Sid"),
        inverseJoinColumns = @JoinColumn(name = "Cid")
    )
    private Set<Cohort> cohorts = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "StudentToAssessmentItem",
        joinColumns = @JoinColumn(name = "Sid"),
        inverseJoinColumns = @JoinColumn(name = "AssessmentItemId")
    )
    private Set<AssessmentItem> assessmentItems = new HashSet<>();

    // Getters and setters
}
