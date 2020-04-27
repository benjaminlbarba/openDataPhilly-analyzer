package edu.upenn.cit594.data;

public class GarageAndFinesPair {
	Double numGarageSpacesperCapita;
	Double numFinesPerCapita;
	
	public Double getNumGarageSpacesperCapita() {
		return numGarageSpacesperCapita;
	}

	public Double getNumFinesPerCapita() {
		return numFinesPerCapita;
	}

	public GarageAndFinesPair(Double garages, Double fines) {
		this.numGarageSpacesperCapita = garages;
		this.numFinesPerCapita = fines;
	}
}
