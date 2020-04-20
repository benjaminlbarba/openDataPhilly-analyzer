package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.Property;

public class MarketValueAccessor implements PropertyAccessor {

	@Override
	public Double access(Property property) {
		// TODO Auto-generated method stub
		return property.getMarketValue();
	}

}