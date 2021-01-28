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
	
	int FirstLine() { // Gets & returns the amount of characters for the first line
		// This is assume that every lengths of the text files remain the same for each line
		array = lines.get(0).toCharArray();
		return array.length;
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
	
}