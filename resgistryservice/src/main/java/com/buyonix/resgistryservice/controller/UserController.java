

package com.buyonix.resgistryservice.controller;

import java.util.List;

import com.buyonix.resgistryservice.dto.UserDTO;
import com.buyonix.resgistryservice.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buyonix.resgistryservice.model.User;
import com.buyonix.resgistryservice.service.UserServiceImpl;




/**
 * Controller class for handling user-related HTTP requests in the Buyonix Registry Service.
 * <p>
 * Annotated with @RestController
 * indicating that it is a RESTful web controller.
 * </p>
 * <p>
 * Define user management endpoints in this class.
 * </p>
 *
 * @author Prashant Kumar Singh
 * @version 1.0
 * @createdAt 2025-10-14
 * @updatedAt 2025-10-17
 * @project Buyonix Registry Service
 * @company Buyonix.com
 *
 * @Copyright (c) 2024 Buyonix.com. All rights reserved.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	// Define user management endpoints here
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/add")
    public UserResponse addUser(@Valid @RequestBody UserDTO user) {
        //TODO: process POST request

        
        return userServiceImpl.createUser(user);
    }

    @GetMapping("/allUser")
    public List<User> getAll() {
        return userServiceImpl.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        //TODO: process PUT request
        try {
            userServiceImpl.updateUser(user, id);
            return "User updated successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
        return "User deleted successfully";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllUsers() {
        userServiceImpl.deleteAllUsers();
        return "All users deleted successfully";
    }

    @GetMapping("/getUser/{id}")
    public Object getUser(@PathVariable Long id) {
        try {
            return userServiceImpl.getUserById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    



}
