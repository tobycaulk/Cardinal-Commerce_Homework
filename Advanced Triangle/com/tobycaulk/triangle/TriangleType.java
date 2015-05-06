package com.tobycaulk.triangle;

/**
 * Class which takes in three floats, representing the sides of a triangle, 
 * and outputs what type of triangle it is.
 *
 * @author Toby
 * @version 1.0
 */

public class TriangleType {
	
	/* An enumeration which represents the different types of triangles based on their side lengths. */
	enum Type {
		
		/* Different types of triangles */
		EQUILATERAL(3, "EQUILATERAL"), ISCOSCELES(2, "ISCOSCELES"), SCALENE(0, "SCALENE"); 
		
		/* An integer which represents how many sides match in each specific triangle type */
		private int sides_matching;
		
		/* A string which represents the type of triangle */
		private String type;
		
		/**
		 * An enumeration which represents the different types of triangles based on their side lengths
		 * @param sides_matching How many sides match in this triangle type
		 * @param type The type of rectangle in a string format
		 */
		Type(int sides_matching, String type) {
			this.sides_matching = sides_matching;
			this.type = type;
		}
		
		/**
		 * Takes in the side lengths of a triangle, and returns a triangle type
		 * @param s1 The length of side 1
		 * @param s2 The length of side 2
		 * @param s3 The length of side 3
		 * @return {@link com.tobycaulk.triangle.TriangleType.Type}
		 */
		static Type getType(float s1, float s2, float s3) {
			/* Calculate how many sides match, given the three side lengths */
			int matching = calculateSideMatching(s1, s2, s3);
			
			/* Loop through the triangle types in the enumeration, and see if the number of 
			 * matching sides, stored in the matching integer, is the same as the number of sides in the triangle type.
			 * If so, return the triangle type */
			for(Type t : Type.values()) {
				if(t.sides_matching == matching) {
					return t;
				}
			}
			
			return null;
		}
		
		/**
		 * Calculates how many sides are matching using the passed in floats
		 * @param s1 The length of side 1
		 * @param s2 The length of side 2
		 * @param s3 The length of side 3
		 * @return integer representing the number of sides matching
		 */
		static int calculateSideMatching(float s1, float s2, float s3) {
			/* If s1 and s2 and s1 and s3 match, then all the sides match */
			if(s1 == s2 && s1 == s3) {
				return 3;
			
			/* Test each combination of sides for equality */
			} else if((s1 == s2 || s1 == s3) || (s2 == s1 || s2 == s3) || (s3 == s1 || s3 == s2)) {
				return 2;
			
			/* If both of the above comparative statements are false, then no sides match */
			} else {
				return 0;
			}
		}
	}

	/**
	 * Function which uses the {@link com.tobycaulk.triangle.TriangleType.Type} functions to determine what kind of triangle is
	 * represented by the three side lengths passed in
	 * @param s1 The length of side 1
	 * @param s2 The length of side 2
	 * @param s3 The length of side 3
	 * @return The name of the triangle type in a string format
	 */
	public static String calculate(float s1, float s2, float s3) {
		return Type.getType(s1, s2, s3).type;
	}
	
	/**
	 * Function which uses the {@link com.tobycaulk.triangle.TriangleType.Type} functions to determine what kind of triangle is
	 * represented by the three side lengths passed in
	 * @param sides Side lengths stored in an array of floats
	 * @return The name of the triangle type in a string format
	 */
	public static String calculate(float[] sides) {
		return calculate(sides[0], sides[1], sides[2]);
	}
}
