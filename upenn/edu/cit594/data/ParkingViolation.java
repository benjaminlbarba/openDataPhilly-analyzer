package edu.upenn.cit594.data;

import java.util.Date;

public class ParkingViolation {
	Date timestamp;
	Double fineAmount;
	String violationDescription;
	String licensePlateNumber;
	String licensePlateState;
	String violationIdentifier;
	Zipcode zipcode;
	
	public ParkingViolation(Date timestamp, Double fineAmount, String violationDescription, String licensePlateNumber, String licensePlateState,String violationIdentifier, Zipcode zipcode) {
		this.timestamp = timestamp;
		this.fineAmount = fineAmount;
		this.violationDescription = violationDescription;
		this.licensePlateNumber = licensePlateNumber;
		this.licensePlateState = licensePlateState;
		this.violationDescription = violationDescription;
		this.zipcode = zipcode;
	}

}
