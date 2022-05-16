package com.usermanagement.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	@Id
	private long userId;
	
    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
	private String name;
	
    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String emailId;
    
    private int age;
	
    private double salary;
	
	private String depeartment;

	
	private String country;
	
	
	
}
