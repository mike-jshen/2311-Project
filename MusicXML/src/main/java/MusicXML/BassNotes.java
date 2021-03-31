package MusicXML;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class BassNotes {

	ArrayList<char[]> vertical = new ArrayList<char[]>();
	private String note = "";
	private Map<Pair<Integer, Integer>, List<Integer>> map = new LinkedHashMap<Pair<Integer, Integer>, List<Integer>>(); // Pair<Index,
																															// BassString>
	private int alter;
	private int octave;

	public BassNotes(String[] singleMeasure) {

		char[] singleMeasure0 = singleMeasure[0].toCharArray();
		char[] singleMeasure1 = singleMeasure[1].toCharArray();
		char[] singleMeasure2 = singleMeasure[2].toCharArray();
		char[] singleMeasure3 = singleMeasure[3].toCharArray();

		if (singleMeasure0.length == singleMeasure1.length && singleMeasure1.length == singleMeasure2.length
				&& singleMeasure2.length == singleMeasure3.length) {
			for (int i = 0; i < singleMeasure0.length; i++) {
				char[] tmp = { singleMeasure0[i], singleMeasure1[i], singleMeasure2[i], singleMeasure3[i] };
				vertical.add(tmp);
			}
		} else {
			System.out.println(
					">> Error: Some line(s) may longer or shorter than others. This should be fixed before converting.");
		}
	}

	public String getNote(String gString, int tab) {
		if (gString.equals("E")) {
			if (tab == 0)
				note = "E";
			else if (tab == 1)
				note = "F";
			else if (tab == 2)
				note = "F"; // sharp
			else if (tab == 3)
				note = "G";
			else if (tab == 4)
				note = "G"; // sharp
			else if (tab == 5)
				note = "A";
			else if (tab == 6)
				note = "A"; // sharp
			else if (tab == 7)
				note = "B";
			else if (tab == 8)
				note = "C";
			else if (tab == 9)
				note = "C"; // sharp
			else if (tab == 10)
				note = "D";
			else if (tab == 11)
				note = "D"; // sharp
			else if (tab == 12)
				note = "E";
		}

		else if (gString.equals("A")) {
			if (tab == 0)
				note = "B";
			else if (tab == 1)
				note = "C";
			else if (tab == 2)
				note = "C"; // sharp
			else if (tab == 3)
				note = "D";
			else if (tab == 4)
				note = "D"; // sharp
			else if (tab == 5)
				note = "E";
			else if (tab == 6)
				note = "F";
			else if (tab == 7)
				note = "F"; // sharp
			else if (tab == 8)
				note = "G";
			else if (tab == 9)
				note = "G"; // sharp
			else if (tab == 10)
				note = "G";
			else if (tab == 11)
				note = "G"; // sharp
			else if (tab == 12)
				note = "A";
		}

		else if (gString.equals("D")) {
			if (tab == 0)
				note = "G";
			else if (tab == 1)
				note = "G";
			else if (tab == 2)
				note = "A";
			else if (tab == 3)
				note = "A";
			else if (tab == 4)
				note = "B";
			else if (tab == 5)
				note = "C";
			else if (tab == 6)
				note = "C";
			else if (tab == 7)
				note = "D";
			else if (tab == 8)
				note = "D";
			else if (tab == 9)
				note = "E";
			else if (tab == 10)
				note = "C";
			else if (tab == 11)
				note = "C"; // sharp
			else if (tab == 12)
				note = "D";
		}

		else if (gString.equals("G")) {
			if (tab == 0)
				note = "D";
			else if (tab == 1)
				note = "D";
			else if (tab == 2)
				note = "E";
			else if (tab == 3)
				note = "F";
			else if (tab == 4)
				note = "F";
			else if (tab == 5)
				note = "G";
			else if (tab == 6)
				note = "G";
			else if (tab == 7)
				note = "A";
			else if (tab == 8)
				note = "A";
			else if (tab == 9)
				note = "B";
			else if (tab == 10)
				note = "F";
			else if (tab == 11)
				note = "F"; // sharp
			else if (tab == 12)
				note = "G";
		}
		return note;
	}

	public int getOctave(int gStrIndex, int tab) {
		if (gStrIndex == 0) {
			switch (tab) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				octave = 2;
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				octave = 3;
				break;
			default:
				octave = -1; // for debugging
			}
		} else if (gStrIndex == 1) {
			switch (tab) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				octave = 2;
				break;
			case 10:
			case 11:
			case 12:
				octave = 3;
				break;
			default:
				octave = -1; // for debugging
			}
		} else if (gStrIndex == 2) {
			switch (tab) {
			case 0:
			case 1:
			case 2:
				octave = 1;
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				octave = 2;
				break;
			default:
				octave = -1; // for debugging
			}
		} else if (gStrIndex == 3) {
			switch (tab) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				octave = 1;
				break;
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				octave = 2;
				break;
			default:
				octave = -1; // for debugging
			}
		}
		return octave;
	}

	public Map<Pair<Integer, Integer>, List<Integer>> getNotesMapping() {
		boolean grace = false;

		for (int i = 0; i < vertical.size(); i++) {
			for (int j = 0; j < 4; j++) {
				if (Character.isDigit(vertical.get(i)[j])) {
					if (i < vertical.size() - 1 && Character.isDigit(vertical.get(i + 1)[j])) {
						String tmp = "";
						tmp = tmp.concat(Character.toString(vertical.get(i)[j]))
								+ Character.toString(vertical.get(i + 1)[j]);
						int charstoInt = Integer.parseInt(tmp);
						int modInt = charstoInt;
						int hammerNote = -1;
						if (grace) {
							// move pair mapping back by one index (when 'g' occurs)
							Pair<Integer, Integer> pair = new Pair<>(i - 1, j);
							List<Integer> currentValue = map.get(pair);
							if (currentValue == null) {
								currentValue = new ArrayList<Integer>();
								map.put(pair, currentValue);
							}

							modInt = modInt + 100;
							currentValue.add(modInt);
							if (i < vertical.size() - 1) {
								hammerNote = vertical.get(i + 3)[j] - '0';
								currentValue.add(hammerNote);
							}
							grace = false;
						} else {
							Pair<Integer, Integer> pair = new Pair<>(i, j);
							List<Integer> currentValue = map.get(pair);
							if (currentValue == null) {
								currentValue = new ArrayList<Integer>();
								map.put(pair, currentValue);
							}
							currentValue.add(modInt);
						}

						if (i > 0 && (vertical.get(i - 1)[j] == 'h' || vertical.get(i - 1)[j] == 'p'
								|| vertical.get(i - 1)[j] == 's')) {
							Pair<Integer, Integer> pair = new Pair<>(i, j);
							map.remove(pair);
						}

					} else {
						if (i > 0 && Character.isDigit(vertical.get(i - 1)[j])) {
							continue;
						} else {
							int modInt = vertical.get(i)[j] - '0';
							int hammerNote = -1;
							if (grace) {
								// move pair mapping back by one index (when 'g' occurs)
								Pair<Integer, Integer> pair = new Pair<>(i - 1, j);
								List<Integer> currentValue = map.get(pair);
								if (currentValue == null) {
									currentValue = new ArrayList<Integer>();
									map.put(pair, currentValue);
								}
								// currentValue = map.get(pair);
								modInt = modInt + 100;
								currentValue.add(modInt);
								if (i < vertical.size() - 1) {
									hammerNote = vertical.get(i + 2)[j] - '0';
									currentValue.add(hammerNote);
								}
								grace = false;
							} else {
								Pair<Integer, Integer> pair = new Pair<>(i, j);
								List<Integer> currentValue = map.get(pair);
								if (currentValue == null) {
									currentValue = new ArrayList<Integer>();
									map.put(pair, currentValue);
								}
								currentValue.add(modInt);

							}

							if (i > 0 && (vertical.get(i - 1)[j] == 'h' || vertical.get(i - 1)[j] == 'p'
									|| vertical.get(i - 1)[j] == 's')) {
								Pair<Integer, Integer> pair = new Pair<>(i, j);
								map.remove(pair);
							}
						}
					}
				}

				if (vertical.get(i)[j] == 'g') {
					grace = true;
				}
			}
		}
		return map;
	}

	public int getAlter(String gString, int tab) {
		if (gString.equals("e") || gString.equals("E")) {
			if (tab == 0)
				alter = 0;
			else if (tab == 1)
				alter = 0;
			else if (tab == 2)
				alter = 1;
			else if (tab == 3)
				alter = 0;
			else if (tab == 4)
				alter = 1;
			else if (tab == 5)
				alter = 0;
			else if (tab == 6)
				alter = 1;
			else if (tab == 7)
				alter = 0;
			else if (tab == 8)
				alter = 0;
			else if (tab == 9)
				alter = 1;
			else if (tab == 10)
				alter = 0;
			else if (tab == 11)
				alter = 1;
			else if (tab == 12)
				alter = 0;
		}

		else if (gString.equals("A")) {
			if (tab == 0)
				alter = 0;
			else if (tab == 1)
				alter = 0;
			else if (tab == 2)
				alter = 1;
			else if (tab == 3)
				alter = 0;
			else if (tab == 4)
				alter = 1;
			else if (tab == 5)
				alter = 0;
			else if (tab == 6)
				alter = 0;
			else if (tab == 7)
				alter = 1;
			else if (tab == 8)
				note = "G";
			else if (tab == 9)
				alter = 1;
			else if (tab == 10)
				note = "G";
			else if (tab == 11)
				alter = 1;
			else if (tab == 12)
				alter = 0;
		}

		else if (gString.equals("D")) {
			if (tab == 0)
				alter = 0;
			else if (tab == 1)
				alter = 1;
			else if (tab == 2)
				note = "A";
			else if (tab == 3)
				alter = 1;
			else if (tab == 4)
				alter = 0;
			else if (tab == 5)
				alter = 0;
			else if (tab == 6)
				alter = 1;
			else if (tab == 7)
				alter = 0;
			else if (tab == 8)
				alter = 1;
			else if (tab == 9)
				alter = 0;
			else if (tab == 10)
				alter = 0;
			else if (tab == 11)
				alter = 1;
			else if (tab == 12)
				alter = 0;
		}

		else if (gString.equals("G")) {
			if (tab == 0)
				alter = 0;
			else if (tab == 1)
				alter = 1;
			else if (tab == 2)
				alter = 0;
			else if (tab == 3)
				alter = 0;
			else if (tab == 4)
				alter = 1;
			else if (tab == 5)
				note = "G";
			else if (tab == 6)
				alter = 1;
			else if (tab == 7)
				note = "A";
			else if (tab == 8)
				alter = 1;
			else if (tab == 9)
				alter = 0;
			else if (tab == 10)
				note = "F";
			else if (tab == 11)
				alter = 1;
			else if (tab == 12)
				alter = 0;
		}

		else if (gString.equals("B")) {
			if (tab == 0)
				alter = 0;
			else if (tab == 1)
				alter = 1;
			else if (tab == 2)
				alter = 0;
			else if (tab == 3)
				alter = 0;
			else if (tab == 4)
				alter = 1;
			else if (tab == 5)
				alter = 0;
			else if (tab == 6)
				alter = 1;
			else if (tab == 7)
				alter = 0;
			else if (tab == 8)
				alter = 0;
			else if (tab == 9)
				alter = 1;
			else if (tab == 10)
				alter = 0;
			else if (tab == 11)
				alter = 1;
			else if (tab == 12)
				alter = 0;
		}
		return alter;
	}

}
