package edu.upenn.cit594;


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
	
	private static void argumentHandler(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = " + args[i]);
		}
		
		if (args.length == NUM_ARGS) {			
			String fileType = args[0];
			String fileNameParkingViolations = args[1];
			String fileNamePropertyValues = args[2];
			String fileNamePopulation = args[3];
			String fileNameLog = args[4];
			
			//TODO: extract and process data
	
			//TODO: display and log
			
		}
		else {
			System.out.println("Should have four arguments.  Found " + args.length + " out of " + NUM_ARGS);
		}
	}
	
	
	public static void main(String[] args) {
		argumentHandler(args);
	}
}
