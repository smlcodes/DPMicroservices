package com.usermanagement.utils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class UserExcel {

	@ExcelRow                    
    private int rowIndex;

	@ExcelCellName("userId")
	private long userId;	


	@ExcelCellName("name")
	private String name;


	@ExcelCellName("emailId")
    private String emailId;


	@ExcelCellName("age")
    private int age;


	@ExcelCellName("salary")
    private double salary;


	@ExcelCellName("depeartment")
	private String depeartment;

	
	@ExcelCellName("country")	
	private String country;
	
	
	
}
