package com.demo.service;

import com.demo.model.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        if (userRepository.existsById(id)) {
            User existingUser = userRepository.getById(id);
            existingUser.setName(userDetails.getName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            return userRepository.save(existingUser);
        } else {
            return null; // Handle not found error
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        //return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");
    }
}
