package edu.ithaca.dragon.coursesupportserver;

import com.example.demo.entity.AssessmentItem;
import com.example.demo.repository.AssessmentItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentItemService {

    @Autowired
    private AssessmentItemRepository assessmentItemRepository;

    public List<AssessmentItem> getAllAssessmentItems() {
        return assessmentItemRepository.findAll();
    }

    public Optional<AssessmentItem> getAssessmentItemById(int id) {
        return assessmentItemRepository.findById(id);
    }

    public AssessmentItem addAssessmentItem(AssessmentItem assessmentItem) {
        return assessmentItemRepository.save(assessmentItem);
    }

    public void deleteAssessmentItem(int id) {
        assessmentItemRepository.deleteById(id);
    }

    public AssessmentItem updateAssessmentItem(int id, AssessmentItem assessmentItem) {
        assessmentItem.setId(id);
        return assessmentItemRepository.save(assessmentItem);
    }
}
