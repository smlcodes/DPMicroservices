package com.usermanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.usermanagement.model.Port;

@RestController
@RequestMapping("/dpports")
public class DPPortsMicroServiceRestTempleteController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/ports")
	@HystrixCommand(fallbackMethod = "getAllPortsFallBackMethod")
	public List<Port> getPorts() {
		System.out.println("RestTemplte Start : http://dpports-service/dpports/api/ports ");
		ResponseEntity<List<Port>> portResponse = restTemplate.exchange("http://dpports-service/dpports/api/ports",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Port>>() {
				});
		List<Port> ports = portResponse.getBody();
		System.out.println("RestTemplte End : http://dpports-service/dpports/api/ports "+ports);
		return ports;
	}

	@GetMapping("/port/{id}")
	@HystrixCommand(fallbackMethod = "getPortByIdFallBackMethod")
	public ResponseEntity<Port> getPortById(@PathVariable(name = "id") Long portId) {
		System.out.println("RestTemplte Start : http://dpports-service/dpports/api/port/"+portId);
		ResponseEntity<Port> portResp = restTemplate.getForEntity("http://dpports-service/dpports/api/port/{id}", Port.class,
				portId);

		Port port = portResp.getBody();
		System.out.println("RestTemplte End : http://dpports-service/dpports/api/port/"+portId+" ---> "+port);
		return portResp;
	}
	
	
	public List<Port> getAllPortsFallBackMethod() {
		System.out.println(" HYstrix ---> getAllPortsFallBackMethod");
		List<Port> ports = new ArrayList<Port>();
		ports.add(new Port(0, "getAllPortsFallBackMethod - Failed", 0, "empty", "empty"));
		return ports;
	}
	
	
	public ResponseEntity<Port> getPortByIdFallBackMethod(Long portId) {
		System.out.println(" HYstrix ---> getPortByIdFallBackMethod");
		return ResponseEntity.ok().body(new Port(0, "getPortByIdFallBackMethod - Failed", 0, "empty", "empty"));
	}

}
