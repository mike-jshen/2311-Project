package MusicXML;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class DrumNotes {

	ArrayList<char[]> vertical = new ArrayList<char[]>();
	private Map<Pair<Integer, Integer>, List<Character>> map = new LinkedHashMap<Pair<Integer, Integer>, List<Character>>();
	private Map<Pair<Integer, Integer>, List<Character>> mapLow = new LinkedHashMap<Pair<Integer, Integer>, List<Character>>();// Pair<Index,
	// GuitarString>
	private String step = ""; // change this
	private int octave = -1; // change this
	private int size;

	public DrumNotes(List<String> singleMeasure) {
		size = singleMeasure.size();
		boolean sameLength = true;
		for (int i = 1; i < singleMeasure.size(); i++) {
			if (sameLength
					&& singleMeasure.get(i).toCharArray().length == singleMeasure.get(i - 1).toCharArray().length) {
				size = singleMeasure.get(i).toCharArray().length;
				sameLength = true;
			} else {
				sameLength = false;
			}
		}


		if (sameLength) {
			for (int i = 0; i < singleMeasure.size(); i++) {
				vertical.add(singleMeasure.get(i).toCharArray());
			}
		} else {
			System.out.println(">> Error: Some line(s) may longer or shorter than others. Please fix before converting.");
		}
	}

	public String getStep(String instr) {
		instr = instr.toUpperCase();

		if (instr.equals("CC") || instr.equals("C"))
			step = "A";
		else if (instr.equals("RC") || instr.equals("R"))
			step = "F";
		else if (instr.equals("HH"))
			step = "G";
		else if (instr.equals("SD"))
			step = "C";
		else if (instr.equals("HT"))
			step = "E";
		else if (instr.equals("MT"))
			step = "D";
		else if (instr.equals("FT"))
			step = "A";
		else if (instr.equals("BD") || instr.equals("KD") || instr.equals("B"))
			step = "F";
		else
			step = "Z"; // debug
		return step;
	}


	public int getOctave(String instr) {
		instr = instr.toUpperCase();

		if (instr.equals("CC") || instr.equals("C"))
			octave = 5;
		else if (instr.equals("RC") || instr.equals("R"))
			octave = 5;
		else if (instr.equals("HH"))
			octave = 5;
		else if (instr.equals("SD"))
			octave = 5;
		else if (instr.equals("HT"))
			octave = 5;
		else if (instr.equals("MT"))
			octave = 5;
		else if (instr.equals("FT"))
			octave = 4;
		else if (instr.equals("BD") || instr.equals("KD") || instr.equals("B"))
			octave = 4;
		else
			octave = -1;
		return octave;
	}

	public Map<Pair<Integer, Integer>, List<Character>> getNotesMapping() {
		boolean flam = false;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < vertical.size(); j++) {
				if (vertical.get(j)[i] == 'x' || vertical.get(j)[i] == 'X' || vertical.get(j)[i] == 'o') {

					if (j < vertical.size() - 1) {
						Pair<Integer, Integer> pair = new Pair<>(i, j);
						List<Character> currentValue = map.get(pair);
						if (currentValue == null) {
							currentValue = new ArrayList<Character>();
							map.put(pair, currentValue);
						}
						currentValue.add(vertical.get(j)[i]);
					}
				}
			}
		}
		return map;
	}

	public Map<Pair<Integer, Integer>, List<Character>> getNotesLowMapping() {
		boolean flam = false;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < vertical.size(); j++) {
				if (vertical.get(j)[i] == 'x' || vertical.get(j)[i] == 'X' || vertical.get(j)[i] == 'o') {

					if (j == vertical.size() - 1) {
						Pair<Integer, Integer> pair = new Pair<>(i, j);
						List<Character> currentValue = map.get(pair);
						if (currentValue == null) {
							currentValue = new ArrayList<Character>();
							mapLow.put(pair, currentValue);
						}
						currentValue.add(vertical.get(j)[i]);
					}
				}
			}
		}
		return mapLow;
	}

}
