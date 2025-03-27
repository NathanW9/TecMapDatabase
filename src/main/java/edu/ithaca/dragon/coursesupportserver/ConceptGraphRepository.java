package edu.ithaca.dragon.coursesupportserver;

import com.example.demo.entity.ConceptGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptGraphRepository extends JpaRepository<ConceptGraph, Integer> {
}