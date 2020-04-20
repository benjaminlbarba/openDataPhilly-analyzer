package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.data.Property;

public class PropertiesReader {
	
	public PropertiesReader() {
		
	}
	
	//arraylist for now, subject to change
	public ArrayList<Property> read(String fileName) {
		File propertyFile = new File(fileName);
		ArrayList<Property> propertyValues = new ArrayList<Property>();
		Scanner propertyScanner = null;
		try {
			propertyScanner = new Scanner(propertyFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (propertyScanner.hasNext()) {
			String propertyLine = propertyScanner.nextLine();
			String[] propertyLineValues = propertyLine.split(",");
			System.out.println(propertyLine);
		
		}
		return null;
	}
	
	public static void main(String[] args) {
		PropertiesReader r = new PropertiesReader();
		r.read("properties.csv");
	}

}
