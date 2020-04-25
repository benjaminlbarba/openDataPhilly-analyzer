package edu.upenn.cit594.datamanagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import edu.upenn.cit594.logging.UserInfoLogger;



public class PopulationReader extends OpenPhillyFileReader {

	
	public static HashMap<String, Integer> read(String fileName) {
		File populationTextFile = new File(fileName);
		UserInfoLogger.logStringAtThisTime(fileName);
		HashMap<String, Integer> populations = new HashMap<String, Integer>();
		Scanner populationScanner = null;
		try {
			populationScanner = new Scanner(populationTextFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (populationScanner.hasNext()) {
			String populationLine = populationScanner.nextLine();
			String[] populationValues = populationLine.split(" ");
			
			// check if number of inputs is correct
			if (populationValues.length != 2) {
				continue;
			}
			
			String zipcode = populationValues[0];
			String population = populationValues[1];
			
			// make sure necessary data is not missing and is in the correct format
			if (isEmpty(zipcode) | !isNumeric(population)) {
				continue;
			}
			zipcode = convertZipcode(zipcode);
			populations.put(zipcode, Integer.parseInt(population));
		}
		return populations;
 	}
	

	
}
