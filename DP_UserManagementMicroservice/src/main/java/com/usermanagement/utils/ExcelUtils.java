package com.usermanagement.utils;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;
import com.usermanagement.model.User;

public class ExcelUtils {

	public List<User> userDataExcelProcessing(InputStream inputStream) {

	 
		List<UserExcel> rows = Poiji.fromExcel(inputStream, PoijiExcelType.XLSX, UserExcel.class );		

		List<User> users = rows.stream().map(e -> new User(e.getUserId(), e.getName(), e.getEmailId(), e.getAge(),
				e.getSalary(), e.getDepeartment(), e.getCountry())).collect(Collectors.toList());
		System.out.println("Users List :  " + users);

		return users;
	}

	public static void main(String[] args) {
		//new ExcelUtils().userDataExcelProcessing("src/main/java/com/usermanagement/utils/users.xlsx");
	}

}
