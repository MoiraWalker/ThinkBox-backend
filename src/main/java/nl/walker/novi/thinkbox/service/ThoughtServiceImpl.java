package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.Thought;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.ProjectRepository;
import nl.walker.novi.thinkbox.repository.ThoughtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThoughtServiceImpl implements ThoughtService {

    @Autowired
    private ThoughtRepository thoughtRepository;

    @Autowired
    private ProjectRepository projectRepository;

//    @Override
//    public List<Thought> getAllThoughts() {
//        return thoughtRepository.findAll();
//    }

//    @Override
//    public long saveThought(Thought thought) {
//        Thought newThought = thoughtRepository.save(thought);
//        return newThought.getId();
//    }
//

    @Override
    public List<Thought> getAllThoughtsForProject(Long projectId) {
        Project project = projectRepository.getOne(projectId);
        List<Thought> thoughts = thoughtRepository.findAllByProject(project);
        return thoughts;
    }

    @Override
    public long saveThought(Thought thought, long projectId) {
        try {
            Project project = projectRepository.getOne(thought.getCurrentProjectId());
            thought.setProject(project);
            Thought newThought = thoughtRepository.save(thought);
            return newThought.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
    public void updateThought(long id, Thought thought) {
        if (thoughtRepository.existsById(id)) {
            try {
                Thought existingThought = thoughtRepository.findById(id).orElse(null);
                existingThought.setTitle(thought.getTitle());
                existingThought.setType(thought.getType());
                existingThought.setDescription(thought.getDescription());
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
