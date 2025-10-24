

package com.buyonix.resgistryservice.controller;

import java.util.List;

import com.buyonix.resgistryservice.dto.UserDTO;
import com.buyonix.resgistryservice.response.APIResponse;
import com.buyonix.resgistryservice.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @Copyright (c) 2024 Buyonix.com. All rights reserved.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    // Define user management endpoints here
    @Autowired
    UserServiceImpl userServiceImpl;


    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@Valid @RequestBody UserDTO user) {
        //TODO: process POST request

        UserResponse userResponse = userServiceImpl.addUser(user);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }


    @GetMapping("/allUser")
    public ResponseEntity<List<UserDTO>> getAll() {

        return ResponseEntity.ok(userServiceImpl.getAllUsers());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        //TODO: process PUT request

        UserResponse userResponse = userServiceImpl.updateUser(userDTO, id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);


    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse<Void>> deleteUser(@PathVariable Long id) {
        APIResponse<Void> apiResponse = userServiceImpl.deleteUser(id);
        return ResponseEntity.status(apiResponse.getStatusCode()).body(apiResponse);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<APIResponse> deleteAllUsers() {

        return ResponseEntity.ok(userServiceImpl.deleteAllUsers());
    }


    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = userServiceImpl.getUserById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }


}
