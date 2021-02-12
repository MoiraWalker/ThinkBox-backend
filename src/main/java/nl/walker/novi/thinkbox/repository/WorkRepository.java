package nl.walker.novi.thinkbox.repository;

import nl.walker.novi.thinkbox.domain.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository  extends JpaRepository<Work, Long> {

}
