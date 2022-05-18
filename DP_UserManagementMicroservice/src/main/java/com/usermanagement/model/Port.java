package com.usermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Port {

	private long portId;
	private String portName;

	private int containers;

	private String city;

	private String country;

}
