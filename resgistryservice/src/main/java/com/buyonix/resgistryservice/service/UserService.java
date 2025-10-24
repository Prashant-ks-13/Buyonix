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
 * <p>
 * Copyright (c) 2024 Buyonix.com. All rights reserved.
 */
package com.buyonix.resgistryservice.service;

import com.buyonix.resgistryservice.dto.UserDTO;
import com.buyonix.resgistryservice.model.User;
import com.buyonix.resgistryservice.response.APIResponse;
import com.buyonix.resgistryservice.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse addUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    APIResponse<Void> deleteUser(Long userId);

    UserDTO getUserById(Long userId);

    APIResponse<Void> deleteAllUsers();

    UserResponse updateUser(UserDTO userDTO, Long id);

}
