

package com.buyonix.resgistryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buyonix.resgistryservice.model.User;
import com.buyonix.resgistryservice.service.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




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
    public String addUser(@RequestBody User user) {
        //TODO: process POST request
        userServiceImpl.createUser(user);
        
        return "User added successfully";
    }

    @GetMapping("/allUser")
    public List<User> getAll() {
        return userServiceImpl.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        //TODO: process PUT request
        userServiceImpl.updateUser(id);
        return "User updated successfully";
        
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
    public Optional<User> getUser(@RequestParam Long id) {
        return userServiceImpl.getUserById(id);
    }
    
    
    



}
