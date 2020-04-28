package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import edu.upenn.cit594.data.Fine;
import edu.upenn.cit594.data.GarageAndFinesPair;
import edu.upenn.cit594.data.Property;
import javafx.util.Pair;

/**
 * Handles calculations involving all three datasets
 * Creates an ordered list based on garage spaces per capita
 * @author benjamin barba & lexie ulven
 *
 */
public class PropertyPopulationParkingCalculator {
	private static LinkedList<Pair<String, GarageAndFinesPair>> result = new LinkedList<>();
	
	public static void insertIntoOrderList(LinkedList<Pair<String, GarageAndFinesPair>> orderedList, Pair<String, GarageAndFinesPair> newPair) {
		if (orderedList.size() == 0) {
			orderedList.add(newPair);
		}
		else {
			for (int i = 0; i < orderedList.size(); i++) {
				Double currVal = orderedList.get(i).getValue().getNumGarageSpacesperCapita();
				Double newVal = newPair.getValue().getNumGarageSpacesperCapita() ;
				
				if (newVal < currVal) {
					orderedList.add(i, newPair);
					return;
				}
			}
			//found nothing smaller, adding to end
			orderedList.add(newPair);
		}
	}
	
	
	/**
	 * What was the number of traffic violation per capita 
	 * in the zipcode with the highest average garage spaces per capita?
	 * @param fines
	 * @param properties
	 * @param population
	 * @return
	 */
	public static LinkedList<Pair<String, GarageAndFinesPair>> calculateViolationsAtHighestGarageSpace(LinkedList<Fine> fines, LinkedList<Property> properties, HashMap<String, Integer> populationOriginal) {
		if (result.size() > 0) {
			return result;
		}
		
		HashMap<String, Integer> population = new HashMap<>();
		for (Map.Entry<String, Integer> entry : populationOriginal.entrySet()) {
		    String zipcode = entry.getKey();
		    if (!zipcode.isEmpty() && zipcode.length() > 5) {
				zipcode = zipcode.substring(0, 5);
			}
		    
		    population.put(zipcode, entry.getValue());
		}
		
		
		//System.out.println("calculateViolationsAtHighestGarageSpace called");
		LinkedList<Pair<String, GarageAndFinesPair>> orderedList = new LinkedList<>();
		
		//<zipcode, num garage spaces>
		HashMap<String, Double> garageSpacesMap = new HashMap<>();
		
		
		//iterate through properties to find number of garagespaces per zipcode
		for (Property property : properties) {
			String zipcode = property.getZipcode();
			if (!zipcode.isEmpty() && zipcode.length() > 5) {
				zipcode = zipcode.substring(0, 5);
			}
			if (garageSpacesMap.containsKey(zipcode)) {
				Double currentGarageSpaces = garageSpacesMap.get(zipcode);
				garageSpacesMap.put(zipcode,  currentGarageSpaces + property.getGarageSpaces());
			}
			else {
				garageSpacesMap.put(zipcode, new Double(property.getGarageSpaces()));
			}
		}
		
		//get fines for each zipcode
		HashMap<String, Integer> numFinesMap = new HashMap<>();
		int numFines = 0;
		//System.out.println("fines.size = " + fines.size() );
		for (Fine fine : fines) {
			//System.out.println("fine found");
			String zipcode = fine.getZipcode();
			if (!zipcode.isEmpty() && zipcode.length() > 5) {
				zipcode = zipcode.substring(0, 5);
			}
			if (numFinesMap.containsKey(zipcode)) {
				int currNumFines = numFinesMap.get(zipcode);
				numFinesMap.put(zipcode,  currNumFines + 1);
			}
			else {
				numFinesMap.put(zipcode, 1);
			}
		}
		
		for (Map.Entry<String,Double> entry : garageSpacesMap.entrySet())  {
			 String currZipcode = entry.getKey();
			 //System.out.println("checking zipcode " + currZipcode);
			 if (population.containsKey(currZipcode) && numFinesMap.containsKey(currZipcode)) {
				 //System.out.println("FOUND");
				 Double currGarageSpacesPerCapita = entry.getValue() / (population.get(currZipcode) * 1.0);
		         Double numFinesPerCapita = numFinesMap.get(currZipcode) / (population.get(currZipcode) * 1.0);
		         
		         GarageAndFinesPair valuePair = new GarageAndFinesPair(currGarageSpacesPerCapita, numFinesPerCapita);
				 Pair<String, GarageAndFinesPair> myPair = new Pair<>(currZipcode, valuePair);
				 
				 //create a linkedlist, organizing it from least to greatest
				 insertIntoOrderList(orderedList, myPair);
			 }
	    }

		result = orderedList;
		return result;
	}
}
