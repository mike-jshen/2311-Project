package testSuite;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MusicXML.FileScanner;

class FileScannerTest {

	
	private File file;
	private FileScanner testFile;
	
	@BeforeEach
	void setUp() {
		file = new File("tab1.txt");
		testFile = new FileScanner(file);
	}
	
	@Test
	void testKeyFinder() {
		assertEquals('E', testFile.KeyFinder(0));
		assertEquals('B', testFile.KeyFinder(1));
		assertEquals('G', testFile.KeyFinder(2));
		assertEquals('D', testFile.KeyFinder(3));
		assertEquals('A', testFile.KeyFinder(4));
		assertEquals('D', testFile.KeyFinder(5));
	}
	
	@Test
	void testSpaceCounter() {
		int expected = 26;
		int actual = testFile.SpaceCounter(0);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetMeasures() {
		String[] expected = new String[6];
		expected[0] = "--0-----------------------";
		expected[1] = "------------------3-----5-";
		expected[2] = "------------------3-------";
		expected[3] = "------------------5-------";
		expected[4] = "--------------------------";
		expected[5] = "--------------------------";
		String[] actual = testFile.getMeasures().get(0);
		assertTrue(Arrays.equals(expected, actual));
		
	}

}
