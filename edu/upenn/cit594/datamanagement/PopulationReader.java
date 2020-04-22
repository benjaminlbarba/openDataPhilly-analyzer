package edu.upenn.cit594.datamanagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


public class PopulationReader {

	
	public static HashMap<String, Integer> read(String fileName) {
		File populationTextFile = new File(fileName);
		HashMap<String, Integer> zipcodeAndPopulation = new HashMap<String, Integer>();
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
			zipcodeAndPopulation.put(populationValues[0], Integer.parseInt(populationValues[1]));
		}
		return zipcodeAndPopulation;
 	}
	
	
}
