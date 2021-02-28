package nl.walker.novi.thinkbox.repository;

import nl.walker.novi.thinkbox.domain.ERole;
import nl.walker.novi.thinkbox.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
