package nl.walker.novi.thinkbox.repository;

import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.Thought;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThoughtRepository  extends JpaRepository<Thought, Long> {
    List<Thought> findAllByProject(Project project);
}