package edu.upenn.cit594.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.datamanagement.OpenPhillyFileReader;

public class UserInput {
	
	public static int readingOperationSelection(){
		Scanner in = new Scanner(System.in);
		int inputTracker = -1;
		int input = -1;
		while (inputTracker < 0) {
			System.out.println("Please input a number 0 - 6");
			input = in.nextInt();
			if (isValidInput(input)) {
				break;
			} else {
				System.out.println("Invalid input you trickster!");
				//prompt the user again
			}
		}
		return input;
	}
	
	public static String readingZipCode(){
		Scanner in = new Scanner(System.in);
		String input = "";
		while (OpenPhillyFileReader.isValidZipcode(input)) {
			System.out.println("Please input a 9 digit zipcode.");
			try {	
				input = in.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input you trickster!");
				in.nextLine();
			}
			//prompt the user again
		}
		
		in.close();
		return input;
	}
	
	public static boolean isValidInput(int input) {
		ArrayList<Integer> validInputs = new ArrayList<Integer>();
		validInputs.add(0);
		validInputs.add(1);
		validInputs.add(2);
		validInputs.add(3);
		validInputs.add(4);
		validInputs.add(5);
		validInputs.add(6);
		if (validInputs.contains(input)) {
			return true;
		} else {
			return false;
		}
	}
}
