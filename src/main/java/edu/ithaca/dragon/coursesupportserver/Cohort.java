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
import javax.persistence.Table;

@Entity
public class Cohort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "cohorts")
    private Set<Student> students = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "CourseToCohort",
        joinColumns = @JoinColumn(name = "CohortId"),
        inverseJoinColumns = @JoinColumn(name = "CourseId")
    )
    private Set<Course> courses = new HashSet<>();

    // Getters and setters
}
