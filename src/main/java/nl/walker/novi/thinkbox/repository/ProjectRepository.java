package nl.walker.novi.thinkbox.repository;

import nl.walker.novi.thinkbox.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByUserId(Long userId);
}
