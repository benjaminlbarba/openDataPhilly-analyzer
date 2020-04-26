package edu.upenn.cit594.processor;

import java.util.LinkedList;
import edu.upenn.cit594.data.Property;
import edu.upenn.cit594.datamanagement.OpenPhillyFileReader;



/**
 * This is step 3 and 4 in the hw
 * @author benjamin.barbaimbellus
 *
 */
public class PropertiesCalculator {
	
	private static int doCalculation(PropertyAccessor pa, LinkedList<Property> properties, String zipcode){
		Double avg = 0.0;
		Double totalValue = 0.0;
		int numProperties = 0;
		for (Property property : properties) {
			if (property.getZipcode().equals(zipcode)){
				totalValue += pa.access(property);
				numProperties++;
			}
		}
		
		if (numProperties != 0) {
			avg = totalValue / numProperties;
		}
		else {
			//not a ZIP Code that is listed in the input files.
			return 0;
		}
		
		//market value that your program displays must be truncated an integer (not rounded!)
		return (int) Math.floor(avg);
	}
	
	/**
	 * calculate the average residential market value for that ZIP Code, 
	 * @param properties
	 * @param zipcode
	 * @return
	 */
	public static int calculateAvgForPropertyAttribute(PropertyAccessor pa, LinkedList<Property> properties, String zipcode){
		//if the user enters an input that is not a valid ZIP
		if (!OpenPhillyFileReader.isValidZipcode(zipcode)) {
			return 0;
		}
		
		if (pa.getResults().containsKey(zipcode)){
			return pa.accessResult(zipcode);
		}
		
		int result = doCalculation(pa, properties, zipcode);
		pa.putResult(zipcode, result);
		
		return 0;
		
	}
	
}
