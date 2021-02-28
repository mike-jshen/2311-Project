package testSuite;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.*;
import MusicXML.*;

class MidtermTest {

	@Test
	void test1() { // Checks to see if all of the keys are correct
		char[] expected = {'E','A','D','G','B','E'};
		File file = new File("tab2.txt");
		GuitarFileScanner readfile = new GuitarFileScanner(file);
		ArrayList<String[]> staffs = readfile.getStaffs();
		GuitarKeys keys = new GuitarKeys(staffs.get(0));		
		assertTrue(Arrays.equals(expected,keys.getAllKeys()));
	}

	@Test
	void test2() { // Checks to see if the appropriate amount of measures are in the tab
		int expected = 5;
		File file = new File("tab2.txt");
		GuitarFileScanner readfile = new GuitarFileScanner(file);
		ArrayList<String[]> staffs = readfile.getStaffs();
		Measures measures = new Measures(staffs.get(0));
		int result = measures.getNumOfMeasures(staffs.get(0));
		assertEquals(expected,result);
	}
	
	@Test
	void test3() {  // Checks to see the measure spaces (Including the horizontal lines in between excluding the horizontal lines at the very beginning/end)
		int expected = 134;
		File file = new File("tab2.txt");
		GuitarFileScanner readfile = new GuitarFileScanner(file);
		ArrayList<String[]> staffs = readfile.getStaffs();
		Measures measures = new Measures(staffs.get(0));
		int result = measures.getMeasureSpaces(staffs.get(0));
		assertEquals(expected,result);
	}
	
	@Test
	void test4() { // Checks to see if there are any altered chords
		int expected = 0;
		File file = new File("tab2.txt");
		GuitarFileScanner readfile = new GuitarFileScanner(file);
		ArrayList<String[]> staffs = readfile.getStaffs();
		Measures measures = new Measures(staffs.get(0));
		GuitarNotes notes = new GuitarNotes(measures.getMeasures().get(0));
		int result = notes.getAlter();
		assertEquals(expected, result);
	}
}
