/**
 * Represents a user in the Buyonix registry service.
 * This class can be extended to include user-specific attributes
 * such as username, email, and other profile information.
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
package com.buyonix.resgistryservice.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_user", schema = "registration")
public class User {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "userid")
    @SequenceGenerator(name = "userid",sequenceName = "user_seq",allocationSize = 1)
    private Long userid;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
    private String gender;
    private String contactno;
    @CreationTimestamp
    private String createdAt;
    @UpdateTimestamp
    private String updatedAt;

}
