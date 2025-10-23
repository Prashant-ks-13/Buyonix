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

import com.buyonix.resgistryservice.dto.UserDTO;
import com.buyonix.resgistryservice.exceptions.CustomerNotFoundException;
import com.buyonix.resgistryservice.mapper.UserMapper;
import com.buyonix.resgistryservice.model.User;
import com.buyonix.resgistryservice.repository.UserRepository;
import com.buyonix.resgistryservice.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserMapper modelMapper;

    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserDTO userDTO) {
        // Implementation for creating a user
        User user = modelMapper.toEntity(userDTO);
        userRepository.save(user);
        UserResponse userResponse = modelMapper.toResponse(user);
        userResponse.setMessage("Welcome " + userDTO.getUsername()+" ,You have been registered successfully");
        return userResponse;
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
        Optional<User> existingUser = userRepository.findById(userId);
        if(!existingUser.isPresent()){
            throw new  CustomerNotFoundException("User not found with id: " + userId);
        }
        return userRepository.findById(userId);
    }

    @Override
    public User updateUser(User user , Long id) {
        // TODO Auto-generated method stub
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new CustomerNotFoundException("User not found with id: " + id);
        }else {

            // Update fields of existingUser as needed
            // For example: existingUser.setName(user.getName());

            userRepository.save(user);
            return user;
        }
        
    }

    @Override
    public void deleteAllUsers() {
        // TODO Auto-generated method stub
        userRepository.deleteAll();
    }

}
