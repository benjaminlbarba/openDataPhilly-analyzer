package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.LinkedList;


public class PopulationCalculator {
	public static int totalPopulationInstance = 0;
	
	/*
	 * If the user enters a 1 when prompted for input in Step #0, the program should display
	(to the console) the total population for all of the ZIP Codes in the population input file
	and then terminate.
	Your program must not write any other information to the console. It must only
	display the total population, i.e. the sum of the populations for each ZIP Code in the
	input file, and then the program should prompt for another input in Step #0.
	
	Hint! For this feature, your program should print 1526206 when run on the data files we
	have provided. If it does not print this, then your program is not working correctly. This is
	the only feature for which we will provide the correct output in advance! Each group
	must determine for themselves what the correct output should be for other parts of this
	assignment.
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
