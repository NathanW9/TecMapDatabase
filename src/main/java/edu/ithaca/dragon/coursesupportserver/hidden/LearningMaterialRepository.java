package edu.ithaca.dragon.coursesupportserver.hidden;

import com.example.demo.entity.LearningMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningMaterialRepository extends JpaRepository<LearningMaterial, Integer> {
}