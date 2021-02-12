package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Thought;
import java.util.List;

public interface ThoughtService {

    List<Thought> getAllThoughts();
    Thought getThoughtById(long id);
    void deleteThought(long id);
    long saveThought(Thought thought);
    void updateThought(long id, Thought thought);
}
