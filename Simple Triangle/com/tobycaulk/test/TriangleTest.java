package com.tobycaulk.triangle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

import java.util.Arrays;

public class TriangleTest {
	
	Triangle triangle;
	
	@Before
	public void initialize() {
		triangle = new Triangle();
	}
	
	@Test 
	public void calculateEquilateral() {
		assertEquals("EQUILATERAL", triangle.determineTriangleType(1, 1, 1));
	}
	
	@Test 
	public void calculateIscosceles() {
		assertEquals("ISCOSCELES", triangle.determineTriangleType(1, 1, 2));
		assertEquals("ISCOSCELES", triangle.determineTriangleType(1, 2, 1));
		assertEquals("ISCOSCELES", triangle.determineTriangleType(2, 1, 1));
	}
	
	@Test
	public void calculateScalene() {
		assertEquals("SCALENE", triangle.determineTriangleType(0, 1, 2));
		assertEquals("SCALENE", triangle.determineTriangleType(2, 1, 0));
		assertEquals("SCALENE", triangle.determineTriangleType(0, 2, 1));
	}	
	
	@Test
	public void parseFileTest() {
		assertTrue(Arrays.equals(new float[] { 1, 2, 3 }, triangle.parseFile("triangleData.txt")));
	}
}