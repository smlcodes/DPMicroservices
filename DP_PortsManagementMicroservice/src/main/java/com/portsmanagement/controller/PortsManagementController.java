package com.portsmanagement.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.portsmanagement.exception.ResourceNotFoundException;
import com.portsmanagement.model.Port;
import com.portsmanagement.repository.PortRepository;
import com.portsmanagement.utils.CSVUtils;
import com.portsmanagement.utils.ExcelUtils;
import com.portsmanagement.utils.ResponseMessage;

@RestController
@RequestMapping("api/")
public class PortsManagementController {

	@Autowired
	PortRepository portRepository;

	@GetMapping("/ports")
	public List<Port> getPorts() {
		List<Port> ports = portRepository.findAll();
		return ports;
	}

	@PostMapping("/port")
	public Port createPort(@Valid @RequestBody Port port) {
		return portRepository.save(port);
	}

	@GetMapping("/port/{id}")
	public ResponseEntity<Port> getPortById(@PathVariable(name = "id") Long portId) throws ResourceNotFoundException {
		Port port = portRepository.findById(portId)
				.orElseThrow(() -> new ResourceNotFoundException("Port not found with id : " + portId));
		return ResponseEntity.ok().body(port);
	}

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		try {
			ExcelUtils excelUtils = new ExcelUtils();
			List<Port> ports = excelUtils.portsDataExcelProcessing(file.getInputStream());
			List<Port> savedPorts = portRepository.saveAll(ports);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			message = message + " Records Created : " + savedPorts.size();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}

	}
	
    @GetMapping("/exportPorts")
    public void exportPorts(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=Ports+"+new Date().toGMTString()+".csv");
        CSVUtils csvUtils = new CSVUtils();
        
        csvUtils.downloadCsv(response.getWriter(), portRepository.findAll()) ;
    }

}
