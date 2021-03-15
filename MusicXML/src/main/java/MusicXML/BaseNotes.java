package MusicXML;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BaseNotes {

	ArrayList<char[]> vertical = new ArrayList<char[]>();
	private String note = "";
	private Map<Integer, List<Character>> map = new LinkedHashMap<Integer, List<Character>>();
	private int alter;
	private int octave;

	public BaseNotes(String[] singleMeasure) {
		char[] singleMeasure0 = singleMeasure[0].toCharArray();
		char[] singleMeasure1 = singleMeasure[1].toCharArray();
		char[] singleMeasure2 = singleMeasure[2].toCharArray();
		char[] singleMeasure3 = singleMeasure[3].toCharArray();
		char[] singleMeasure4 = singleMeasure[4].toCharArray();
		char[] singleMeasure5 = singleMeasure[5].toCharArray();

		for (int i = 0; i < singleMeasure0.length; i++) {
			char[] tmp = { singleMeasure0[i], singleMeasure1[i], singleMeasure2[i], singleMeasure3[i],
					singleMeasure4[i], singleMeasure5[i] };
			vertical.add(tmp);
		}
	}

	public String getNote(String gString, char tab) {
		if (gString.equals("e") || gString.equals("E")) {
			if (tab == '0')
				note = "E";
			else if (tab == '1')
				note = "F";
			else if (tab == '2') {
				note = "F"; // sharp
				alter = 1;
			}
			else if (tab == '3')
				note = "G";
			else if (tab == '4') {
				note = "G"; // sharp
				alter = 1;
			}
			else if (tab == '5')
				note = "A";
			else if (tab == '6') {
				note = "A"; // sharp
				alter = 1;
			}
			else if (tab == '7')
				note = "B";
			else if (tab == '8')
				note = "C";
			else if (tab == '9') {
				note = "C"; // sharp
				alter = 1;
			}
			
			
		}
		return note;
	}
}