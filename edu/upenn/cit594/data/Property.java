package edu.upenn.cit594.data;

/*
 * This class represents a row of the properties data set. It contains values for marketValue,
 * totalLivableArea, zipcode, and garageSpaces.
 */
public class Property {
	Double marketValue;
	Double totalLivableArea;
	String zipcode;
	int garageSpaces;
	
	public Double getMarketValue() {
		return marketValue;
	}

	public Double getTotalLivableArea() {
		return totalLivableArea;
	}

	public String getZipcode() {
		return zipcode;
	}
	
	public int getGarageSpaces() {
		return garageSpaces;
	}
	
	public Property(Double marketValue, Double totalLivableArea, int garageSpaces, String zipcode) {
		this.marketValue = marketValue;
		this.totalLivableArea = totalLivableArea;
		this.zipcode = zipcode;
		this.garageSpaces = garageSpaces;
	}


}
