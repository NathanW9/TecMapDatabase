package edu.ithaca.dragon.coursesupportserver;

import com.example.demo.entity.ConceptGraph;
import com.example.demo.repository.ConceptGraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConceptGraphService {

    @Autowired
    private ConceptGraphRepository conceptGraphRepository;

    public List<ConceptGraph> getAllConceptGraphs() {
        return conceptGraphRepository.findAll();
    }

    public Optional<ConceptGraph> getConceptGraphById(int id) {
        return conceptGraphRepository.findById(id);
    }

    public ConceptGraph addConceptGraph(ConceptGraph conceptGraph) {
        return conceptGraphRepository.save(conceptGraph);
    }

    public void deleteConceptGraph(int id) {
        conceptGraphRepository.deleteById(id);
    }

    public ConceptGraph updateConceptGraph(int id, ConceptGraph conceptGraph) {
        conceptGraph.setId(id);
        return conceptGraphRepository.save(conceptGraph);
    }
}
