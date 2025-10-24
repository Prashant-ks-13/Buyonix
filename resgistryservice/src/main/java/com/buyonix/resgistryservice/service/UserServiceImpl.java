/**
 * Implementation of the UserService interface for user-related operations
 * in the Buyonix registry service. This class provides concrete methods for
 * managing user entities, such as creation, retrieval, update, and deletion.
 *
 * @author Prashant Kumar Singh
 * @version 1.0
 * @createdAt 2025-10-14
 * @updatedAt 2025-10-25
 * @project Buyonix Registry Service
 * @company Buyonix.com
 * <p>
 * Copyright (c) 2024 Buyonix.com. All rights reserved.
 */
package com.buyonix.resgistryservice.service;

import com.buyonix.resgistryservice.dto.UserDTO;
import com.buyonix.resgistryservice.exceptions.DuplicateUserException;
import com.buyonix.resgistryservice.exceptions.UserNotFoundException;
import com.buyonix.resgistryservice.mapper.UserMapper;
import com.buyonix.resgistryservice.model.User;
import com.buyonix.resgistryservice.repository.UserRepository;
import com.buyonix.resgistryservice.response.APIResponse;
import com.buyonix.resgistryservice.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserMapper userMapper;

    private final UserRepository userRepository;

    /**
     * Adds a new user to the system.
     * <p>
     * Converts {@link UserDTO} to {@link User} entity, saves it in the repository,
     * and returns a {@link UserResponse} with a welcome message.
     * </p>
     *
     * @param userDTO the data transfer object containing user details
     * @return {@link UserResponse} containing the user details and success message
     * @throws DuplicateUserException if a user with the same email or username already exists
     */
    @Override
    public UserResponse addUser(UserDTO userDTO) {
        // Implementation for creating a user
        try {
            User user = userMapper.toEntity(userDTO);
            userRepository.save(user);
            UserResponse userResponse = userMapper.toResponse(user);
            userResponse.setMessage("Welcome " + userDTO.getUsername() + " ,You have been registered successfully");
            return userResponse;
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateUserException("Email or UserName already exists. Please try with different one.");
        }
    }

    /**
     * Retrieves all users in the system.
     *
     * @return a list of {@link UserDTO} representing all users
     */
    @Override
    public List<UserDTO> getAllUsers() {
        // Implementation for retrieving all users
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserDTO).collect(Collectors.toList());
    }

    /**
     * Deletes a user by their unique ID.
     *
     * @param userId the ID of the user to delete
     * @return {@link APIResponse} indicating success of deletion
     * @throws UserNotFoundException if the user with the given ID does not exist
     */
    @Override
    public APIResponse<Void> deleteUser(Long userId) {
        // TODO Auto-generated method stub
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        userRepository.delete(user);
        return new APIResponse<>(true, HttpStatus.OK.value(), "User Deleted Successfully!", null);

    }

    /**
     * Retrieves a user by their unique ID.
     *
     * @param userId the ID of the user to retrieve
     * @return {@link UserDTO} containing the user's details
     * @throws UserNotFoundException if the user with the given ID does not exist
     */
    @Override
    public UserDTO getUserById(Long userId) {
        // TODO Auto-generated method stub
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
        UserDTO userDTO = userMapper.toUserDTO(user);
        return userDTO;
    }

    /**
     * Updates an existing user's details.
     * <p>
     * Only updates mutable fields (role, gender, contact number) and leaves
     * username, email, and password unchanged.
     * </p>
     *
     * @param userDTO the {@link UserDTO} containing updated details
     * @param id      the ID of the user to update
     * @return {@link UserResponse} containing updated user details and message
     * @throws UserNotFoundException if the user with the given ID does not exist
     */
    @Override
    public UserResponse updateUser(UserDTO userDTO, Long id) {
        // TODO Auto-generated method stub
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        if (userDTO.getRole() != null) user.setRole(userDTO.getRole());
        if (userDTO.getContactno() != null) user.setContactno(userDTO.getContactno());
        if (userDTO.getGender() != null) user.setGender(userDTO.getGender());

        userRepository.save(user);
        UserResponse userResponse = userMapper.toResponse(user);
        userResponse.setMessage("User's Details with username " + user.getUsername() + " has been updated.");

        return userResponse;


    }

    /**
     * Deletes all users in the system.
     *
     * @return {@link APIResponse} indicating success of the deletion
     */
    @Override
    public APIResponse<Void> deleteAllUsers() {
        // TODO Auto-generated method stub
        userRepository.deleteAll();
        return new APIResponse(true, HttpStatus.NO_CONTENT.value(), "All users deleted successfully", null);
    }

}
