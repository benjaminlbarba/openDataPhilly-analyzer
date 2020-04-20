package edu.upenn.cit594.data;

import java.util.Date;

public class ParkingViolation {
	Date timestamp;
	String violationDescription;
	String licensePlateNumber;
	String licensePlateState;
	String violationIdentifier;
	Fine fine;
	
	public ParkingViolation(Date timestamp, Double fineAmount, String violationDescription, String licensePlateNumber, String licensePlateState,String violationIdentifier, String zipcode) {
		this.timestamp = timestamp;
		this.violationDescription = violationDescription;
		this.licensePlateNumber = licensePlateNumber;
		this.licensePlateState = licensePlateState;
		this.violationDescription = violationDescription;
		this.fine = new Fine(fineAmount , zipcode);
	}

}
