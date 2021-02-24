package nl.walker.novi.thinkbox.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public User getUserByUserName(String username) {
        if (userRepository.existsByUsername(username)) {
            return userRepository.findByUsername(username).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteUser(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }

    @Override
    public void updateUser(long id, User user) {
        if (userRepository.existsById(id)) {
            try {
                User existingUser = userRepository.findById(id).orElse(null);
                existingUser.setUsername(user.getUsername());
                existingUser.setEmail(user.getEmail());
                existingUser.setPassword(user.getPassword());
                userRepository.save(existingUser);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateUserByUserName(String username, User user) {
        if (userRepository.existsByUsername(username)) {
            try {
                User existingUser = userRepository.findByUsername(username).orElse(null);
                existingUser.setUsername(user.getUsername());
                existingUser.setEmail(user.getEmail());
                existingUser.setPassword(user.getPassword());
                userRepository.save(existingUser);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }


}
