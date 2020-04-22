package edu.upenn.cit594.logging;

/**
 * 
 * When the program starts, it should write the current time followed by a single whitespace, 
 * followed by each of the runtime arguments, each of which is separated by a single whitespace.
 * 
 * Whenever an input file is opened for reading, the program should write the current time 
 * and the name of the file to the log file. 
 * 
 * When the user makes a choice from the prompt in Step #0, the program should write
 * the current time and the user’s selection to the log file.
 * 
 * If the user enters a ZIP Code in Step #3, 4, or 5, the program should write the current
 * time and the specified ZIP Code to the log file.
 * You do not need to log anything for your additional feature in Step #6.
 * @author ulven & barba
 *
 */
public class UserInfoLogger {
	
	public static void logTime() {
		long time = System.currentTimeMillis();
		Logger.getInstance().log(Long.toString(time) + " ");
		Logger.getInstance().end();
	}
	
	public static void logIntAtThisTime(int myInt) {
		logTime();
		Logger.getInstance().log(Integer.toString(myInt));
		Logger.getInstance().end();
	}
	
	public static void logStringAtThisTime(String myString) {
		logTime();
		Logger.getInstance().log(myString);
		Logger.getInstance().end();
	}
	
	public static void logStringArrayAtThisTime(String[] args) {
		logTime();
		for (String arg : args) {
			Logger.getInstance().log(arg);
		}
		Logger.getInstance().end();
	}
}
