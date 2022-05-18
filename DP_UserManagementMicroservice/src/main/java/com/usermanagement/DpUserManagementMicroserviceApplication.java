package com.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class DpUserManagementMicroserviceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(DpUserManagementMicroserviceApplication.class, args);
		
		
		ConfigurableApplicationContext ctx = 
		           SpringApplication.run(DpUserManagementMicroserviceApplication.class, args);
		String port = ctx.getEnvironment().getProperty("server.port");
		System.out.println("PORT =>>>> " + port);
		
		System.out.println(" ========================================== ");
		System.out.println(" DP : UserManagementMicroserice");
		System.out.println("http://localhost:"+port+"/dpuser");
		
		System.out.println("\nhttp://localhost:"+port+"/dpuser/swagger-ui/index.html");
		System.out.println(" ========================================== ");
		
		System.out.println("\t ");
		
		
	}

}
