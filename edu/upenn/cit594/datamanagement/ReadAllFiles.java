package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.data.DataStorage;

/*
 * This class calls all the readers to read in the files at once. It also call the correct reader depending on
 * if the input file is a csv or json.
 */
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
