package nl.walker.novi.thinkbox.service;

import nl.walker.novi.thinkbox.domain.User;
import nl.walker.novi.thinkbox.exception.DatabaseErrorException;
import nl.walker.novi.thinkbox.exception.RecordNotFoundException;
import nl.walker.novi.thinkbox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void deleteUser(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updateEmail(long id, User user) {
        if (userRepository.existsById(id)) {
            try {
                User existingUser = userRepository.findById(id).orElse(null);
                existingUser.setEmail(user.getEmail());
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
    public void updateUser(long id, User user) {
        if (userRepository.existsById(id)) {
            try {
                User existingUser = userRepository.findById(id).orElse(null);
                existingUser.setEmail(user.getEmail());
                existingUser.setUsername(user.getUsername());
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
    public long saveUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }

}
