package com.portsmanagement.utils;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.portsmanagement.model.Port;

public class ExcelUtils {

	public List<Port> portsDataExcelProcessing(InputStream inputStream) {
	 
		List<PortExcel> rows = Poiji.fromExcel(inputStream, PoijiExcelType.XLSX, PortExcel.class );		

		List<Port> ports = rows.stream().map(e -> new Port(e.getPortId(), e.getPortName(), e.getContainers(), e.getCity(), e.getCountry())).collect(Collectors.toList());
		System.out.println("Users List :  " + ports);

		return ports;
	}
	
	
	public File exportToExcel(List<Port> ports) {
		
	 

		return null;
	}
	
	
	

	public static void main(String[] args) {
		//new ExcelUtils().userDataExcelProcessing("src/main/java/com/usermanagement/utils/users.xlsx");
	}

}
