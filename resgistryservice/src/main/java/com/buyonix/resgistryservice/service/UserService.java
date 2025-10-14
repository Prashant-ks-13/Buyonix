/**
 * Service interface for user-related operations in the Buyonix registry service.
 * This interface can be extended to include methods for user management such as
 * creation, retrieval, update, and deletion of user entities.
 *
 * @author Prashant Kumar Singh
 * @version 1.0
 * @createdAt 2024-06-08
 * @updatedAt 2024-06-08
 * @project Buyonix Registry Service
 * @company Buyonix.com
 * 
 * Copyright (c) 2024 Buyonix.com. All rights reserved.
 */
package com.buyonix.resgistryservice.service;

import java.util.List;

import com.buyonix.resgistryservice.model.User;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();

}
