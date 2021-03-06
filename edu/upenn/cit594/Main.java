package edu.upenn.cit594;

import java.util.LinkedList;
import java.util.TreeMap;

import edu.upenn.cit594.data.DataStorage;
import edu.upenn.cit594.data.GarageAndFinesPair;
import edu.upenn.cit594.datamanagement.ReadAllFiles;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.logging.UserInfoLogger;
import edu.upenn.cit594.processor.FinesPerCapitaCalculator;
import edu.upenn.cit594.processor.LivableAreaAccessor;
import edu.upenn.cit594.processor.MarketValueAccessor;
import edu.upenn.cit594.processor.PopulationCalculator;
import edu.upenn.cit594.processor.PropertiesCalculator;
import edu.upenn.cit594.processor.PropertyPopulationCalculator;
import edu.upenn.cit594.processor.PropertyPopulationParkingCalculator;
import edu.upenn.cit594.ui.Display;
import edu.upenn.cit594.ui.UserInput;
import javafx.util.Pair;

/**
 * 
 * The main class handles arguments and runs processes.
 * @author benjamin.barba & lexie ulven
 *
 */

public class Main {
	static final int NUM_ARGS = 5;
	
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
		
		int input = UserInput.readingOperationSelection();
		UserInfoLogger.logIntAtThisTime(input);
		
		// This switch handles all the inputs from the user and displays results to the console as needed.
		switch(input) {
		  case 0:
			Display.exitProgram();
			Logger.getInstance().end();
			System.exit(0);
		    break;
		  case 1:
			Display.option1Result(PopulationCalculator.calculateTotalPopulation(DataStorage.population));
		    break;
		  case 2:
			TreeMap<String, String> finesPerCapita = FinesPerCapitaCalculator.calculateFinesPerZipcode(DataStorage.fines, DataStorage.population);
			Display.option2Result(finesPerCapita);
			break;
		  case 3:
			zipcode = UserInput.readingZipCode();
			UserInfoLogger.logStringAtThisTime(zipcode);
			avg = PropertiesCalculator.calculateAvgForPropertyAttribute(new MarketValueAccessor(), DataStorage.properties, zipcode);
			Display.genericIntResult("Average Market Value", zipcode, avg);
			break;
		  case 4:
			zipcode = UserInput.readingZipCode();
			UserInfoLogger.logStringAtThisTime(zipcode);
			avg = PropertiesCalculator.calculateAvgForPropertyAttribute(new LivableAreaAccessor(), DataStorage.properties, zipcode);
			Display.genericIntResult("Average Livable Area", zipcode, avg);
			break;
		  case 5:
			zipcode = UserInput.readingZipCode();
			UserInfoLogger.logStringAtThisTime(zipcode);
			int marketValuePerCapita = PropertyPopulationCalculator.calculateMarketValuePerCapita(DataStorage.properties, zipcode, DataStorage.population);
			Display.genericIntResult("Market Value per Capita", zipcode, marketValuePerCapita);
			break;
		  case 6:
			LinkedList<Pair<String, GarageAndFinesPair>> orderedList = PropertyPopulationParkingCalculator.calculateViolationsAtHighestGarageSpace(DataStorage.fines, DataStorage.properties, DataStorage.population);
			Display.option6Result(orderedList);
			
			break;
		  default:
		    // code block
			  break;
		}
		
		inputHandler();
	}
	
	/*
	 * Argument handler method takes in the arguments presented to main, logs them, and reads them.
	 */
	private static int argumentHandler(String[] args) {
		
		if (args.length == NUM_ARGS) {			
			String fileType = args[0];
			String fileNameParkingViolations = args[1];
			String fileNamePropertyValues = args[2];
			String fileNamePopulation = args[3];
			String fileNameLog = args[4];	
			if (!fileType.equalsIgnoreCase("CSV") && !fileType.equalsIgnoreCase("JSON")){
				return -1;
			}
			
			Logger logger = Logger.getInstance();
			logger.initFileName(fileNameLog);
			UserInfoLogger.logStringArrayAtThisTime(args);
			
			ReadAllFiles.read(fileNameParkingViolations, fileNamePropertyValues, fileNamePopulation, fileType);
			
			inputHandler();
			
			
		}
		else {
			Display.errorArgs(args.length, NUM_ARGS);
		}
		
		return 0;
	}
	
	/*
	 * The main method begins the program.
	 */
	public static void main(String[] args) {
		argumentHandler(args);
	}
}
