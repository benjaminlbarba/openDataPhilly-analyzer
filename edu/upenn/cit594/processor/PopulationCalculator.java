package edu.upenn.cit594.processor;

import java.util.HashMap;

/*
 * This class handles the calculation for user input 1. 
 */
public class PopulationCalculator {
	public static int totalPopulationInstance = 0;
	
	/*
	 * This method controls the calculation, taking in population as an argument. It retuns the total
	 * population.
	 */
	public static int calculateTotalPopulation(HashMap<String, Integer> populationByZipcode) {
		if (totalPopulationInstance != 0) {
			return totalPopulationInstance;
		} else {
			int totalPopulation = 0;
			for (String zipcode : populationByZipcode.keySet()) {
				totalPopulation += populationByZipcode.get(zipcode);
			}
			totalPopulationInstance = totalPopulation;
			return totalPopulation;
		}	
	}

}
