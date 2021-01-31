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
	char[] array;
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
	
	int LineLength(int string) { // Gets & returns the amount of characters for a given line
		// This is assume that every lengths of the text files remain the same for each line
		array = lines.get(string).toCharArray();
		return array.length;
	}
	
	char KeyFinder(int string) {
		array = lines.get(string).toCharArray();
		return array[0];
	}
	
	void SpaceCounter(int line) {
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
	
	String IndexAndNote(int measure){
		return null;
	}
		
}