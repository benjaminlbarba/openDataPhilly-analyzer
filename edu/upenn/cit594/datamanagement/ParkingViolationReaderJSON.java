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
import edu.upenn.cit594.logging.UserInfoLogger;

/*
 * This class reads in the parking data set. It extends the abstract class OpenPhillyFileReader.
 * It's only method, read, returns a linkedlist containing the data filtered for wrong or missing information.
 */
public class ParkingViolationReaderJSON extends OpenPhillyFileReader{
	

	public static LinkedList<Fine> read(String fileName) {
		LinkedList<Fine> fines = new LinkedList<Fine>();
		JSONParser parser = new JSONParser();
		JSONArray parkingViolations = null;
		try {
			parkingViolations = (JSONArray) parser.parse(new FileReader(fileName));
			UserInfoLogger.logStringAtThisTime(fileName);
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
			Long fineAmount = (Long) parkingViolation.get("fine");
			String zipcode = (String) parkingViolation.get("zip_code");
			String state = (String) parkingViolation.get("state");

			// make sure necessary data is not missing and is in the correct format
			if (isEmpty(zipcode) | isEmptyLong(fineAmount)| state.compareTo("PA") != 0) {
				continue;
			}
			
			zipcode = convertZipcode(zipcode);
			Double fineAmountDouble = fineAmount.doubleValue();
			Fine fine = new Fine(fineAmountDouble,zipcode);
			fines.add(fine);
		}
		return fines;
	}
	


}

