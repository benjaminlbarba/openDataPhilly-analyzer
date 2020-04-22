package edu.upenn.cit594;

import java.util.HashMap;
import java.util.LinkedList;

import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.datamanagement.ParkingViolationReaderCSV;
import edu.upenn.cit594.datamanagement.PopulationReader;
import edu.upenn.cit594.processor.FinesPerCapita;
import edu.upenn.cit594.processor.LivableAreaAccessor;
import edu.upenn.cit594.processor.MarketValueAccessor;
import edu.upenn.cit594.processor.PopulationCalculator;
import edu.upenn.cit594.processor.PropertiesCalculator;
import edu.upenn.cit594.processor.PropertyPopulationCalculator;
import edu.upenn.cit594.ui.UserInput;

/**
 * 
 * Handles arguments and runs processes
 * @author benjamin.barba & lexie ulven
 *
 */

public class Main {
	static final int NUM_ARGS = 5;
	static String fileType;
	static String fileNameParkingViolations;
	static String fileNamePropertyValues;
	static String fileNamePopulation;
	static String fileNameLog;
	//TODO: linkedlistStorage class instance
	
	/**
	 * reads runtime arguments and performs operations using each argument
	 * @param args - runtime arguments.  Expects five: 
	 *  0 The format of the parking violations input file, either “csv” or “json”
	 *  1 The name of the parking violations input file
	 *  2 The name of the property values input file
	 *  3 The name of the population input file
	 *  4 The name of the log file (described below)
	 */
	public static void inputHandler() {
		int avg;
		String zipcode;
		LinkedList<Property> properties = new LinkedList<>(); //TODO: pass this in, this is empty rn
		HashMap<String, Integer> populationByZipcode = PopulationReader.read(fileNamePopulation);
		
		int input = UserInput.readingOperationSelection();
		
		switch(input) {
		  case 0:
			  // log time
			System.exit(0);
		    break;
		  case 1:
			  // log time
			System.out.println(PopulationCalculator.calculateTotalPopulation(populationByZipcode));
		    break;
		  case 2:
			  // log time
			HashMap<String, Double> finesPerCapita = FinesPerCapita.calculateFinesPerZipcode(ParkingViolationReaderCSV.read(fileNameParkingViolations), populationByZipcode);
			for (String zipcodeCase2 : finesPerCapita.keySet()) {
				System.out.println(zipcodeCase2 + " " + finesPerCapita.get(zipcodeCase2));
			}
			break;
		  case 3:
			  // log time
			zipcode = UserInput.readingZipCode();
			avg = PropertiesCalculator.calculateAvgForPropertyAttribute(new MarketValueAccessor(), properties, zipcode);
			System.out.println("Average Market Value for Residential Properties at zipcode " + zipcode + " is " +  avg + ".");
			break;
		  case 4:
			  //log time
			zipcode = UserInput.readingZipCode();
			avg = PropertiesCalculator.calculateAvgForPropertyAttribute(new LivableAreaAccessor(), properties, zipcode);
			System.out.println("Average Livable Area for Residential Properties at zipcode " + zipcode + " is " +  avg + ".");
			break;
		  case 5:
			  // log time
			zipcode = UserInput.readingZipCode();
			int marketValuePerCapita = PropertyPopulationCalculator.calculateMarketValuePerCapita(properties, zipcode, populationByZipcode);
			System.out.println("Market Value per Capita for Residential Properties at zipcode " + zipcode + " is " +  marketValuePerCapita + ".");
		  case 6:
			// TODO:  show the results of your custom feature, as described in Step #6 below 
		  default:
		    // code block
			  break;
		}
		
		inputHandler();
	}
	
	private static int argumentHandler(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
		}
		
		if (args.length == NUM_ARGS) {			
			fileType = args[0];
			fileNameParkingViolations = args[1];
			fileNamePropertyValues = args[2];
			fileNamePopulation = args[3];
			fileNameLog = args[4];
			
			if (!fileType.equalsIgnoreCase("CSV") && !fileType.equalsIgnoreCase("JSON")){
				return -1;
			}
			
			//TODO: extract and process data
			//maybe create a LinkedListStorage.java
			
			//Read user input
			inputHandler();
			
			//TODO: display and log
			
		}
		else {
			System.out.println("Should have four arguments.  Found " + args.length + " out of " + NUM_ARGS);
		}
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		argumentHandler(args);
	}
}
