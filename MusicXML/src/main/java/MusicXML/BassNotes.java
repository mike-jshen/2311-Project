package MusicXML;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BassNotes {

	ArrayList<char[]> vertical = new ArrayList<char[]>();
	private String note = "";
	private Map<Integer, List<Character>> map = new LinkedHashMap<Integer, List<Character>>();
	private int alter;
	private int octave;

	public BassNotes(String[] singleMeasure) {
		char[] singleMeasure0 = singleMeasure[0].toCharArray();
		char[] singleMeasure1 = singleMeasure[1].toCharArray();
		char[] singleMeasure2 = singleMeasure[2].toCharArray();
		char[] singleMeasure3 = singleMeasure[3].toCharArray();


		for (int i = 0; i < singleMeasure0.length; i++) {
			char[] tmp = { singleMeasure0[i], singleMeasure1[i], singleMeasure2[i], singleMeasure3[i]};
			vertical.add(tmp);
		}
	}

	public String getNote(String gString, char tab) {
		if (gString.equals("G")) {
			if (tab == '0') 
				note = "G";
			else if (tab == '1') {
				note = "A";
				alter = -1; //flat
			}
			else if (tab == '2') {
				note = "A";
			}
			else if (tab == '3') {
				note = "B";
				alter = -1; //flat
			}
			else if (tab == '4') {
				note = "B"; 
				
			}
			else if (tab == '5')
				note = "C";
			else if (tab == '6') {
				note = "D";
				alter = -1; //flat
			}
			else if (tab == '7')
				note = "D";
			else if (tab == '8') {
				note = "E";
				alter = -1; //flat
			}
			else if (tab == '9') {
				note = "E";

			}
		}

		else if (gString.equals("D")) {
			if (tab == '0')
				note = "D";
			else if (tab == '1') {
				note = "E";
				alter = -1; //flat
			}
			else if (tab == '2') {
				note = "E";
			}
			else if (tab == '3')
				note = "F";
			else if (tab == '4') {
				note = "G";
				alter = -1; //flat
			}
			else if (tab == '5')
				note = "G";
			else if (tab == '6') {
				note = "A";
				alter = -1; //flat
			}
			else if (tab == '7') {
				note = "A";
			}
			else if (tab == '8') {
				note = "B";
				alter = -1; //flat
			}
			else if (tab == '9') {
				note = "B";

			}
		}

		else if (gString.equals("A")) {
			if (tab == '0')
				note = "A";
			else if (tab == '1') {
				note = "B";
				alter = -1; //flat
			}
			else if (tab == '2')
				note = "B";
			else if (tab == '3') {
				note = "C";
			}
			else if (tab == '4') {
				note = "D";
				alter = -1; //flat
			}
			else if (tab == '5')
				note = "D";
			else if (tab == '6') {
				note = "E";
				alter = -1; //flat
			}
			else if (tab == '7')
				note = "E";
			else if (tab == '8') {
				note = "F";
			}
			else if (tab == '9') {
				note = "G";
				alter = -1; //flat
			}
		}

		else if (gString.equals("E")) {
			if (tab == '0')
				note = "R";
			else if (tab == '1') {
				note = "F";
			}
			else if (tab == '2') {
				note = "G";
				alter = -1; //flat
			}
			else if (tab == '3')
				note = "G";
			else if (tab == '4') {
				note = "A";
				alter = -1; //flat
			}
			else if (tab == '5')
				note = "A";
			else if (tab == '6') {
				note = "B";
				alter = -1; //flat
			}
			else if (tab == '7')
				note = "B";
			else if (tab == '8') {
				note = "C";
			}
			else if (tab == '9') {
				note = "D";
				alter = -1;
		}
		}

		return note;
	}
	
	public int getOctave(int gStrIndex, char tab) {
		if(gStrIndex == 0) {
			switch(tab) {
			case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7':
				octave = 4;
				break;
			case '8': case '9':
				octave = 5;
				break;
			default: octave = -1; 	// for debugging
			}
		}
		else if(gStrIndex == 1) {
			switch(tab) {
			case '0':
				octave = 3;
				break;
			case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				octave = 4;
				break;
			default: octave = -1; 	// for debugging
			}
		}
		else if(gStrIndex == 2) {
			switch(tab) {
			case '0': case '1': case '2': case '3': case '4':
				octave = 3;
				break;
			 case '5': case '6': case '7': case '8': case '9':
				octave = 4;
				break;
			default: octave = -1; 	// for debugging
			}
		}
		else if(gStrIndex == 3) {
			switch(tab) {
			case '0': case '1': case '2': case '3': case '5': case '6': case '7': case '8': case '9':
				octave = 3;
				break;
			default: octave = -1; 	// for debugging
			}
		}

		return octave;
	}

	public Map<Integer, List<Character>> getNotesMapping() {

		for (int i = 0; i < vertical.size(); i++) {
			for (int j = 0; j < 4; j++) {
				if (Character.isDigit(vertical.get(i)[j])) {
					List<Character> currentValue = map.get(Integer.valueOf(i));
					if (currentValue == null) {
						currentValue = new ArrayList<Character>();
						map.put(Integer.valueOf(i), currentValue);
					}
					currentValue.add(Character.valueOf(vertical.get(i)[j]));
				}
			}
		}
		return map;
	}
	
	public int getAlter() {
		return alter;
	}

	public void resetAlter() {
		this.alter = 0;
	}
}