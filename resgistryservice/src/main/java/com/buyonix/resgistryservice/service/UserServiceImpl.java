/**
 * Implementation of the UserService interface for user-related operations
 * in the Buyonix registry service. This class provides concrete methods for
 * managing user entities, such as creation, retrieval, update, and deletion.
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

import java.util.ArrayList;
import java.util.List;

import com.buyonix.resgistryservice.model.User;

public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        // Implementation for creating a user
        users.add(user);
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        // Implementation for retrieving all users
        return null;
    }

}
