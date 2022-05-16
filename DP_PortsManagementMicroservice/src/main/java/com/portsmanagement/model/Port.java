package com.portsmanagement.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Port")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Port {

	@Id
	private long portId;

	@NotBlank
	@Size(max = 100)
	@Indexed(unique = true)
	private String portName;

	private int containers;

	private String city;

	private String country;

}
