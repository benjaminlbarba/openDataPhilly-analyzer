package edu.upenn.cit594.data;

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
