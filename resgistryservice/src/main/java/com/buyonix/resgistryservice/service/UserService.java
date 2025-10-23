/**
 * Service interface for user-related operations in the Buyonix registry service.
 * This interface can be extended to include methods for user management such as
 * creation, retrieval, update, and deletion of user entities.
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

import java.util.List;
import java.util.Optional;

import com.buyonix.resgistryservice.dto.UserDTO;
import com.buyonix.resgistryservice.model.User;
import com.buyonix.resgistryservice.response.UserResponse;

public interface UserService {

    UserResponse createUser(UserDTO userDTO);
    List<User> getAllUsers();
    void deleteUser(Long userId);
    Optional<User> getUserById(Long userId);
    
    void deleteAllUsers();
    User updateUser(User user,Long id);

}
