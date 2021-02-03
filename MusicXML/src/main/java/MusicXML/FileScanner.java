package MusicXML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.io.File;

public class FileScanner {
	ArrayList <String> lines = new ArrayList<String>(); // Stores every line in the txt file (e.g. "E|--0-----------------------|-------------------------|--0-----------------------|-------------------------|-------------------------|")
	ArrayList<String[]> measureList = new ArrayList<String[]>();	// Stores the list of the whole measure
	int numOfMeasures;
	int barCounter = 0;
	int spacesBetweenBar = 0;
	
	public FileScanner(File file){
		try {
			// This is the scanner that actually reads the file
			Scanner reader = new Scanner (file);
	
			// This is code is the one that actually prints it out into java
			while (reader.hasNextLine()) {
				
				String data = reader.nextLine();
				System.out.println(data);
				this.lines.add(data);
			}
			//closes reader
			reader.close();
			
		}
		catch (IOException e) {
			System.out.println("File Scan Error");
			e.printStackTrace();
		}
	}
	
	
	char KeyFinder(int string) {
		char[] array;
		array = lines.get(string).toCharArray();
		return array[0];
	}
	
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
	
	int numOfMeasures(int measure) {
		char[] array;
		array = lines.get(measure).toCharArray();
		for (int i = 1; i < array.length; i++) { // int i starts at 1 to skip first character, the key of the string
			if (array[i] == '|') {
				numOfMeasures++;
			}
		}
		return numOfMeasures;
	}
	
	ArrayList<String[]> getMeasures() {
		ArrayList <String> tmpBar = new ArrayList <String>();
		String[] individualMeasure = new String[6];
		for(int i = 0; i < 6; i++) {
			String selectedLine = lines.get(i); 
			String lineWithoutKey = selectedLine.substring(2);
			
			String[] bars = lineWithoutKey.split("\\|");
			
			for (String bar : bars)
				tmpBar.add(bar);
			}
		
		for(int i = 0; i < tmpBar.size()/6; i++) {
			
			for(int j = i; j < tmpBar.size(); j = j + tmpBar.size()/6) {
				individualMeasure[j / (tmpBar.size()/6)] = tmpBar.get(j).toString();
				
			}
			measureList.add(individualMeasure.clone());			// deep copy of individualMeasure
			
		}
	
		return measureList;
	}
	
	
	ArrayList<char[]> toCharArray(String[] stringArr){
		ArrayList<char[]> arrList = new ArrayList<char[]>();
		for(int i = 0; i < stringArr.length; i++) {
			arrList.add(stringArr[i].toCharArray());
		}
		return arrList;
	}
	
	
	char[] findNotes(int measure){
		ArrayList<char[]> array = new ArrayList<char[]>();
		char[] myNotes = new char[6];
		getMeasures();

		array = toCharArray(measureList.get(measure));
		
		
		for(int i = 0; i < array.get(0).length; i++) {
			if(Character.isDigit(array.get(0)[i])) {
				myNotes[0] = array.get(0)[i];
				myNotes[1] = array.get(1)[i];
				myNotes[2] = array.get(2)[i];
				myNotes[3] = array.get(3)[i];
				myNotes[4] = array.get(4)[i];
				myNotes[5] = array.get(5)[i];
			}
		}
		return myNotes;
		
	}
		
}