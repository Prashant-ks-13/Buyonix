/**
 * Represents a user in the Buyonix registry service.
 * This class can be extended to include user-specific attributes
 * such as username, email, and other profile information.
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
package com.buyonix.resgistryservice.model;

import lombok.*;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userid;
    private String username;
    private String email;
    private String password;
    private String role;
    private String gender;
    private String contactno;

}
