
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
import java.awt.*;
import javax.swing.*;

//Not all of the above are needed, they are there just in case.

public class Library {
	
	public static void main (String[] args) throws Exception{
		


		File file = new File("test.txt");
		FileScanner read = new FileScanner(file);
			// ------------------------------------------------------------------------------------------------------------
			// find spaces between bars (Consult FileScanner Class)
			System.out.println("Length of one line: " + read.LineLength(0));

						
			read.SpaceCounter(); // Count the number of spaces in each bar & count how many bars there are (Evokes void method)
			
			System.out.println("Number of spaces in the first bar: " + read.spacesBetweenBar);		
			
			System.out.println("The key of the third string is: " + read.KeyFinder(2));
			
			// one problem that might arise, user might have different spacing for the bars (e.g. first bar has 26 spaces, second has 25)
			// ------------------------------------------------------------------------------------------------------------
			// parse bars into string arrays
			
			for(int i = 0; i <= 5; i++) {
				String firstLine = read.lines.get(i); 			// change this to move between guitar strings (e.g. index 0 is thinnest string)
				String lineWithoutKey = firstLine.substring(2);
				
				
				String[] bars = lineWithoutKey.split("\\|");
				
				for (String bar : bars)
					System.out.print(bar + "   ");
				System.out.println();
			}
//			// ------------------------------------------------------------------------------------------------------------
//			// identify numbers at certain index
//			
			
			
//			char[] firstBar = bars[0].toCharArray();
//			
//			for(int i = 0; i < firstBar.length; i++) {
//				if(Character.isDigit(firstBar[i])) {
//					System.out.println("At index " + i + ", note " + firstBar[i]);
//				}
//			}
			
			// ------------------------------------------------------------------------------------------------------------
			// identify numbers at certain index
			
//				System.out.println(bar);
    
  		// ------------------------------------------------------------------------------------------------------------
      // identify numbers at certain index		
    
			
			// -------------------------------------------------------------------------------------------------------------
			
		}
		// catches any exceptions

	
    public boolean someLibraryMethod(){
    	int zero = 0; // Used for TA Demo. Dunno what else this is used for (Maybe created by default???)
        return true;
    }
}