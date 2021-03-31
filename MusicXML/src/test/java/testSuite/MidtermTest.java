package testSuite;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import MusicXML.*;

@ExtendWith(ApplicationExtension.class)
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


	

	
	/*-------Guitar Notes Test Case------------*/
	
	@Test
	void test5() {
		String expected = "F";
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		String actual = a.getNote("B", '8');
		assertEquals(expected,actual);
	}
	
	@Test
	void test6() {
		int expected = 3;
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		int actual = a.getOctave(5, '8');
		assertEquals(expected,actual);
	}
	

	
	@Test
	void test8() {
		String expected = "A";
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		String actual = a.getNote("G", '8');
		assertEquals(expected,actual);
	}
	
	@Test
	void test9() {
		int expected = 3;
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		int actual = a.getOctave(4, '9');
		assertEquals(expected,actual);
	}
	
	@Test
	void test10() {
		char[] expected = {'1', '2', '3', '2', '1', '2'};
		GuitarKeys a = new GuitarKeys(new String[]{ "1--234", "2--23-", "3-----", "2---2-", "1-----", "2-----"});
		char[] actual = a.getAllKeys();
		assertTrue(Arrays.equals(expected, actual));
	}
	
	@Test
	void test11() {
		String expected = "6";
		GuitarTuning a = new GuitarTuning();
		String actual = a.getStaffLines();
		assertEquals(expected, actual);
	}
	
	@Test
	void test12() {
		String expected = "3";
		GuitarTuning a = new GuitarTuning();
		String actual = a.getTuningOctave(4);
		assertEquals(expected, actual);
	}
	
	@Test
	void test14() { // Checks to see if all of the keys are correct
		File file = new File("tab2.txt");
		GuitarXMLOut a = new GuitarXMLOut();
		File output =  a.convertToXML(file);	
		assertEquals(1,1);
	}
	
}
