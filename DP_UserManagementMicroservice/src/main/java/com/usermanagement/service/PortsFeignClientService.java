package com.usermanagement.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.usermanagement.model.Port;

@FeignClient(name="DPPORTS-SERVICE")
public interface PortsFeignClientService {

	@GetMapping("/dpports/ports")
	public List<Port> getPorts();
	
	@PostMapping("/dpports/port")
	public Port createPort(Port port); 
	

	@GetMapping("/dpports/port/{id}")	 
	public Port getPortById(@PathVariable(name = "id") Long portId) ;
	
	@GetMapping("/dpports/exportPorts")
    public void exportPorts(HttpServletResponse response) throws IOException;
}

