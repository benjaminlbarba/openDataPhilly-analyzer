package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import edu.upenn.cit594.data.Property;

public class PropertiesReader {
	
	public PropertiesReader() {
		
	}
	
	public static LinkedList<Property> read(String fileName) {
		File propertyFile = new File(fileName);
		LinkedList<Property> properties = new LinkedList<Property>();
		Scanner propertyScanner = null;
		try {
			propertyScanner = new Scanner(propertyFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(propertyScanner.nextLine());
		ArrayList<String> columnNames = (ArrayList<String>) Arrays.asList(propertyScanner.nextLine().split(","));
		int marketValueIndex = columnNames.indexOf("market_value");
		int totalLivableAreaIndex = columnNames.indexOf("total_livable_area");
		int zipcodeIndex = columnNames.indexOf("zip_code");
		while (propertyScanner.hasNext()) {
			String propertyLine = propertyScanner.nextLine();
			String[] propertyLineValues = propertyLine.split(",");
			// TODO: makes sure zipcode is 5 numbers
			// TODO: use regex to split
			Property property = new Property(Double.parseDouble(propertyLineValues[marketValueIndex]), Double.parseDouble(propertyLineValues[totalLivableAreaIndex]), propertyLineValues[zipcodeIndex]);
			properties.add(property);
		}
		return properties;
	}
	
	public static void main(String[] args) {
		PropertiesReader r = new PropertiesReader();
		r.read("properties.csv");
	}

}
