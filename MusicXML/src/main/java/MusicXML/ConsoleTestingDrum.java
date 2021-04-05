package MusicXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.io.FileNotFoundException;
import javafx.util.Pair;

public class ConsoleTestingDrum {

	public static void main(String[] args) throws FileNotFoundException {

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
	}
}