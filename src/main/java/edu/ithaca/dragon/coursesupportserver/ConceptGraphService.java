package edu.ithaca.dragon.coursesupportserver;

import com.example.demo.entity.ConceptGraph;
import com.example.demo.repository.ConceptGraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConceptGraphService {

    private final ConceptGraphRepository conceptGraphRepository;

    @Autowired
    public ConceptGraphService(ConceptGraphRepository conceptGraphRepository) {
        this.conceptGraphRepository = conceptGraphRepository;
    }

    public List<ConceptGraph> findAll() {
        return conceptGraphRepository.findAll();
    }

    public Optional<ConceptGraph> findById(Long id) {
        return conceptGraphRepository.findById(id);
    }

    public ConceptGraph save(ConceptGraph conceptGraph) {
        return conceptGraphRepository.save(conceptGraph);
    }

    public ConceptGraph update(ConceptGraph conceptGraph) {
        return conceptGraphRepository.save(conceptGraph);
    }

    public void deleteById(Long id) {
        conceptGraphRepository.deleteById(id);
    }
}
