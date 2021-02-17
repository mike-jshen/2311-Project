package MusicXML;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Notes { 

	ArrayList<char[]> vertical = new ArrayList<char[]>();
	private String note = "";
	Map<Integer, List<Character>> map = new LinkedHashMap<Integer, List<Character>>();
	
	public Notes(String[] singleMeasure) {
		char[] singleMeasure0 = singleMeasure[0].toCharArray();
		char[] singleMeasure1 = singleMeasure[1].toCharArray();
		char[] singleMeasure2 = singleMeasure[2].toCharArray();
		char[] singleMeasure3 = singleMeasure[3].toCharArray();
		char[] singleMeasure4 = singleMeasure[4].toCharArray();
		char[] singleMeasure5 = singleMeasure[5].toCharArray();
		
		for(int i = 0; i < singleMeasure0.length; i++) {
			char[] tmp = {singleMeasure0[i], singleMeasure1[i], singleMeasure2[i], singleMeasure3[i], singleMeasure4[i], singleMeasure5[i]};
			vertical.add(tmp);
		}	
	}
	
	public String getNote(String gString, char tab) {
		if(gString.equals("e")) {
			if(tab == '0')
				note = "e";
			else if (tab == '1')
				note = "F";
			else if (tab == '2')
				note = "F#";
			else if (tab == '3')
				note = "G";
			else if (tab == '4')
				note = "G#";
			else if (tab == '5')
				note = "A";
			else if (tab == '6')
				note = "A#";
			else if (tab == '7')
				note = "B";
			else if (tab == '8')
				note = "C";
			else if (tab == '9')
				note = "C#";
		}
		
		else if(gString.equals("B")) {
			if(tab == '0')
				note = "B";
			else if (tab == '1')
				note = "C";
			else if (tab == '2')	
				note = "C#";
			else if (tab == '3')
				note = "D";
			else if (tab == '4')
				note = "D#";
			else if (tab == '5')
				note = "E";
			else if (tab == '6')
				note = "F";
			else if (tab == '7')
				note = "F#";
			else if (tab == '8')	
				note = "G";
			else if (tab == '9')
				note = "G#";
		}
		
		else if(gString.equals("G")) {
			if(tab == '0')
				note = "G";
			else if (tab == '1')
				note = "G#";
			else if (tab == '2')	
				note = "A";
			else if (tab == '3')
				note = "A#";
			else if (tab == '4')
				note = "B";
			else if (tab == '5')
				note = "C";
			else if (tab == '6')
				note = "C#";
			else if (tab == '7')
				note = "D";
			else if (tab == '8')
				note = "D#";
			else if (tab == '9')
				note = "E";
		}
		
		else if(gString.equals("D")) {
			if(tab == '0')
				note = "D";
			else if (tab == '1')
				note = "D#";
				
			else if (tab == '2')
				note = "E";
			else if (tab == '3')
				note = "F";
			else if (tab == '4')
				note = "F#";
			else if (tab == '5')
				note = "G";
			else if (tab == '6') 
				note = "G#";
			else if (tab == '7')
				note = "A";
			else if (tab == '8')
				note = "A#";
			else if (tab == '9')
				note = "B";
		}
		
		else if(gString.equals("A")) {
			if(tab == '0')
				note = "A";
			else if (tab == '1')
				note = "A#";
			else if (tab == '2')
				note = "B";
			else if (tab == '3')
				note = "C";
			else if (tab == '4')
				note = "C#";
			else if (tab == '5')
				note = "D";
			else if (tab == '6')
				note = "D#";
			else if (tab == '7')
				note = "E";
			else if (tab == '8')
				note = "F";
			else if (tab == '9')
				note = "F#";
		}
		
		else if(gString.equals("E")) {
			if(tab == '0')
				note = "E";	
			else if (tab == '1')
				note = "F";	
			else if (tab == '2')
				note = "F#";
			else if (tab == '3') 
				note = "G";
			else if (tab == '4') 
				note = "G#";
			else if (tab == '5') 
				note = "A";
			else if (tab == '6') 
				note = "A#";
			else if (tab == '7') 
				note = "B";
			else if (tab == '8') 
				note = "C";
			else if (tab == '9') 
				note = "C#";
		}
	return note;
	}

	public Map<Integer, List<Character>> notesMapping() {
		
		for(int i = 0; i < vertical.size(); i++) {
			for(int j = 0; j < 6; j++) {
				if(Character.isDigit(vertical.get(i)[j])) {
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
}
