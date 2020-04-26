package edu.upenn.cit594.processor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

import edu.upenn.cit594.data.DataStorage;
import edu.upenn.cit594.data.Fine;
import edu.upenn.cit594.datamanagement.ReadAllFiles;

public class FinesPerCapitaCalculator{
	public static TreeMap<String, String> finesPerCapitaInstance = new TreeMap<>();

	/*
	 * If the user enters a 2 when prompted for input in Step #0, your program should display
		(to the console) the total fines per capita for each ZIP Code, i.e. the total aggregate
		fines divided by the population of that ZIP Code, as provided in the population input file.
	 */
	
	public static TreeMap<String, String> calculateFinesPerZipcode(LinkedList<Fine>fines, HashMap<String, Integer> population) {
		if (!finesPerCapitaInstance.isEmpty()) {
			return finesPerCapitaInstance;
		} else {
			HashMap<String, Double> finesPerZipcode = new HashMap<String, Double>();
			TreeMap<String, String> finesPerCapita = new TreeMap<String, String>();
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
				if (!population.containsKey(zipcode)) {
					continue;
				}
				int currentPopulation = population.get(zipcode);
				// only add to the hashmap if population and fines per capita is not zero
				if (currentPopulation != 0 & fine != 0) {
					Double finePerCapita = fine / currentPopulation;
					BigDecimal finePerCapitaBD = BigDecimal.valueOf(finePerCapita);
					finePerCapitaBD = finePerCapitaBD.setScale(4, RoundingMode.DOWN);
					String finePerCapitaStr = String.format("%.4f", finePerCapitaBD);
					finesPerCapita.put(zipcode, finePerCapitaStr);
				} else {
					continue;
				}
			}
			finesPerCapitaInstance = finesPerCapita;
			return finesPerCapita;
		}
	}
	

}
