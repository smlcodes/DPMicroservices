package com.usermanagement.controller;

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

import com.usermanagement.model.Port;

@RestController
@RequestMapping("/dpports")
public class DPPortsMicroServiceRestTempleteController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/ports")
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
	public ResponseEntity<Port> getPortById(@PathVariable(name = "id") Long portId) {
		System.out.println("RestTemplte Start : http://dpports-service/dpports/api/port/"+portId);
		ResponseEntity<Port> portResp = restTemplate.getForEntity("http://dpports-service/dpports/api/port/{id}", Port.class,
				portId);

		Port port = portResp.getBody();
		System.out.println("RestTemplte End : http://dpports-service/dpports/api/port/"+portId+" ---> "+port);
		return portResp;
	}

}
