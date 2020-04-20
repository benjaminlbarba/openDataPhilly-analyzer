package edu.upenn.cit594;

import src.edu.upenn.cit594.ui.UserInput;

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
			// TODO:show the average market value for residences in a specified ZIP Code, as described in Step #3 below.
			break;
		  case 4:
			// TODO:show the average total livable area for residences in a specified ZIP Code, as described in Step #4
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
			int input = UserInput.readingUserInput();
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
