package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.LinkedList;

import edu.upenn.cit594.data.Fine;

public class FinesPerCapitaCalculator{
	public static HashMap<String, Double> finesPerCapitaInstance = new HashMap<>();

	/*
	 * If the user enters a 2 when prompted for input in Step #0, your program should display
		(to the console) the total fines per capita for each ZIP Code, i.e. the total aggregate
		fines divided by the population of that ZIP Code, as provided in the population input file.
	 */
	
	public static HashMap<String, Double> calculateFinesPerZipcode(LinkedList<Fine>fines, HashMap<String, Integer> population) {
		if (!finesPerCapitaInstance.isEmpty()) {
			return finesPerCapitaInstance;
		} else {
			HashMap<String, Double> finesPerZipcode = new HashMap<String, Double>();
			HashMap<String, Double> finesPerCapita = new HashMap<String, Double>();
			for (Fine fine : fines) {
				String currentZipcode = fine.getZipcode();
				if (finesPerZipcode.containsKey(currentZipcode)) {
					Double currentValue = finesPerZipcode.get(currentZipcode);
					currentValue += fine.getAmount();
					finesPerZipcode.put(currentZipcode, currentValue);
				} else {
					finesPerZipcode.put(currentZipcode, fine.getAmount());
				}
			}
			for (String zipcode: finesPerZipcode.keySet()) {
				Double fine = finesPerZipcode.get(zipcode);
				int currentPopulation = population.get(zipcode);
				// only add to the hashmap if population and fines per capita is not zero
				if (currentPopulation != 0 & fine != 0) {
					// TODO: Need to be truncated to the correct decimal amount.
					Double finePerCapita = fine / currentPopulation;
					finesPerCapita.put(zipcode, finePerCapita);
				} else {
					continue;
				}
			}
			finesPerCapitaInstance = finesPerCapita;
			return finesPerCapita;
		}
	}
	
	

}
