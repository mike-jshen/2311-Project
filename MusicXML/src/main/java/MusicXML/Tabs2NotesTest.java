package MusicXML;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class Tabs2NotesTest {

@Test
	
	public void notesTest() {
		
	Tabs2Notes noteTest = new Tabs2Notes();
	String expected = "E";
	String actual = noteTest.notes("E", '0');
	
	assertEquals(expected, actual);
	
	}
	
	@Test
	
	public void notesTest2() {
		
	Tabs2Notes noteTest = new Tabs2Notes();
	String expected = "F#";
	String actual = noteTest.notes("E", '2');
	
	assertEquals(expected, actual);
	
	}
	
	@Test
	
	public void notesTest3() {
		
	Tabs2Notes noteTest = new Tabs2Notes();
	String expected = "B";
	String actual = noteTest.notes("B", '0');
	
	assertEquals(expected, actual);
	
	}

}
