package edu.upenn.cit594.datamanagement;

import java.io.File;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.logging.UserInfoLogger;

public class PropertiesReader {
	
	public PropertiesReader() {
		
	}
	
	public static LinkedList<Property> read(String fileName) {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfoLogger.logStringAtThisTime(fileName);
		
		List<String[]> propertiesList = null;
		try {
			propertiesList = reader.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LinkedList<Property> properties = new LinkedList<Property>();
		List<String> columnNames = Arrays.asList(propertiesList.get(0));
		int marketValueIndex = columnNames.indexOf("market_value");
		int totalLivableAreaIndex = columnNames.indexOf("total_livable_area");
		int zipcodeIndex = columnNames.indexOf("zip_code");
		for (String[] line : propertiesList) {
			// TODO: makes sure zipcode is 5 numbers
			Property property = new Property(Double.parseDouble(line[marketValueIndex]), Double.parseDouble(line[totalLivableAreaIndex]), line[zipcodeIndex]);
			properties.add(property);
		}
		return properties;
	}
	
	public static void main(String[] args) {
		PropertiesReader r = new PropertiesReader();
		r.read("properties.csv");
	}

}
