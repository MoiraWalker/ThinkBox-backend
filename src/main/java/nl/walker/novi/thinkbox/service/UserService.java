package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(long id);
    void deleteUser(long id);
    long saveUser(User user);
    void updateUser(long id, User user);
}
