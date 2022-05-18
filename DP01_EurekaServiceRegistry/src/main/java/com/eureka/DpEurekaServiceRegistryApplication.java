package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DpEurekaServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpEurekaServiceRegistryApplication.class, args);
		System.out.println(" ========================================== ");
		System.out.println(" DP : EurekaServer");
		System.out.println("http://localhost:9071/dpports");
		
	}

}
