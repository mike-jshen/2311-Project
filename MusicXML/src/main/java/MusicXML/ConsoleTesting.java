package MusicXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

import java.io.File;

//Not all of the above are needed, they are there just in case.

public class ConsoleTesting {

	public static void main(String[] args) throws Exception {

		File file = new File("testTab.txt");
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

		Measures measures = new Measures(staffs.get(0));

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
		test.convertToXML(file);
	}
}
