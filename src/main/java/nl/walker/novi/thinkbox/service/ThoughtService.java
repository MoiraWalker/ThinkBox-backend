package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.domain.Thought;
import java.util.List;

public interface ThoughtService {

    List<Thought> getAllThoughtsForProject(Long projectId);
    long saveThought(Thought thought, long projectId);
    Thought getThoughtById(long id);
    void deleteThought(long id);
    void updateThought(long id, Thought thought);
}
