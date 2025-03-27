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
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Cohort> cohorts = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "CourseToConceptGraph",
        joinColumns = @JoinColumn(name = "CourseId"),
        inverseJoinColumns = @JoinColumn(name = "ConceptGraphId")
    )
    private Set<ConceptGraph> conceptGraphs = new HashSet<>();

    // Getters and setters
}
