package edu.upenn.cit594.data;

public class PropertyValue {
	Double marketValue;
	Double totalLivableArea;
	Zipcode zipcode;
	
	public PropertyValue(Double marketValue, Double totalLivableArea, Zipcode zipcode) {
		this.marketValue = marketValue;
		this.totalLivableArea = totalLivableArea;
		this.zipcode = zipcode;
	}

}
