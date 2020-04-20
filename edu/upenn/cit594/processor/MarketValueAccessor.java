package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.Map;

import edu.upenn.cit594.data.Property;

public class MarketValueAccessor implements PropertyAccessor {
	private static HashMap<String, Integer> results;
	
	@Override
	public Double access(Property property) {
		// TODO Auto-generated method stub
		return property.getMarketValue();
	}
	
	public int accessResult(String zipcode) {
		// TODO Auto-generated method stub
		return results.get(zipcode);
	}
	
	public int putResult(String zipcode, int result) {
		// TODO Auto-generated method stub
		return results.put(zipcode, result);
	}
	
	public HashMap<String, Integer> getResults(){
		return results;
	}
}