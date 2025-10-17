/**
 * Repository interface for User entities in the Buyonix registry service.
 * Extends JpaRepository to provide CRUD operations and query methods for User objects.
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
package com.buyonix.resgistryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.buyonix.resgistryservice.model.User;
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

    

}
