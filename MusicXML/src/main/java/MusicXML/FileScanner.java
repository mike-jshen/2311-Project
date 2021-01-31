package MusicXML;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.File;

public class FileScanner {
	ArrayList <String> lines = new ArrayList<String>(); //Arraylist that text file data is stored into
	char[] array;
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
	
	void SpaceCounter() {
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
	
	void IndexAndNote() {
		for(int i = 0; i < array.length; i++) {
			if(Character.isDigit(array[i])) {
				System.out.println("At index " + i + ", note " + array[i]);
			}
		}
	
	}
	
}