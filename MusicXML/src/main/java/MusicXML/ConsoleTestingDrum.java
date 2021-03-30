package MusicXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
public class ConsoleTestingDrum {

	public static void main(String[] args) throws FileNotFoundException {
	
		File file = new File("testTab.txt");
		DrumFileScanner readFile = new DrumFileScanner(file);

		ArrayList<String[]> staffs = readFile.getDStaffs();
		DrumKeys keys = new DrumKeys(staffs.get(0));

		keys.getAllKeys();

		for (int i = 0; i < staffs.size(); i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println(staffs.get(i)[j]);
			}
			System.out.println();
		}

		Measures measures = new Measures(staffs.get(0));

		for (int i = 0; i < measures.getMeasures().size(); i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println(measures.getMeasures().get(i)[j]);
			}
			System.out.println();
		}
		
		DrumNotes notes = new DrumNotes(measures.getMeasures().get(2));

		Map<Integer, List<Character>> notesMap = notes.getNotesMapping();

		for (Map.Entry<Integer, List<Character>> entry : notesMap.entrySet()) {
			Integer index = entry.getKey();
			List<Character> value = entry.getValue();

			System.out.print("At index: " + index + " ");
			System.out.print("   Values: ");
			for (int i = 0; i < value.size(); i++) {
				System.out.print(value.get(i) + " ");
			}
			System.out.println();
		}

		GuitarXMLOut test = new GuitarXMLOut();
		test.convertToXML(file);
		
	}		
}
*/