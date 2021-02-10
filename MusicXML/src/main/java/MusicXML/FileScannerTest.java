package MusicXML;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Arrays;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;


class FileScannerTest {

	

	
	private File fileTest = new File("tab1.txt");
	private FileScanner test;
	
	
	@BeforeEach
	void setUp() {
		
		fileTest = new File("tab1.txt");
		test = new FileScanner(fileTest);
	}
	
	@Test
	void keyFinderTest() {
		
		char testKey = 'E';
		char actual = test.KeyFinder(0);
		
		assertEquals(testKey, actual);
	}
	
	
	@Test
	void GetMeasureTest() {
		
		String[] expected = new String[6];
		expected[0] = "-------------------------";
		expected[1] = "-2-----------------------";
		expected[2] = "-2-----------------------";
		expected[3] = "-2-----------------------";
		expected[4] = "-0-----------------------";
		expected[5] = "-------------------------";
		String[] actual = test.getMeasures().get(1);
		System.out.println(actual[1]);
		assertTrue(Arrays.equals(expected, actual));
		
		
	}
	
	
	

}
