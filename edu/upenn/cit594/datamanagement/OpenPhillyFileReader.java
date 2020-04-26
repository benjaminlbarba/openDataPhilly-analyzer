package edu.upenn.cit594.datamanagement;

public abstract class OpenPhillyFileReader {
	
	public static boolean isEmpty(String input) {
		if (input == null) {
			return true;
		} if (input.compareTo("") == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isEmptyLong(Long input) {
		if (input == null) {
			return true;
		} try {
			Double fineDouble = input.doubleValue();
			return false;
		} catch (NumberFormatException e){
			return true;
		}
	}
	
	public static String convertZipcode(String zipcode) {
		if (!isValidZipcode(zipcode)) {
			return zipcode.substring(0, 5);
		}
		else {
			return zipcode;
		}
	}
	
	public static boolean isValidZipcode(String input) {
		if (input.length() < 5) {
			return false;
		}
			
		if(!input.matches("[0-9]+")){
			return false;
		}
			
		return true;
	}
	
	public static boolean isNumeric(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e){
			return false;
		}
	}


}
