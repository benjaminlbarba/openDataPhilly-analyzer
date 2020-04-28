package edu.upenn.cit594.datamanagement;

/**
 * This abstract class provides common methods used among all the reader classes to help in reading
 * their respective files and checking for missing or incorrect data.
 * @author benjamin barba & lexie ulven
 *
 */
public abstract class OpenPhillyFileReader {
	

	/**
	 * Checks if the input is empty
	 * @param input - the string to check
	 * @return true if empty
	 */
	public static boolean isEmpty(String input) {
		if (input == null) {
			return true;
		} if (input.compareTo("") == 0) {
			return true;
		} else {
			return false;
		}
	}
	

	/**
	 * Checks if a long value is null or unable to be converted into a Double.
	 * @param input - the long to check
	 * @return true if empty
	 */
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
	
	/**
	 * Converts the zipcode to the correct format if it is incorrect.
	 * @param input - a string representing a zipcode to truncate
	 * @return truncated string
	 */
	public static String convertZipcode(String zipcode) {
		if (!isValidZipcode(zipcode)) {
			return zipcode.substring(0, 5);
		}
		else {
			return zipcode;
		}
	}
	
	/**
	 * Checks to make sure the zipcode is valid, that is, at least 5 in length
	 * @param input - a string representing a zipcode
	 * @return true if valid
	 */
	public static boolean isValidZipcode(String input) {
		if (input.length() < 5) {
			return false;
		}
			
		//if(!input.matches("[0-9]+")){
		//	return false;
		//}
			
		return true;
	}
	
	/**
	 * Checks to make sure a string can be converted to a double.
	 * @param value - a string representing a potentially numeric value
	 * @return true if a number
	 */
	public static boolean isNumeric(String value) {
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e){
			return false;
		}
	}


}
