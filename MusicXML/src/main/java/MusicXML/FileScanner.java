package MusicXML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.io.File;

public class FileScanner {
	ArrayList <String> lines = new ArrayList<String>(); 
	ArrayList <String[]> staffs = new ArrayList<String[]>(); 
	
	public FileScanner(File file){
		try {
			Scanner reader = new Scanner (file);
			while (reader.hasNextLine()) {
				
				String data = reader.nextLine();
				this.lines.add(data);
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("File Scan Error");
			e.printStackTrace();
		}
	}

	public ArrayList <String[]> getStaffs() {
		char[] tmpLine;
		for (int i = 0; i < lines.size(); i++) {
			tmpLine = lines.get(i).toCharArray();
			if(tmpLine.length > 0 && Character.isLetter(tmpLine[0])) {
				String[] tmpStaff = {lines.get(i), lines.get(i+1), lines.get(i+2), lines.get(i+3), lines.get(i+4), lines.get(i+5)};
				staffs.add(tmpStaff);
				i = i + 5;
			}
		}
		return staffs;
	}
		
}