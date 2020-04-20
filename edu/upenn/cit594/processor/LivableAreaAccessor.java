package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.Map;

import edu.upenn.cit594.data.Property;

public class LivableAreaAccessor implements PropertyAccessor {
	public static HashMap<String, Integer> results = new HashMap<>();
	
	@Override
	public Double access(Property property) {
		// TODO Auto-generated method stub
		return property.getTotalLivableArea();
	}

	@Override
	public int accessResult(String zipcode) {
		// TODO Auto-generated method stub
		return results.get(zipcode);
	}
	
	@Override
	public int putResult(String zipcode, int result) {
		// TODO Auto-generated method stub
		return results.put(zipcode, result);
	}

	@Override
	public HashMap<String, Integer> getResults() {
		// TODO Auto-generated method stub
		return results;
	}

}
