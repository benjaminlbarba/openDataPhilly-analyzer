package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.data.Zipcode;

public class ParkingViolationReader {
	
	public ParkingViolationReader() {
		
	}
	
	public ArrayList<ParkingViolation> read(String fileName) {
		File populationTextFile = new File(fileName);
		ArrayList<ParkingViolation> parkingViolations = new ArrayList<ParkingViolation>();
		Scanner parkingScanner = null;
		try {
			parkingScanner = new Scanner(populationTextFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (parkingScanner.hasNext()) {
			String parkingLine = parkingScanner.nextLine();
			String[] parkingValues = parkingLine.split(",");
			System.out.println(parkingLine);
			Date violationDate = null;
			try {
				violationDate = new SimpleDateFormat("YYYY-MM-DDThh:mm:ssZ").parse(parkingValues[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ParkingViolation currentParkingViolation = new ParkingViolation(violationDate, Double.parseDouble(parkingValues[1]), parkingValues[2], parkingValues[3], parkingValues[4], parkingValues[5], parkingValues[6]);
			parkingViolations.add(currentParkingViolation);
		}
		return parkingViolations;
	}
	
}
