package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.logging.UserInfoLogger;

/**
 * This class reads in the properties data set. It extends the abstract class OpenPhillyFileReader.
 * It's only method, read, returns a linkedlist containing the data filtered for wrong or missing information.
 **/
public class PropertiesReader extends OpenPhillyFileReader {
	
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
			
			int lnCounter = 0;
			while (in.hasNext()) {
				//[41.38, -81.49] 6 2019-01-28 19:02:28 Yay, homework!
				String line = in.nextLine();
				String[] entriesOriginal = line.split(",");
				
				//do first time for first header line only
				if (bLabelsLine) {
					for (int i = 0; i < entriesOriginal.length; i++) {
						String entry = entriesOriginal[i];
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
					continue;
				}
				
				String[] entries = new String[entriesOriginal.length];
				
				//need to check for opening and closing quotation marks
				String concatenatedEntry = "";
				boolean bConcat = false;
				int indexEntriesFinal = 0;
				for (int i = 0; i < entriesOriginal.length; i++) {
					String entry = entriesOriginal[i];
					
					for (String entryOriginal : entriesOriginal) {
						//System.out.println("entryOriginal = " + entryOriginal);
					}
					
					//if (!entry.isEmpty()) {
					if (bConcat) {
						
						concatenatedEntry = concatenatedEntry.concat(entry);
						System.out.println("... " + concatenatedEntry);
						//ending quotation mark found
						//stop concatenating and reset
						if (entry.matches("$\"")&& bConcat) {
							bConcat = false;
							entries[indexEntriesFinal] = concatenatedEntry;
							indexEntriesFinal += 1;
							concatenatedEntry = "";
						}
					}
					//start concatenating
					else if (entry.matches("^\"") && (!entry.matches("^\"$"))) {
						System.out.println("concat start [" + lnCounter+ "]= " + entry);
						bConcat = true;
						concatenatedEntry = concatenatedEntry.concat(entry);
						continue;
					}
					//keep adding normally
					else {
						//System.out.println("adding entry = " + entry);
						entries[indexEntriesFinal] = entry;
						indexEntriesFinal += 1;
						
					}
					
				}
				lnCounter++;
				
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
				if (OpenPhillyFileReader.isValidZipcode(zipcode)){
					zipcode = convertZipcode(zipcode);
				}
				
				//let through properties with an invalid zipcode.  
				//They are still properties, just won't be involved in any zipcode calculations
				Property newProperty = new Property(marketValue, totalLivableArea, garageSpaces, zipcode);
				properties.add(newProperty);
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties;
	}
}
