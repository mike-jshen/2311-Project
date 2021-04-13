package testSuite;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import MusicXML.*;
import javafx.util.Pair;

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

	/*--------------------- Bass Duration Test Case ----------------------*/
	
	@Test
	void test2() {
		int expected = 1;
		BassDuration n = new BassDuration();
		int actual = n.timeDuration(1, 8);
		assertEquals(expected,actual);
	}
	
	@Test
	void test2a() {
		int expected = 2;
		BassDuration n = new BassDuration();
		int actual = n.timeDuration(2, 8);
		assertEquals(expected,actual);
	}
	
	@Test
	void test2b() {
		int expected = 3;
		BassDuration n = new BassDuration();
		int actual = n.timeDuration(3, 8);
		assertEquals(expected,actual);
	}
	
	@Test
	void test2c() {
		int expected = 8;
		BassDuration n = new BassDuration();
		int actual = n.timeDuration(8, 8);
		assertEquals(expected,actual);
	}
	
	@Test
	void test3() {
		String expected = "eighth";
		BassDuration n = new BassDuration();
		String actual = n.getType(1);
		assertEquals(expected, actual);
	}
	
	@Test
	void test3a() {
		String expected = "half";
		BassDuration n = new BassDuration();
		String actual = n.getType(6);
		assertEquals(expected, actual);
	}
	
	@Test
	void test3b() {
		String expected = "whole";
		BassDuration n = new BassDuration();
		String actual = n.getType(8);
		assertEquals(expected, actual);
	}
	
	@Test
	void test4() {
		boolean expected = true;
		BassDuration n = new BassDuration();
		boolean actual = n.isDot(6);
		assertEquals(expected, actual);
	}
	
	@Test
	void test4a() {
		boolean expected = false;
		BassDuration n = new BassDuration();
		boolean actual = n.isDot(9);
		assertEquals(expected, actual);
	}
	
	/*------------------ Guitar Notes Test Case ------------------*/
	
	@Test
	void test5() {
		String expected = "F";
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		String actual = a.getNote("B", 8);
		assertEquals(expected,actual);
	}
	
	@Test
	void test6() {
		int expected = 3;
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		int actual = a.getOctave(5, 8);
		assertEquals(expected,actual);
	}
	
	@Test
	void test6a() {
		int expected = 3;
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		int actual = a.getOctave(4, 12);
		assertEquals(expected,actual);
	}
	
	@Test
	void test6b() {
		int expected = 4;
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		int actual = a.getOctave(3, 11);
		assertEquals(expected,actual);
	}
	
	@Test
	void test8() {
		String expected = "A";
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		String actual = a.getNote("G", 8);
		assertEquals(expected,actual);
	}
	
	@Test
	void test9() {
		int expected = -1;
		GuitarNotes a = new GuitarNotes(new String[]{ "1", "-", "-", "2", "-", "-"});
		int actual = a.getOctave(3, 15);
		assertEquals(expected,actual);
	}
	
	@Test
	void test10() {
		char[] expected = {'1', '2', '3', '2', '1', '2'};
		GuitarKeys a = new GuitarKeys(new String[]{ "1--234", "2--23-", "3-----", "2---2-", "1-----", "2-----"});
		char[] actual = a.getAllKeys();
		assertTrue(Arrays.equals(expected, actual));
	}
	
	/*--------------------------- Guitar Tuning Test Case --------------------------*/
	
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
	
	/*--------------------------- Guitar XML Out Test Case ---------------------------*/
	
	@Test
	void test14() { // Checks to see if all of the keys are correct
		File file = new File("tab2.txt");
		GuitarXMLOut a = new GuitarXMLOut();
		File output =  a.convertToXML(file);
		assertTrue(output != null);
	}
	
	/*---------------------------- Bass File Scanner Test Case --------------------------------*/
	
	@Test
	void test15() {
		File file = new File("bass.txt");
		BassFileScanner n = new BassFileScanner(file);
		ArrayList<String[]> a = n.getStaffs();
		assertTrue(a != null);
	}
	
	/*---------------------------- Complete Bass Tabs Testing ----------------------------*/
	
	@Test
	void test16() {
		File file = new File("sampleBass.txt");
		BassFileScanner readFile = new BassFileScanner(file);
		ArrayList<String[]> staffs = readFile.getStaffs();
		BassKeys keys = new BassKeys(staffs.get(0));
		keys.getAllKeys();
		for (int i = 0; i < staffs.size(); i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(staffs.get(i)[j]);
			}
		}
		BassMeasures measures = new BassMeasures(staffs.get(0));
		for (int i = 0; i < measures.getMeasures().size(); i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(measures.getMeasures().get(i)[j]);
			}
		}
		BassNotes notes = new BassNotes(measures.getMeasures().get(0));
		Map<Pair<Integer, Integer>, List<Integer>> notesMap = notes.getNotesMapping();
		for (Entry<Pair<Integer, Integer>, List<Integer>> entry : notesMap.entrySet()) {
			Integer index = entry.getKey().getKey();
			List<Integer> value = entry.getValue();
			for (int i = 0; i < value.size(); i++) {
				value.get(i);
				notes.getOctave(entry.getKey().getValue(), value.get(i));
			}
		}
		BassXMLOut test = new BassXMLOut();
		assertTrue(test.convertToXML(file) != null);
	}
	
	/*------------------------ Complete Drum Testing ---------------------------*/
	
	@Test
	void test17() {
		File file = new File("sampleDrums.txt");
		DrumFileScanner readFile = new DrumFileScanner(file);
		ArrayList<List<String>> staffs = readFile.getDrumStaffs();
		for (int i = 0; i < staffs.size(); i++) {
			for (int j = 0; j < staffs.get(i).size(); j++) {
				System.out.println(staffs.get(i).get(j));
			}
			System.out.println();
		}
		DrumMeasures measures = new DrumMeasures(staffs.get(0));
		for (int i = 0; i < measures.getMeasures().size(); i++) {
			for (int j = 0; j < measures.getMeasures().get(i).size(); j++) {
				System.out.println(measures.getMeasures().get(i).get(j));
			}
			System.out.println();
		}
		DrumInstrument instruments = new DrumInstrument(staffs.get(1));
		for (int i = 0; i < instruments.getAllInstr().length; i++) {
			System.out.println(instruments.getAllInstr()[i]);
		}
		DrumNotes notes = new DrumNotes(measures.getMeasures().get(0));
		System.out.println();
		System.out.println("Testing constant [vertical.size()]: " + notes.vertical.size());
		System.out.println();
		Map<Pair<Integer, Integer>, List<Character>> notesMap = notes.getNotesMapping();
		for (Entry<Pair<Integer, Integer>, List<Character>> entry : notesMap.entrySet()) {
			Integer index = entry.getKey().getKey();
			Integer gString = entry.getKey().getValue();
			List<Character> value = entry.getValue();

			System.out.print("At index: " + index + " ");
			System.out.print("At string: " + gString + " ");
			System.out.print("   Values: ");
			for (int i = 0; i < value.size(); i++) {
				System.out.print(value.get(i) + " ");
			}
			System.out.println();
		}
		DrumDuration dur = new DrumDuration(notes.getNotesMapping(), measures.getMeasureSpaces(measures.getMeasures().get(0)));
		DrumDuration dur2 = new DrumDuration(notes.getNotesLowMapping(), measures.getMeasureSpaces(measures.getMeasures().get(0)));
		DrumXMLOut n = new DrumXMLOut();
		File out = n.convertToXML(file);
		assertTrue(dur != null && dur2 != null && out != null);
	}
	
	/*----------------------- Instrument Detection Test Case -----------------------*/
	
	@Test
	void test18() {
		File file = new File("bass.txt");	
		InstrumentDetection detect = new InstrumentDetection(file);
		assertTrue(detect.getDetectedInstrument() != null);
	}
	
	/*------------------------ Complete Guitar Test Case ---------------------------*/
	
	@Test
	void test19() {
		File file = new File("sampleGuitar.txt");	
		GuitarFileScanner readFile = new GuitarFileScanner(file);

		ArrayList<String[]> staffs = readFile.getStaffs();
		GuitarKeys keys = new GuitarKeys(staffs.get(0));

		keys.getAllKeys();

		for (int i = 0; i < staffs.size(); i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println(staffs.get(i)[j]);
			}
			System.out.println();
		}

		GuitarMeasures measures = new GuitarMeasures(staffs.get(0));

		for (int i = 0; i < measures.getMeasures().size(); i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println(measures.getMeasures().get(i)[j]);
			}
			System.out.println();
		}

		GuitarNotes notes = new GuitarNotes(measures.getMeasures().get(0));

		Map<Pair<Integer, Integer>, List<Integer>> notesMap = notes.getNotesMapping();

		for (Map.Entry<Pair<Integer, Integer>, List<Integer>> entry : notesMap.entrySet()) {
			Integer index = entry.getKey().getKey();
			Integer gString = entry.getKey().getValue();
			List<Integer> value = entry.getValue();

			System.out.print("At index: " + index + " ");
			System.out.print("At string: " + gString + " ");
			System.out.print("   Values: ");
			for (int i = 0; i < value.size(); i++) {
				System.out.print(value.get(i) + " ");
			}
			System.out.println();
		}

		GuitarXMLOut test = new GuitarXMLOut();
		assertTrue(test.convertToXML(file) != null);
	}
	
	/*------------------------------ Drum Voice Testing --------------------------------*/
	
	@Test
	void test20() {
		int expected = 2;
		DrumVoice n = new DrumVoice();
		int actual = n.FindVoiceValue(7, new int[]{0,0,0,0,0,0,0,8,1,2});
		assertEquals(expected, actual);
	}
	

}
