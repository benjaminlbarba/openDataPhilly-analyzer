package edu.upenn.cit594.datamanagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.upenn.cit594.data.Zipcode;

public class PopulationReader {

	public PopulationReader() {
		
	}
	
	//Arraylist for now but subject to change
	public ArrayList<Zipcode> read(String fileName) {
		File populationTextFile = new File(fileName);
		ArrayList<Zipcode> zipcodeAndPopulation = new ArrayList<Zipcode>();
		Scanner populationScanner = null;
		try {
			populationScanner = new Scanner(populationTextFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (populationScanner.hasNext()) {
			String populationLine = populationScanner.nextLine();
			String[] populationValues = populationLine.split(" ");
			Zipcode currentZipcode = new Zipcode(populationValues[0], Integer.parseInt(populationValues[1]));
			System.out.println(populationValues[0]);
			System.out.println(populationValues[1]);
			zipcodeAndPopulation.add(currentZipcode);
		}
		return zipcodeAndPopulation;
 	}
	
}
