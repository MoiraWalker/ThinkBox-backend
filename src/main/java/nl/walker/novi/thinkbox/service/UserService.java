package nl.walker.novi.thinkbox.service;
import nl.walker.novi.thinkbox.domain.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(long id);
    void deleteUser(long id);
    void updateEmail(long id, User user);
    void updateUser(long id, User user);
    long saveUser(User user);
}
