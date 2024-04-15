package com.utd.cs.cprm.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utd.cs.cprm.model.User;
import com.utd.cs.cprm.repository.UserRepository;

@Service
public class MedicalPersonnelService {

    @Autowired
    private UserRepository userRepository;

    public User findById(String login) {
        Optional<User> user = userRepository.findById(login);
        return user.orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String login) {
        userRepository.deleteById(login);
    }

    public boolean existsById(String login) {
        return userRepository.existsById(login);
    }
    
    public String generateId() {
        // Generate an ID logic here
        return UUID.randomUUID().toString(); // Example using UUID
    }

    public User saveMedicalPersonnel(User medicalPersonnel) {
        return userRepository.save(medicalPersonnel);
    }


}
