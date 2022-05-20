package com.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zuul.filters.ErrorFilter;
import com.zuul.filters.PostFilter;
import com.zuul.filters.PreFilter;
import com.zuul.filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class DpZuulApiGatewayApplication {

	@Bean
	public PreFilter preFilter() {
	  return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
	  return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
	  return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
	  return new RouteFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DpZuulApiGatewayApplication.class, args);
		System.out.println(" ========================================== ");
		System.out.println(" DP : DpZuulApiGatewayApplication");
		System.out.println("http://localhost:9072/");
	}
}
