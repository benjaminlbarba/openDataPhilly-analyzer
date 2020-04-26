package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import edu.upenn.cit594.data.Fine;
import edu.upenn.cit594.data.Property;
import javafx.util.Pair;

/**
 * 
 * @author benjamin.barbaimbellus
 *
 */
public class PropertyPopulationParkingCalculator {
	private static Pair<String, Double> result = new Pair<>("", -1.0);
	
	/**
	 * What was the number of traffic violation per capita 
	 * in the zipcode with the highest average garage spaces per capita?
	 * @param fines
	 * @param properties
	 * @param population
	 * @return
	 */
	public static Pair <String,Double> calculateViolationsAtHighestGarageSpace(LinkedList<Fine> fines, LinkedList<Property> properties, HashMap<String, Integer> population) {
		if (result.getKey() != "") {
			return result;
		}
		
		//zipcode, num garage spaces
		HashMap<String, Double> garageSpacesMap = new HashMap<>();
		
		//iterate through properties to find number of garagespaces per zipcode
		for (Property property : properties) {
			String zipcode = property.getZipcode();
			if (garageSpacesMap.containsKey(zipcode)) {
				Double currentGarageSpaces = garageSpacesMap.get(zipcode);
				garageSpacesMap.put(zipcode,  currentGarageSpaces + property.getGarageSpaces());
			}
			else {
				garageSpacesMap.put(zipcode, new Double(property.getGarageSpaces()));
			}
		}
		
		//zipcode, garage space per capita
		Double maxGarageSpacesPerCapita = 0.0;
		String maxZipCode = "";
		for (Map.Entry<String,Double> entry : garageSpacesMap.entrySet())  {
			 String currZipcode = entry.getKey();
			 if (population.containsKey(currZipcode)) {
				 //System.out.println(currZipcode);
				 Double currGarageSpacesPerCapita = entry.getValue() / population.get(currZipcode);
		         if (currGarageSpacesPerCapita > maxGarageSpacesPerCapita) {
		        	 maxGarageSpacesPerCapita = currGarageSpacesPerCapita;
		        	 maxZipCode = currZipcode;
		         }
			 }
			
	    }
		
		int numFines = 0;
		for (Fine fine : fines) {
			if (fine.getZipcode() == maxZipCode) {
				numFines++;
			}
		}
		
		//System.out.println("numFines = " + numFines);
		Pair <String,Double> result = new Pair<>(maxZipCode, numFines / (population.get(maxZipCode) * 1.0));
		return result;
	}
}
