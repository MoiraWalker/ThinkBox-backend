package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.domain.Thought;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.ThoughtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThoughtServiceImpl implements ThoughtService {

    @Autowired
    private ThoughtRepository thoughtRepository;

    @Override
    public List<Thought> getAllThoughts() {
        return thoughtRepository.findAll();
    }

    @Override
    public Thought getThoughtById(long id) {
        if (thoughtRepository.existsById(id)) {
            return thoughtRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteThought(long id) {
        if (thoughtRepository.existsById(id)) {
            thoughtRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveThought(Thought thought) {
        Thought newThought = thoughtRepository.save(thought);
        return newThought.getId();
    }

    @Override
    public void updateThought(long id, Thought thought) {
        if (thoughtRepository.existsById(id)) {
            try {
                Thought existingThought = thoughtRepository.findById(id).orElse(null);
                existingThought.setTitle(thought.getTitle());
                existingThought.setType(thought.getType());
                existingThought.getDescription();
                thoughtRepository.save(existingThought);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }

}
