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
	
	//TODO: move this to a .data package class?
	public static boolean isValidZipCode(String input) {
		if (input.length() != 9) {
			System.out.println("Invalid zipcode: zipcode must be 9 digits long.");
			return false;
		}
		
		if(!input.matches("[0-9]+")){
			System.out.println("Invalid zipcode: all input must be numbers.");
			return false;
		}
		
		return false;
	}

}
