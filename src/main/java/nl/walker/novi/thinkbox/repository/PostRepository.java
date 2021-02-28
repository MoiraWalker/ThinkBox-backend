package nl.walker.novi.thinkbox.repository;

import nl.walker.novi.thinkbox.domain.Post;
import nl.walker.novi.thinkbox.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByProject(Project project);

}
