package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.Thought;
import java.util.List;

public interface ThoughtService {

    List<Thought> getAllThoughts();
    long saveThought(Thought thought);
    Thought getThoughtById(long id);
    void deleteThought(long id);
    void updateThought(long id, Thought thought);
}
