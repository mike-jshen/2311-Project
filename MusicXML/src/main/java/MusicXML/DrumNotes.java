package MusicXML;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DrumNotes {
	
	ArrayList<char[]> vertical = new ArrayList<char[]>();
	private String note = "";
	private Map<Integer, List<Character>> map = new LinkedHashMap<Integer, List<Character>>();
	private int alter;
	private int octave;

	public DrumNotes(String[] singleMeasure) {
		
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
		if (gString.equals("CC") || gString.equals("C")){
			if (tab == 'o')
				note = "normal hit";
			
			else if (tab == 'x' || tab == 'X')
				note = "open hi-hat";
			
			else if (tab == 'd')
				note = "double stroke";
			
			else if (tab == 'O')
				note = "snare accent";
			
			else if (tab == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("HH")){
			if (tab == 'o')
				note = "normal hit";
			
			else if (tab == 'x' || tab == 'X')
				note = "open hi-hat";
			
			else if (tab == 'd')
				note = "double stroke";
			
			else if (tab == 'O')
				note = "snare accent";
			
			else if (tab == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("SD")){
			if (tab == 'o')
				note = "normal hit";
			
			else if (tab == 'x' || tab == 'X')
				note = "open hi-hat";
			
			else if (tab == 'd')
				note = "double stroke";
			
			else if (tab == 'O')
				note = "snare accent";
			
			else if (tab == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("HT")){
			if (tab == 'o')
				note = "normal hit";
			
			else if (tab == 'x' || tab == 'X')
				note = "open hi-hat";
			
			else if (tab == 'd')
				note = "double stroke";
			
			else if (tab == 'O')
				note = "snare accent";
			
			else if (tab == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("MT")){
			if (tab == 'o')
				note = "normal hit";
			
			else if (tab == 'x' || tab == 'X')
				note = "open hi-hat";
			
			else if (tab == 'd')
				note = "double stroke";
			
			else if (tab == 'O')
				note = "snare accent";
			
			else if (tab == 'g')
				note = "ghost note";
		}
		
		if (gString.equals("BD")){
			if (tab == 'o')
				note = "normal hit";
			
			else if (tab == 'x' || tab == 'X')
				note = "open hi-hat";
			
			else if (tab == 'd')
				note = "double stroke";
			
			else if (tab == 'O')
				note = "snare accent";
			
			else if (tab == 'g')
				note = "ghost note";
		}
		
		
		return note;
	}
	
	
	public Map<Integer, List<Character>> getNotesMapping() {

		for (int i = 0; i < vertical.size(); i++) {
			for (int j = 0; j < 6; j++) {
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

}
