package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import edu.upenn.cit594.data.Fine;
import edu.upenn.cit594.data.ParkingViolation;
import edu.upenn.cit594.logging.UserInfoLogger;

public class ParkingViolationReaderCSV extends OpenPhillyFileReader {
	
	
	public static LinkedList<Fine> read(String fileName) {
		File parkingViolations = new File(fileName);
		UserInfoLogger.logStringAtThisTime(fileName);
		LinkedList<Fine> fines = new LinkedList<Fine>();
		Scanner parkingScanner = null;
		try {
			parkingScanner = new Scanner(parkingViolations);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (parkingScanner.hasNext()) {
			String parkingLine = parkingScanner.nextLine();
			String[] parkingValues = parkingLine.split(",");
			
			//check if the number of inputs is correct
			if (parkingValues.length != 7) {
				continue;
			}
			String zipcode = parkingValues[6];
			
			// make sure necessary data is not missing and is in the correct format
			if (isEmpty(zipcode) | isEmpty(parkingValues[1]) | !isNumeric(parkingValues[1]) | parkingValues[4].compareTo("PA") != 0) {
				continue;
			}
			zipcode = convertZipcode(zipcode);
			Double fineAmount = Double.parseDouble(parkingValues[1]);
			Fine fine = new Fine(fineAmount, zipcode);
			fines.add(fine);
		}
		return fines;
	}
	
	
}
