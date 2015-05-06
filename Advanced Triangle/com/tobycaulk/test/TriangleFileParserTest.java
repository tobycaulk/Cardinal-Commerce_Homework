package com.tobycaulk.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.tobycaulk.triangle.TriangleFileParser;

public class TriangleFileParserTest {

	@Test
	public void testFileLoading() {
		assertTrue(Arrays.equals(new float[] { 1, 2, 3 }, TriangleFileParser.read("triangleData.txt")));
	}
}
