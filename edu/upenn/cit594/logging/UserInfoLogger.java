package edu.upenn.cit594.logging;

/**
 * 
 * The userinfologger class passes results and user inputs from the main class to the logger to be 
 * logged in the logged file.
 * @author ulven & barba
 *
 */
public class UserInfoLogger {
	static Logger logger = Logger.getInstance();
	
	public static void logTime() {
		long time = System.currentTimeMillis();
		logger.log(Long.toString(time) + " ");
	}
	
	/*
	 * This method is used to log the user input and the current time.
	 */
	public static void logIntAtThisTime(int myInt) {
		long time = System.currentTimeMillis();
		logger.log(Long.toString(time) + " " + Integer.toString(myInt));
	}
	
	/*
	 * This method is used to log the zipcode or filenames.
	 */
	public static void logStringAtThisTime(String myString) {
		long time = System.currentTimeMillis();
		logger.log(Long.toString(time) + " " + myString);
	}
	
	/*
	 * This method is used for logging the input arguments.
	 */
	public static void logStringArrayAtThisTime(String[] args) {
		long time = System.currentTimeMillis();
		String argsConcatenated = "";
		for (String arg : args) {
			argsConcatenated += arg;
			argsConcatenated += " ";
		}
		logger.log(Long.toString(time) + " " + argsConcatenated);
	}
}
