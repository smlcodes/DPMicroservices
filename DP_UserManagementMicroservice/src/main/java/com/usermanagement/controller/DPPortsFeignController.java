package com.usermanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.usermanagement.model.Port;
import com.usermanagement.service.PortsFeignClientService;

@RestController
@RequestMapping("feign/")
public class DPPortsFeignController {
	
	@Autowired
	PortsFeignClientService feignClientService;
	
	
	@GetMapping("/ports")
	@HystrixCommand(fallbackMethod = "getAllPortsFallBackMethod")
	public List<Port> getPorts(){
		System.out.println(" \n \n ------------------> getPorts");
		List<Port> ports = feignClientService.getPorts();
		System.out.println(" \n \n ------------------> ports");
		return ports;
	}
	
	public List<Port> getAllPortsFallBackMethod() {
		System.out.println(" HYstrix ---> getAllPortsFallBackMethod");
		List<Port> ports = new ArrayList<Port>();
		ports.add(new Port(0, "getAllPortsFallBackMethod - Failed", 0, "empty", "empty"));
		return ports;
	}
	
	
	@PostMapping("/port")
	public Port createPort(Port port) {
		return feignClientService.createPort(port);
	} 
	

	@GetMapping("/port/{id}")	 
	public Port getPortById(@PathVariable(name = "id") Long portId) {
		return feignClientService.getPortById(portId);
	}
	
	@GetMapping("/exportPorts")
    public void exportPorts(HttpServletResponse response) throws IOException{
		 response.setContentType("text/csv");
	     response.setHeader("Content-Disposition", "attachment; file=Ports+"+new Date().toGMTString()+".csv");
	     feignClientService.exportPorts(response);
	}

}
