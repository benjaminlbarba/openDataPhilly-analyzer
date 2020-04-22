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

public class ParkingViolationReaderCSV {
	
	
	public static LinkedList<Fine> read(String fileName) {
		File parkingViolations = new File(fileName);
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
			System.out.println(parkingLine);
			if (parkingValues[6].compareTo("") != 0 & parkingValues[4].compareTo("PA") == 0) {
				Fine fine = new Fine(Double.parseDouble(parkingValues[1]), parkingValues[6]);
				fines.add(fine);
			} else {
				continue;
			}
		}
		return fines;
	}
	
}
