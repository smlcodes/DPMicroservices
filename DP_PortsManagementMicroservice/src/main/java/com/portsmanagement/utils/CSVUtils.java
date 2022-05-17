package com.portsmanagement.utils;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.portsmanagement.model.Port;


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
			mappingStrategy.setType(Port.class);

			mappingStrategy.setColumnMapping(columns);

			// Creating StatefulBeanToCsv object
			StatefulBeanToCsvBuilder<Port> builder = new StatefulBeanToCsvBuilder(writer);
			StatefulBeanToCsv beanWriter = builder.withMappingStrategy(mappingStrategy).build();

			// Write list to StatefulBeanToCsv object
			beanWriter.write(rows);

			// closing the writer object
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
    public void downloadCsv(PrintWriter writer, List<Port> users) {
        writer.write("PORT ID, PORT_NAME, CONTAINERS, CITY, COUNTRY \n");
        for (Port user : users) {
            writer.write(user.getPortId() + "," +user.getPortName() + "," +user.getContainers() + "," 
        +user.getCity() + "," +user.getCountry() + "\n");
        }
    }
}
