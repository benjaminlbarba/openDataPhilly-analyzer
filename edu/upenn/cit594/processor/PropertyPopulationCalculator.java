package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.LinkedList;
import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.datamanagement.ReadAllFiles;

/**
 * This is step 5 in the HW instructions
 * @author benjamin.barbaimbellus
 *
 */
public class PropertyPopulationCalculator {
	/*5. Total Residential Market Value Per Capita
	If the user enters a 5 when prompted for input in Step #0, your program should then
	prompt the user to enter a ZIP Code.
	
	Your program should then display (to the console) the total residential market value per
	capita for that ZIP Code, i.e. the total market value for all residences in the ZIP Code
	divided by the population of that ZIP Code, as provided in the population input file.
	The residential market value per capita must be displayed as a truncated integer, and
	your program should display 0 if the total residential market value for the ZIP Code is 0,
	if the population of the ZIP Code is 0, or if the user enters an input that is not a valid ZIP
	Code or is not a ZIP Code that is listed in the input files.
	
	Your program must not write any other information to the console. It must only
	display the total residential market value per capita and then the program should prompt
	for another input in Step #0.*/
	
	static HashMap<String, Integer> results = new HashMap<>();
	
	/**
	 * calculate the residential market value per capita for that ZIP Code, 
	 */
	public static int calculateMarketValuePerCapita(LinkedList<Property> properties, String zipcode, HashMap<String, Integer> population){
		//if the user enters an input that is not a valid ZIP
		if (!Property.isValidZipCode(zipcode) | !population.containsKey(zipcode) | population.get(zipcode) == 0) {
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

