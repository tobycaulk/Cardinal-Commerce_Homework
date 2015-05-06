package com.tobycaulk.triangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Takes in a file path represented as a string, reads and strips the file of
 * numbers and then returns them as an array.
 * 
 * @author Toby Caulk
 * @version 0.1
 */

public class TriangleFileParser {

	/**
	 * Reads a file, parses the data, and then returns an array the data for
	 * shape calculation. The file should contain the data in this format: x y z
	 * 
	 * @param path
	 *            The path to the file which contains the data
	 * @return int[] An array representing the stripped data
	 */
	public static float[] read(String path) {
		/* The array which will contain the triangle data, and then be returned */
		float[] triangleData = new float[3];
				
		try {
			/* Construct a new file based on the path passed in */
			File triangleDataFile = new File(path);
			
			/* Check to see if this is a valid file */
			if (triangleDataFile.isFile()) {
				/* Read the data into a String object */
				String line = null;
				try (BufferedReader br = new BufferedReader(new FileReader(triangleDataFile))) {
					line = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				/* Split the string into numbers by stripping away the spaces between each number, then place them into an array */
				String[] lineData = line.split(" ");
				int i = 0;
				for(String s : lineData) {
					triangleData[i++] = Float.parseFloat(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return triangleData;
	}
}