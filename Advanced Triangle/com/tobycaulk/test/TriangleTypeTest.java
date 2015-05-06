package com.tobycaulk.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tobycaulk.triangle.TriangleType;

public class TriangleTypeTest {

	@Test
	public void calculateEquilateral() {
		assertEquals("EQUILATERAL", TriangleType.calculate(1, 1, 1));
	}
	
	@Test 
	public void calculateIscosceles() {
		assertEquals("ISCOSCELES", TriangleType.calculate(1, 1, 2));
		assertEquals("ISCOSCELES", TriangleType.calculate(1, 2, 1));
		assertEquals("ISCOSCELES", TriangleType.calculate(2, 1, 1));
	}
	
	@Test
	public void calculateScalene() {
		assertEquals("SCALENE", TriangleType.calculate(0, 1, 2));
		assertEquals("SCALENE", TriangleType.calculate(2, 1, 0));
		assertEquals("SCALENE", TriangleType.calculate(0, 2, 1));
	}
}
