package com.tobycaulk.triangle;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;

import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;

/**
* A program which takes in three floating point numbers, representing the side lengths, and outputs the 
* kind of triangle it is (scalene, isosceles, or equilateral). Side lengths can be read from the 
* console input or through the contents of a file. 
*
* @author Toby Caulk
*/

public class Triangle {

	static String mIOError = "Invalid number of side lengths specified. If you are trying to input data using a file, check to make sure the "
					       + "data is stored in this format: x y z. If you are inputting data through the console, check to make sure you "
					       + "have specified enough values in the correct number format";
	
	/**
	* Controls the main logic in the program
	* @param args Arguments passed in from the command line
	*/
	void calculate(String[] args) {
		/* The array used to hold the side lengths of the triangle */
		float[] sides = null;
		
		/* Determine where the side lengths are being read from */
		if(args.length == 1) {
			/* Loading from a file */
			sides = parseFile(args[0]);
		} else if(args.length == 3) {
			/* Loading from the arguments passed in from the command line.
			Convert the strings in the arguments array to floating point numbers, and then 
			add them to the sides array */
			sides = parseArguments(Arrays.copyOfRange(args, 0, 3));
		} else {
			exitIOError();
		}	
		
		/* Check to see if any of the side lengths in the array are 0, if so exit the program */
		for(float s : sides) {
			if(s <= 0) {
				exitIOError();
			}
		}	
		
		/* Determine what kind of triangle is represented by the side lengths */
		System.out.println("Triangle data: " + sides[0] + " " + sides[1] + " " + sides[2] + " : " + determineTriangleType(sides));
	}
	
	/**
	* Determines what kind of triangle the sides represent
	* @param sides Array of floating point numbers containing the side lengths
	*/
	String determineTriangleType(float[] sides) {
		/* Three sides stored in floating point variables */
		float s1 = sides[0];
		float s2 = sides[1];
		float s3 = sides[2];
		
		/* If s1 equals s2 and s3, then all sides match */
		if(s1 == s2 && s1 == s3) {
			return "EQUILATERAL";
		
		/* If only one side matches another side, then only two sides match */
		} else if((s1 == s2 || s1 == s3) || (s2 == s1 || s2 == s3) || (s3 == s1 || s3 == s2)) {
			return "ISCOSCELES";
			
		/* If the above comparative statements are false, then the triangle has no matching sides */
		} else {
			return "SCALENE";
		}
	}
	
	/**
	* Determines what kind of triangle the sides represent 
	* @param s1 Side 1 
	* @param s2 Side 2
	* @param s3 Side 3
	*/
	String determineTriangleType(float s1, float s2, float s3) {
		return determineTriangleType(new float[] { s1, s2, s3 });
	}
	
	/**
	* Extracts the side lengths from the passed in arguments array
	* @param args The array containing the arguments passed in from the command line/terminal
	*/
	float[] parseArguments(String[] args) {
		float[] sides = new float[3];
		
		/* Convert the String array to a float array */
		sides = stringToFloatArray(args, sides);
		
		/* Check to make sure the float array is properly populated */
		if(sides == null || sides.length != 3) {
			exitIOError();
		}
		
		return sides;
	}
	
	/**
	* Parses triangle data from a file in the following format: x y z 
	* Where each lowercase letter is a valid number
	* @param path The path to the file containing the data
	*/
	float[] parseFile(String path) {
		float[] sides = null;
		File triangleDataFile = new File(path);
			
		/* String which contains the contents of the file */
		String content = null;
			
		try {
			/* Reading the contents of the file to the string using the default platform encoding */
			content = FileUtils.readFileToString(triangleDataFile, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		/* Split the content by the spaces between the numbers */
		String[] splitContent = content.split(" ");
			
		/* Convert the strings to floating point numbers, and add them to the sides array */
		sides = new float[3];
		sides = stringToFloatArray(splitContent, sides);
		
		/* Check to make sure the float array is properly populated */
		if(sides == null || sides.length != 3) {
			exitIOError();
		}
		
		return sides;
	}
	
	/**
	* Converts a String array to a floating point number array
	* @param sa Array containing the strings
	* @param fa Array containing the floating point numbers
	*/
	float[] stringToFloatArray(String[] sa, float[] fa) {
		int i = 0; 
		for(String s : sa) {
			fa[i++] = Float.parseFloat(s);
		}
		
		return fa;
	}
	
	/**
	* Prints out an error message, and then exits the system with a non-zero value
	*/
	static void exitIOError() {
		System.err.println(mIOError);
		System.exit(1);
	}
	
	public static void main(String[] args) {
		new Triangle().calculate(args);
	}
}