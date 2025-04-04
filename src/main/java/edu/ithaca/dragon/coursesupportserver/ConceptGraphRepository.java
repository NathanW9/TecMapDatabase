package edu.ithaca.dragon.coursesupportserver;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptGraphRepository extends JpaRepository<ConceptGraph, Integer> {
    List<ConceptRecord> findByConceptGraphId(int conceptGraphId);
}