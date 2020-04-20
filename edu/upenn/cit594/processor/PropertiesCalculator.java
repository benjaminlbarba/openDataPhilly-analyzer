package edu.upenn.cit594.processor;

import java.util.LinkedList;

import edu.upenn.cit594.data.Property;

public class PropertiesCalculator {
	
	/**
	 * calculate the average residential market value for that ZIP Code, 
	 * @param properties
	 * @param zipcode
	 * @return
	 */
	public static int calculateAvgResidentialValue(LinkedList<Property> properties, String zipcode){
		//if the user enters an input that is not a valid ZIP
		if (!Property.isValidZipCode(zipcode)) {
			return 0;
		}
		
		Double avg = 0.0;
		Double totalMarketValue = 0.0;
		int numProperties = 0;
		for (Property property : properties) {
			if (property.getZipcode().equals(zipcode)){
				totalMarketValue += property.getMarketValue();
				numProperties++;
			}
		}
		
		if (numProperties != 0) {
			avg = totalMarketValue / numProperties;
		}
		else {
			//not a ZIP Code that is listed in the input files.
			return 0;
		}
		
		//market value that your program displays must be truncated an integer (not rounded!)
		return (int) Math.floor(avg);
	}
}
