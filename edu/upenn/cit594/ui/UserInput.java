package edu.upenn.cit594.ui;

import java.util.ArrayList;
import java.util.Scanner;
import edu.upenn.cit594.datamanagement.OpenPhillyFileReader;

/*
 * This class reads in the user inputs for the calculation selection and entered zipcode.
 */
public class UserInput {
	
	/*
	 * Reads in the selection of the calculation from the user and returns it.
	 */
	public static int readingOperationSelection(){
		Scanner in = new Scanner(System.in);
		int inputTracker = -1;
		String inputString = "";
		while (inputTracker < 0) {
			Display.requestInput();
			inputString = in.nextLine();
			if (isValidInput(inputString)) {
				break;
			} else {
				Display.errorInput();
				//prompt the user again
			}
		}
		int input = Integer.parseInt(inputString);
		return input;
	}
	
	/*
	 * Reads the zipcode entered by the user.
	 */
	public static String readingZipCode(){
		Scanner in = new Scanner(System.in);
		int inputTracker = -1;
		String input = "";
		while (inputTracker < 0) {
			Display.requestZipcode();
			input = in.nextLine();
			if (OpenPhillyFileReader.isValidZipcode(input)) {
				break;
			} else {
				Display.errorInput();
			}
			//prompt the user again
		}
		
		return input;
	}
	
	/*
	 * Checks to make sure the input is correct.
	 */
	public static boolean isValidInput(String input) {
		ArrayList<String> validInputs = new ArrayList<String>();
		validInputs.add("0");
		validInputs.add("1");
		validInputs.add("2");
		validInputs.add("3");
		validInputs.add("4");
		validInputs.add("5");
		validInputs.add("6");
		if (validInputs.contains(input)) {
			return true;
		} else {
			return false;
		}
	}
	
}
