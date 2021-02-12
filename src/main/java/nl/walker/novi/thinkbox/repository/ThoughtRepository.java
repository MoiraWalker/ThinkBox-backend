package nl.walker.novi.thinkbox.repository;

import nl.walker.novi.thinkbox.domain.Thought;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThoughtRepository  extends JpaRepository<Thought, Long> {

}
