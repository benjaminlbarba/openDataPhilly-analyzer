package edu.upenn.cit594.processor;

import java.util.HashMap;
import edu.upenn.cit594.data.Property;

/*
 * This class accesses the market value data.
 */
public class MarketValueAccessor implements PropertyAccessor {
	private static HashMap<String, Integer> MVresults = new HashMap<String, Integer>();
	
	@Override
	public Double access(Property property) {
		// TODO Auto-generated method stub
		return property.getMarketValue();
	}
	
	public int accessResult(String zipcode) {
		// TODO Auto-generated method stub
		return MVresults.get(zipcode);
	}
	
	public void putResult(String zipcode, int result) {
		MVresults.put(zipcode, result);
	}
	
	public HashMap<String, Integer> getResults(){
		return MVresults;
	}
}