package edu.upenn.cit594;

import java.util.LinkedList;

import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.processor.LivableAreaAccessor;
import edu.upenn.cit594.processor.MarketValueAccessor;
import edu.upenn.cit594.processor.PropertiesCalculator;
import edu.upenn.cit594.ui.UserInput;

/**
 * 
 * Handles arguments and runs processes
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
	public static void inputHandler(int input) {
		int avg;
		String zipcode;
		LinkedList<Property> properties = new LinkedList<>(); //TODO: pass this in, this is empty rn
		
		switch(input) {
		  case 0:
			//TODO: exit program
		    break;
		  case 1:
		    // TODO: show the total population for all ZIP Codes, as described in Step #1 below.
		    break;
		  case 2:
			// TODO:show the total parking fines per capita for each ZIP Code, as described in Step #2 below.
			break;
		  case 3:
			zipcode = UserInput.readingZipCode();
			avg = PropertiesCalculator.calculateAvgForPropertyAttribute(new MarketValueAccessor(), properties, zipcode);
			System.out.println("Average Market Value for Residential Properties at zipcode " + zipcode + " is " +  avg + ".");
			//TODO: prompt user again
			break;
		  case 4:
			zipcode = UserInput.readingZipCode();
			avg = PropertiesCalculator.calculateAvgForPropertyAttribute(new LivableAreaAccessor(), properties, zipcode);
			System.out.println("Average Livable Area for Residential Properties at zipcode " + zipcode + " is " +  avg + ".");
			//TODO: prompt user again
			break;
		  case 5:
			// TODO: show the total residential market value per capita for a specified ZIP Code, as described in Step #5 below.
		  case 6:
			// TODO:  show the results of your custom feature, as described in Step #6 below 
		  default:
		    // code block
		}
	}
	
	private static int argumentHandler(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
		}
		
		if (args.length == NUM_ARGS) {			
			String fileType = args[0];
			String fileNameParkingViolations = args[1];
			String fileNamePropertyValues = args[2];
			String fileNamePopulation = args[3];
			String fileNameLog = args[4];
			
			if (!fileType.equalsIgnoreCase("CSV") && !fileType.equalsIgnoreCase("JSON")){
				return -1;
			}
			
			//Read user input
			int input = UserInput.readingOperationSelection();
			inputHandler(input);
			
			//TODO: extract and process data
			
			
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
