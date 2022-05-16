package com.usermanagement.controller;

import java.util.List;

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
import com.usermanagement.exception.ResourceNotFoundException;
import com.usermanagement.model.User;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.utils.ExcelUtils;
import com.usermanagement.utils.ResponseMessage;

@RestController
@RequestMapping("api/")
public class UserManagementController {

	@Autowired
	UserRepository userRepository;
 

	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	  String message = "";
	  
	      try {
	        ExcelUtils excelUtils = new ExcelUtils();
	        excelUtils.userDataExcelProcessing(file.getInputStream());
	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } 
	      catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	   
	  }

}