package com.portsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class DpPortsManagementMicroserviceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

	 
	
	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext ctx = 
		           SpringApplication.run(DpPortsManagementMicroserviceApplication.class, args);
		String port = ctx.getEnvironment().getProperty("server.port");
		System.out.println("=>>>> " + port);
		
		
		SpringApplication.run(DpPortsManagementMicroserviceApplication.class, args);
		System.out.println(" ========================================== ");
		System.out.println(" DP : Ports");
		System.out.println("http://localhost:"+port+"/dpports");
		
		System.out.println("\n http://localhost:"+port+"/dpports/swagger-ui/index.html");
		System.out.println(" ========================================== ");
		
		System.out.println("\t ");
		
		
	}

}
