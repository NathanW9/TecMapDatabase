package edu.ithaca.dragon.coursesupportserver;

import com.example.demo.entity.Cohort;
import com.example.demo.repository.CohortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CohortService {

    @Autowired
    private CohortRepository cohortRepository;

    public List<Cohort> getAllCohorts() {
        return cohortRepository.findAll();
    }

    public Optional<Cohort> getCohortById(int id) {
        return cohortRepository.findById(id);
    }

    public Cohort addCohort(Cohort cohort) {
        return cohortRepository.save(cohort);
    }

    public void deleteCohort(int id) {
        cohortRepository.deleteById(id);
    }

    public Cohort updateCohort(int id, Cohort cohort) {
        cohort.setId(id);
        return cohortRepository.save(cohort);
    }
}