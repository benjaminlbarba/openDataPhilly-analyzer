package edu.upenn.cit594.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Basic logging functionality
 * @author benjamin.barbaimbellus
 *
 */
public class Logger {
	private static FileWriter fw;
	private static PrintWriter pw;

	/**
	 * provides a way to access and set the file that is being written to by log
	 * @param fileNameParam
	 */
	public static void initFileName(String fileNameParam) {
		//System.out.println("initFileName = " + fileNameParam);
		try {
			fw = new FileWriter(fileNameParam, false);
			pw = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// private constructor
	private Logger(String fileNameParam) {
		initFileName(fileNameParam);
	}
	
	//singleton instance
	private static Logger instance = new Logger("log.txt");
	
	//singleton accessor method
	public static Logger getInstance() {
		return instance;
	}
	
	public void log(String msg) {
		//System.out.println("logging... " + msg);
		pw.println(msg);
	}
	
	public void end() {
		pw.flush();
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.close();
	}
	
}
