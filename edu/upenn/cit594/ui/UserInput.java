package edu.upenn.cit594.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.upenn.cit594.data.Property;

public class UserInput {
	
	public static int readingOperationSelection(){
		Scanner in = new Scanner(System.in);
		int input = -1;
		while (input < 0 || input > 6 ) {
			System.out.println("Please input a number 0 - 6");
			try {	
				input = in.nextInt();
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
	
	public static String readingZipCode(){
		Scanner in = new Scanner(System.in);
		String input = "";
		while (Property.isValidZipCode(input)) {
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
}
