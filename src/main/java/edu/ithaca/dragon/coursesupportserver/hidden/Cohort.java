package edu.ithaca.dragon.coursesupportserver.hidden;

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

import edu.ithaca.dragon.coursesupportserver.Student;
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

    public void setId(int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    // Getters and setters
}
