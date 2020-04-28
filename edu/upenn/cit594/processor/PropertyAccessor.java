package edu.upenn.cit594.processor;

import java.util.HashMap;

import edu.upenn.cit594.data.Property;

/**
 * Accesses a variable inside of property
 * @author benjamin barba & lexie ulven
 *
 */
public interface PropertyAccessor {

	
	public Double access(Property property);
	
	public int accessResult(String zipcode);
	
	public void putResult(String zipcode, int result);
	
	public HashMap<String, Integer> getResults();
}
