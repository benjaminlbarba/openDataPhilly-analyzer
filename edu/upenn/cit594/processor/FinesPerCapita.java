package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.LinkedList;

import edu.upenn.cit594.data.Fine;

public class FinesPerCapita {

	/*
	 * If the user enters a 2 when prompted for input in Step #0, your program should display
		(to the console) the total fines per capita for each ZIP Code, i.e. the total aggregate
		fines divided by the population of that ZIP Code, as provided in the population input file.
	 */
	
	public static HashMap<String, Double> calculateFinesPerZipcode(LinkedList<Fine> fines, HashMap<String, Integer> populationByZipcode) {
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
		for (String zipcode : finesPerZipcode.keySet()) {
			int population = populationByZipcode.get(zipcode);
			// TODO: Need to be truncated to the correct decimal amount.
			Double finePerCapita = finesPerZipcode.get(zipcode) / population;
			// only add to the hashmap if population and fines per capita is not zero
			if (population != 0 | finePerCapita != 0) {
				finesPerCapita.put(zipcode, finePerCapita);
			} else {
				continue;
			}
		}
		return finesPerCapita;
	}
	

}
