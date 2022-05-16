package com.usermanagement.utils;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.usermanagement.model.User;

public class CSVUtils {

	public void exportToCSV(List rows, String[] columns) {

		// name of generated csv
		final String CSV_LOCATION = "exportfile.csv ";

		try {

			// Creating writer class to generate
			// csv file
			FileWriter writer = new FileWriter(CSV_LOCATION);

			// Create Mapping Strategy to arrange the
			// column name in order
			ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
			mappingStrategy.setType(User.class);

			mappingStrategy.setColumnMapping(columns);

			// Creating StatefulBeanToCsv object
			StatefulBeanToCsvBuilder<User> builder = new StatefulBeanToCsvBuilder(writer);
			StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build();

			// Write list to StatefulBeanToCsv object
			beanWriter.write(rows);

			// closing the writer object
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
    public void downloadCsv(PrintWriter writer, List<User> users) {
        writer.write("USER_ID, NAME, AGE, EMAIL_ID, SALARY, DEPERATMENT, COUNTRY \n");
        for (User user : users) {
            writer.write(user.getUserId() + "," +user.getName() + "," +user.getAge() + "," 
        +user.getEmailId() + "," +user.getSalary() + "," +user.getDepeartment() + "," +user.getCountry() + "\n");
        }
    }
}
