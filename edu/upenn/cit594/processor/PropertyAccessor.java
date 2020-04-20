package edu.upenn.cit594.processor;

import java.util.HashMap;

import edu.upenn.cit594.data.Property;


public interface PropertyAccessor {
	/**
	 * Accesses a variable inside of property
	 * @author benjamin.barbaimbellus
	 *
	 */
	
	public Double access(Property property);
	
	public int accessResult(String zipcode);
	
	public int putResult(String zipcode, int result);
	
	public HashMap<String, Integer> getResults();
}
