/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package MusicXML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.*;
import java.io.File;

//Not all of the above are needed, they are there just in case.

public class Library {
	
	public static void main (String[] args) throws Exception{
		
		// This is the file you want to read
		File file = new File("tab1.txt");
		ArrayList <String> lines = new ArrayList<String>();
		
		
		try {
			// This is the scanner that actually reads the file
			Scanner reader = new Scanner (file);
			
			// This is code is the one that actually prints it out into java
			while (reader.hasNextLine()) {
				
				String data = reader.nextLine();
				System.out.println(data);
				lines.add(data);
			}
			//closes reader
			reader.close();
			
			// ------------------------------------------------------------------------------------------------------------
			// find spaces between bars
			char[] array;
			array = lines.get(0).toCharArray();
			System.out.println("Length of one line: " + array.length);
			
			int barCounter = 0;
			int spacesBetweenBar = 0;
			
			for(int i = 1; i < array.length; i++) { 			// int i starts at 1 to skip first character, the key of the string
				if(barCounter < 2) {
					if(array[i] == '|') {
						barCounter++;
					}
					else {
						spacesBetweenBar++;
					}
				}
			}
			
			System.out.println("Number of spaces in the first bar: " + spacesBetweenBar);		
			
			// one problem that might arise, user might have different spacing for the bars (e.g. first bar has 26 spaces, second has 25)
			// ------------------------------------------------------------------------------------------------------------
			// parse bars into string arrays
			
			String firstLine = lines.get(1); 			// change this to move between guitar strings (e.g. index 0 is thinnest string)
			String lineWithoutKey = firstLine.substring(2);
			
			String[] bars = lineWithoutKey.split("\\|");
			
			for (String bar : bars)
				System.out.println(bar);
			
			// ------------------------------------------------------------------------------------------------------------
			// identify numbers at certain index
			
			char[] firstBar = bars[0].toCharArray();
			
			for(int i = 0; i < firstBar.length; i++) {
				if(Character.isDigit(firstBar[i])) {
					System.out.println("At index " + i + ", note " + firstBar[i]);
				}
			}
			
			// -------------------------------------------------------------------------------------------------------------
			
		}
		// catches any exceptions
		catch (IOException e) {
			System.out.println("There was an error");
			e.printStackTrace();
		}
		
	}
	
    public boolean someLibraryMethod(){
    	int zero = 0;
        return false;
    }
}
