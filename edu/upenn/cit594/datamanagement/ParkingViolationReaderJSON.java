package edu.upenn.cit594.datamanagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import edu.upenn.cit594.data.Fine;

public class ParkingViolationReaderJSON {
	
	public static LinkedList<Fine> read(String fileName) {
		LinkedList<Fine> fines = new LinkedList<Fine>();
		JSONParser parser = new JSONParser();
		JSONArray parkingViolations = null;
		try {
			parkingViolations = (JSONArray) parser.parse(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator iter = parkingViolations.iterator();
		while (iter.hasNext()) {
			JSONObject parkingViolation = (JSONObject) iter.next();
			Fine fine = new Fine((Double) parkingViolation.get("fine"),(String) parkingViolation.get("zip-code"));
			fines.add(fine);
		}
		return fines;
	}
	

}

