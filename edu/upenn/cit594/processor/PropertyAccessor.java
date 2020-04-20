package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.Property;


public interface PropertyAccessor {
	/**
	 * Accesses a variable inside of property
	 * @author benjamin.barbaimbellus
	 *
	 */
	public Double access(Property property);
}
