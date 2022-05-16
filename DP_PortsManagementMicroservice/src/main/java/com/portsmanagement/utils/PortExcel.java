package com.portsmanagement.utils;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortExcel {

	@ExcelRow                    
    private int rowIndex;

	public PortExcel(long portId, String portName, int containers, String city, String country) {
		super();
		this.portId = portId;
		this.portName = portName;
		this.containers = containers;
		this.city = city;
		this.country = country;
	}


	@ExcelCellName("portId")
	private long portId;


	@ExcelCellName("portName")
	private String portName;


	@ExcelCellName("containers")
	private int containers;


	@ExcelCellName("city")
	private String city;


	@ExcelCellName("country")
	private String country;
	
	
	
}
