package MusicXML;

import java.util.ArrayList;

abstract class Instrument {
	ArrayList <String> lines = new ArrayList<String>(); // Stores every line in the txt file
	ArrayList<String[]> measureList = new ArrayList<String[]>();	// Stores the list of the whole measure
	int numOfMeasures;
	int barCounter = 0;
	int spacesBetweenBar = 0;
	
	public abstract char KeyFinder();
	
	void SpaceCounter(int line) {
		char[] array;
		array = lines.get(line).toCharArray();
		for (int i = 1; i < array.length; i++) { // int i starts at 1 to skip first character, the key of the string
			if (barCounter < 2) {
				if (array[i] == '|') {
					barCounter++;
				} else {
					spacesBetweenBar++;
				}
			}
		}
	}
}
