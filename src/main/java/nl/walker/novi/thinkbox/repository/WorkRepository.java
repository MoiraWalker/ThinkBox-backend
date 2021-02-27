package nl.walker.novi.thinkbox.repository;
import nl.walker.novi.thinkbox.domain.Project;
import nl.walker.novi.thinkbox.domain.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository  extends JpaRepository<Work, Long> {
    List<Work> findAllByProject(Project project);
}