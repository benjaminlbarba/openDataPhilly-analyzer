package edu.upenn.cit594.datamanagement;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.logging.UserInfoLogger;

public class PropertiesReader {
	
	public static LinkedList<Property> read(String fileName) {
		File fileToParse = new File(fileName);
		UserInfoLogger.logStringAtThisTime(fileName);
		
		LinkedList<Property> properties = new LinkedList<Property>();

		Scanner in;
		try {
			in = new Scanner(fileToParse);
			boolean bLabelsLine = true;
			int indexMarketValue = -1;
			int indexTotalLivableArea = -1;
			int indexGarageSpaces = -1;
			int indexZipcode = -1;
			
			while (in.hasNext()) {
				//[41.38, -81.49] 6 2019-01-28 19:02:28 Yay, homework!
				String line = in.nextLine();
				String[] entries = line.split(",");
				
				if (bLabelsLine) {
					System.out.println(line);
					for (int i = 0; i < entries.length; i++) {
						String entry = entries[i];
						if (entry.equalsIgnoreCase("market_value")) {
							indexMarketValue = i;
						}
						else if(entry.equalsIgnoreCase("total_livable_area")) {
							indexTotalLivableArea = i;
						}
						else if(entry.equalsIgnoreCase("garage_spaces")) {
							indexGarageSpaces = i;
						}
						else if(entry.equalsIgnoreCase("zip_code")) {
							indexZipcode = i;
						}
					}
					
					bLabelsLine = false;
				}
				else {
					String marketValueString = entries[indexMarketValue];
					Double marketValue = -1.0;
					if (!marketValueString.isEmpty()) {
						try{
							marketValue = Double.parseDouble(marketValueString);
						}
						catch(NumberFormatException e){
							continue;
						}
					}
					String totalLivableAreaString = entries[indexTotalLivableArea];
					Double totalLivableArea = -1.0;
					if (!totalLivableAreaString.isEmpty()) {
						try {
							totalLivableArea = Double.parseDouble(totalLivableAreaString);
						}
						catch(NumberFormatException e){
							continue;
						}
					}
					String garageSpacesString = entries[indexGarageSpaces];
					int garageSpaces = -1;
					if (!garageSpacesString.isEmpty()) {
						try {
							garageSpaces = Integer.parseInt(garageSpacesString);
						}
						catch(NumberFormatException e){
							continue;
						}
					}
					String zipcode = entries[indexZipcode];
					if (Property.isValidZipCode(zipcode)){
						zipcode = zipcode.substring(0, 5);
					}
					
					Property newProperty = new Property(marketValue, totalLivableArea, garageSpaces, zipcode);
					
					properties.add(newProperty);
				}
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for (int i = 0; i < 50; i++) {
//			Property property = properties.get(i);
//			System.out.println("Property["  + i + "]: " + "zipcode = " + property.getZipcode() + ", mv = " + property.getMarketValue() + ", gs = " + property.getGarageSpaces() );
//		}
		
		
		return properties;
	}
	
	public static void main(String[] args) {
		PropertiesReader.read("properties.csv");
	}

}
