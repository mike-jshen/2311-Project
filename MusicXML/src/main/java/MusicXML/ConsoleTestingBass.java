package MusicXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsoleTestingBass {
	
	public static void main(String[] args) throws Exception {

		File file = new File("testTab.txt");
		BassFileScanner readFile = new BassFileScanner(file);

		ArrayList<String[]> staffs = readFile.getStaffs();
		BassKeys keys = new BassKeys(staffs.get(0));

		keys.getAllKeys();

		for (int i = 0; i < staffs.size(); i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(staffs.get(i)[j]);
			}
			System.out.println();
		}

		BassMeasures measures = new BassMeasures(staffs.get(0));

		for (int i = 0; i < measures.getBassMeasures().size(); i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(measures.getBassMeasures().get(i)[j]);
			}
			System.out.println();
		}

		BassNotes notes = new BassNotes(measures.getBassMeasures().get(0));

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

		BassXMLOut test = new BassXMLOut();
		test.convertToXML(file);
	}

}
