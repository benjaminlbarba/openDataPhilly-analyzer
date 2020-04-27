package edu.upenn.cit594.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * This class contains the log implemented with the singleton desgin patter, so there is only one instance
 * of the class.
 * @author benjamin.barbaimbellus
 *
 */
public class Logger {
	private FileWriter fw;
	private PrintWriter pw;
	
	private Logger() {
	}
	
	//singleton instance of the logger
	private static Logger instance = new Logger();

	/**
	 * provides a way to access and set the file that is being written to by log
	 * @param fileNameParam
	 */
	public void initFileName(String fileNameParam) {
		//System.out.println("initFileName = " + fileNameParam);
		try {
			fw = new FileWriter(fileNameParam, false);
			pw = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block

		}
	}
	
	/*
	 * Allows the user to access the only instance of logger
	 */
	public static Logger getInstance() {
		return instance;
	}
	
	/*
	 * Logs a string to the log file.
	 */
	public void log(String msg) {
		pw.println(msg);
		pw.flush();
	}
	
	/*
	 * This method is called once the program is about to exit. It flushes and closes the printwriter.
	 */
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
