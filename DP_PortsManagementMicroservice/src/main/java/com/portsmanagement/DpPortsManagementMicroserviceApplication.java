package com.portsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DpPortsManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpPortsManagementMicroserviceApplication.class, args);
		System.out.println(" ========================================== ");
		System.out.println(" DP : Ports");
		System.out.println("http://localhost:9051/dpports");
		
		System.out.println("\n Swagger UI : http://localhost:9061/swagger-ui/index.html");
		System.out.println(" ========================================== ");
		
		System.out.println("\t ");
		
		
	}

}
