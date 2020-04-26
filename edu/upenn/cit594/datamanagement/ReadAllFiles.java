package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.DataStorage;

public class ReadAllFiles {
	
	
	public static void read(String fileNameParkingViolation, String fileNameProperty, String fileNamePopulation, String fileType) {
		DataStorage.population = PopulationReader.read(fileNamePopulation);
		DataStorage.properties = PropertiesReader.read(fileNameProperty);
		if (fileType.equalsIgnoreCase("json")) {
			DataStorage.fines = ParkingViolationReaderJSON.read(fileNameParkingViolation);
		}
		if (fileType.equalsIgnoreCase("csv")) {
			DataStorage.fines = ParkingViolationReaderCSV.read(fileNameParkingViolation);
		}
	}

}
