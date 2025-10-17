/**
 * Implementation of the UserService interface for user-related operations
 * in the Buyonix registry service. This class provides concrete methods for
 * managing user entities, such as creation, retrieval, update, and deletion.
 *
 * @author Prashant Kumar Singh
 * @version 1.0
 * @createdAt 2025-10-14
 * @updatedAt 2025-10-17
 * @project Buyonix Registry Service
 * @company Buyonix.com
 * 
 * Copyright (c) 2024 Buyonix.com. All rights reserved.
 */
package com.buyonix.resgistryservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buyonix.resgistryservice.model.User;
import com.buyonix.resgistryservice.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

    


    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        // Implementation for creating a user
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        // Implementation for retrieving all users
        List<User> users = new ArrayList<>();
        users = userRepository.findAll();
        return users;
    }

    @Override
    public void deleteUser(Long userId) {
        // TODO Auto-generated method stub
        userRepository.deleteById(userId);
        
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        // TODO Auto-generated method stub
        return userRepository.findById(userId);
    }

    @Override
    public User updateUser(Long id) {
        // TODO Auto-generated method stub
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new RuntimeException("User not found with id: " + id);
        }else {
            User existingUser = optionalUser.get();
            // Update fields of existingUser as needed
            // For example: existingUser.setName(user.getName());
            userRepository.save(existingUser);
            return existingUser;
        }
        
    }

    @Override
    public void deleteAllUsers() {
        // TODO Auto-generated method stub
        userRepository.deleteAll();
    }

}
