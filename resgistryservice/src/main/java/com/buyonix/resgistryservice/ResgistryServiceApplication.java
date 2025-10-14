package com.buyonix.resgistryservice;

/**
 * The entry point for the Buyonix Registry Service Spring Boot application.
 * <p>
 * This class bootstraps and launches the Registry Service, which is responsible
 * for managing service registration and discovery within the Buyonix ecosystem.
 * </p>
 *
 * <p>
 * Extend this class to add custom startup logic or additional configuration if required.
 * </p>
 *
 * @author Prashant Kumar Singh
 * @version 1.0
 * @since 2024-06-08
 * @createdAt 2024-06-08
 * @updatedAt 2024-06-08
 * @project Buyonix Registry Service
 * @company Buyonix.com
 *
 * Copyright (c) 2024 Buyonix.com. All rights reserved.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResgistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResgistryServiceApplication.class, args);
	}

}
