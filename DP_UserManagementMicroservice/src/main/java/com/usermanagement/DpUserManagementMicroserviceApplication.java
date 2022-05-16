package com.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DpUserManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpUserManagementMicroserviceApplication.class, args);
		System.out.println(" ========================================== ");
		System.out.println(" DP : UserManagementMicroserice");
		System.out.println("http://localhost:9051/dpuser");
		
		System.out.println("\n Swagger UI : http://localhost:9051/swagger-ui/index.html");
		System.out.println(" ========================================== ");
		
		System.out.println("\t ");
		
		
	}

}
