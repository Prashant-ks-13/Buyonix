

package com.buyonix.resgistryservice.controller;

import org.springframework.web.bind.annotation.RestController;

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
 * @createdAt 2024-06-08
 * @updatedAt 2024-06-08
 * @project Buyonix Registry Service
 * @company Buyonix.com
 *
 * @Copyright (c) 2024 Buyonix.com. All rights reserved.
 */
@RestController
public class UserController {

	// Define user management endpoints here

    public String hello() {
        return "Hello, Buyonix Registry Service!";
    }

}
