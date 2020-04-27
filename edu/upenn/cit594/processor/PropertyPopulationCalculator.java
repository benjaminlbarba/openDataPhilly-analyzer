package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.LinkedList;

import edu.upenn.cit594.data.Property;

/**
 * This class handles the calculation for user input 5 and memoization.
 *
 */
public class PropertyPopulationCalculator {
	
	static HashMap<String, Integer> results = new HashMap<>();
	
	/**
	 * This method calculates the market value per capita of the zipcode entered by the user.
	 */
	public static int calculateMarketValuePerCapita(LinkedList<Property> properties, String zipcode, HashMap<String, Integer> population){
		//if the user enters an input that is not a valid ZIP

		if (!population.containsKey(zipcode)) {
			return 0;
		}
		
		if (population.get(zipcode) == 0) {
			return 0;
		}
		
		if (results.containsKey(zipcode)){
			return results.get(zipcode);
		}
		
		Double totalMarketValue = 0.0;
		for (Property property : properties) {
			if (property.getZipcode().equals(zipcode)){
				totalMarketValue += property.getMarketValue();
			}
		}
		
		if (totalMarketValue == 0.0) {
			return 0;
		}
		
		//market value that your program displays must be truncated an integer (not rounded!)
		Double marketValuePerCapita = totalMarketValue / population.get(zipcode);
		int result = (int) Math.floor(marketValuePerCapita);
		results.put(zipcode, result);
		
		return result;
	}
	
}

