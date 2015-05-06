package com.tobycaulk.triangle;

import java.util.Arrays;

/**
* A program which takes in three floating point numbers, representing the side lengths, and outputs the 
* kind of triangle it is (scalene, isosceles, or equilateral). Side lengths can be read from the 
* console input or through the contents of a file. 
*
* @author Toby Caulk
* @version 0.1
*/

public class Triangle {

	static String mIOError = "Invalid number of side lengths specified. If you are trying to input data using a file, check to make sure the "
						   + "data is stored in this format: x y z. If you are inputting data through the console, check to make sure you "
						   + "have specified enough values in the correct number format";

	static void exitIOError() {
		System.err.println(mIOError);
		System.exit(1);
	}

	public static void main(String[] args) {
		/* Array of floats which will be populated with values that represent the side lengths */
		float[] sides = null;
		/* Determine if we are reading out of a file, or the console input */
		if(args.length == 1) {
			/* Reading in from a file. Extract values and place them in the float array */
			sides = TriangleFileParser.read(args[0]);
		} else if(args.length == 3) {
			/* Reading the console input */
			sides = new float[3];
			int i = 0;
			for(String s : args) {
				sides[i++] = Float.parseFloat(s);
			}
		} else {
			/* Not enough arguments specified */
			exitIOError();
		}
		
		/* Check to make sure the float array is populated */
		if(sides == null || sides.length != 3) {
			/* The float array does not contain the necessary values to continue on, exit the program and inform the user */
			exitIOError();
		}
		
		/* Check for non-positive values */
		for(float s : sides) {
			if(s <= 0) {
				exitIOError();
			}
		}
		
		/* Determine what kind of triangle is represented by the values, and print the result to the console */
		System.out.println("Triangle data: " + sides[0] + " " + sides[1] + " " + sides[2] + " : " + TriangleType.calculate(sides));
	}
}