package edu.ithaca.dragon.coursesupportserver.hidden;

import com.example.demo.entity.LearningMaterial;
import com.example.demo.repository.LearningMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningMaterialService {

    @Autowired
    private LearningMaterialRepository learningMaterialRepository;

    public List<LearningMaterial> getAllLearningMaterials() {
        return learningMaterialRepository.findAll();
    }

    public Optional<LearningMaterial> getLearningMaterialById(int id) {
        return learningMaterialRepository.findById(id);
    }

    public LearningMaterial addLearningMaterial(LearningMaterial learningMaterial) {
        return learningMaterialRepository.save(learningMaterial);
    }

    public void deleteLearningMaterial(int id) {
        learningMaterialRepository.deleteById(id);
    }

    public LearningMaterial updateLearningMaterial(int id, LearningMaterial learningMaterial) {
        learningMaterial.setId(id);
        return learningMaterialRepository.save(learningMaterial);
    }
}
