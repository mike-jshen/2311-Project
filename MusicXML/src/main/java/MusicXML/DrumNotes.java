package MusicXML;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class DrumNotes {
	
	ArrayList<char[]> vertical = new ArrayList<char[]>();
	private String note = "";
	private Map<Pair<Integer, Integer>, List<Character>> map = new LinkedHashMap<Pair<Integer, Integer>, List<Character>>();
	
	private int alter;
	private int octave;

	public DrumNotes(String[] singleMeasure) {
		
		char[] singleMeasure0 = singleMeasure[0].toCharArray();
		char[] singleMeasure1 = singleMeasure[1].toCharArray();
		char[] singleMeasure2 = singleMeasure[2].toCharArray();
		char[] singleMeasure3 = singleMeasure[3].toCharArray();
		char[] singleMeasure4 = singleMeasure[4].toCharArray();
		char[] singleMeasure5 = singleMeasure[5].toCharArray();

		if (singleMeasure0.length == singleMeasure1.length && singleMeasure1.length == singleMeasure2.length
				&& singleMeasure2.length == singleMeasure3.length && singleMeasure3.length == singleMeasure4.length
				&& singleMeasure4.length == singleMeasure5.length) {
			for (int i = 0; i < singleMeasure0.length; i++) {
				char[] tmp = { singleMeasure0[i], singleMeasure1[i], singleMeasure2[i], singleMeasure3[i],
						singleMeasure4[i], singleMeasure5[i] };
				vertical.add(tmp);
			}
		}else {
			System.out.println(
					">> Error: Some line(s) may longer or shorter than others. This should be fixed before converting.");
		}
		
		
	}
	
	public String getNote(String gString, char noteNum) {
		if (gString.equals("CC") || gString.equals("C")){
			if (noteNum == 'o')
				note = "normal hit";
			
			else if (noteNum == 'x' || noteNum == 'X')
				note = "open hi-hat";
			
			else if (noteNum == 'd')
				note = "double stroke";
			
			else if (noteNum == 'O')
				note = "snare accent";
			
			else if (noteNum == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("HH")){
			if (noteNum == 'o')
				note = "normal hit";
			
			else if (noteNum == 'x' || noteNum == 'X')
				note = "open hi-hat";
			
			else if (noteNum == 'd')
				note = "double stroke";
			
			else if (noteNum == 'O')
				note = "snare accent";
			
			else if (noteNum == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("SD")){
			if (noteNum == 'o')
				note = "normal hit";
			
			else if (noteNum == 'x' || noteNum == 'X')
				note = "open hi-hat";
			
			else if (noteNum == 'd')
				note = "double stroke";
			
			else if (noteNum == 'O')
				note = "snare accent";
			
			else if (noteNum == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("HT")){
			if (noteNum == 'o')
				note = "normal hit";
			
			else if (noteNum == 'x' || noteNum == 'X')
				note = "open hi-hat";
			
			else if (noteNum == 'd')
				note = "double stroke";
			
			else if (noteNum == 'O')
				note = "snare accent";
			
			else if (noteNum == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("MT")){
			if (noteNum == 'o')
				note = "normal hit";
			
			else if (noteNum == 'x' || noteNum == 'X')
				note = "open hi-hat";
			
			else if (noteNum == 'd')
				note = "double stroke";
			
			else if (noteNum == 'O')
				note = "snare accent";
			
			else if (noteNum == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("BD")){
			if (noteNum == 'o')
				note = "normal hit";
			
			else if (noteNum == 'x' || noteNum == 'X')
				note = "open hi-hat";
			
			else if (noteNum == 'd')
				note = "double stroke";
			
			else if (noteNum == 'O')
				note = "snare accent";
			
			else if (noteNum == 'g')
				note = "ghost note";
		}
		
		
		return note;
	}
	
	public int getOctave(int gStrIndex, char tab) {
		if (gStrIndex == 0) {
			switch (tab) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				octave = 4;
				break;
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				octave = 5;
				break;
			default:
				octave = -1; // for debugging
			}
		} else if (gStrIndex == 1) {
			switch (tab) {
			case 0:
				octave = 3;
				break;
			case 1:
			case 2:
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
				octave = 4;
				break;
			default:
				octave = -1; // for debugging
			}
		} else if (gStrIndex == 2) {
			switch (tab) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				octave = 3;
				break;
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				octave = 4;
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
			case 8:
			case 9:
				octave = 3;
				break;
			case 10:
			case 11:
			case 12:
				octave = 4;
				break;
			default:
				octave = -1; // for debugging
			}
		} else if (gStrIndex == 4) {
			switch (tab) {
			case 0:
			case 1:
			case 2:
				octave = 2;
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
				octave = 3;
				break;
			default:
				octave = -1; // for debugging
			}
		} else if (gStrIndex == 5) {
			switch (tab) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				octave = 2;
				break;
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
		}
		return octave;
	}
	
	public Map<Pair<Integer, Integer>, List<Character>> getNotesMapping() {
		boolean grace = false;

		for (int i = 0; i < vertical.size(); i++) {
			for (int j = 0; j < 6; j++) {
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
							List<Character> currentValue = map.get(pair);
							if (currentValue == null) {
								currentValue = new ArrayList<Character>();
								map.put(pair, currentValue);
							}

							modInt = modInt + 100;
							currentValue.add((char) modInt);
							if (i < vertical.size() - 1) {
								hammerNote = vertical.get(i + 3)[j] - '0';
								currentValue.add((char) hammerNote);
							}
							grace = false;
						} else {
							Pair<Integer, Integer> pair = new Pair<>(i, j);
							List<Character> currentValue = map.get(pair);
							if (currentValue == null) {
								currentValue = new ArrayList<Character>();
								map.put(pair, currentValue);
							}
							currentValue.add((char) modInt);
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
								List<Character> currentValue = map.get(pair);
								if (currentValue == null) {
									currentValue = new ArrayList<Character>();
									map.put(pair, currentValue);
								}
								// currentValue = map.get(pair);
								modInt = modInt + 100;
								currentValue.add((char) modInt);
								if (i < vertical.size() - 1) {
									hammerNote = vertical.get(i + 2)[j] - '0';
									currentValue.add((char) hammerNote);
								}
								grace = false;
							} else {
								Pair<Integer, Integer> pair = new Pair<>(i, j);
								List<Character> currentValue = map.get(pair);
								if (currentValue == null) {
									currentValue = new ArrayList<Character>();
									map.put(pair, currentValue);
								}
								currentValue.add((char) modInt);

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
}
