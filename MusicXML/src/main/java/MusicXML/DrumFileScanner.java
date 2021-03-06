package MusicXML;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class DrumFileScanner {
	
	private ArrayList<String> lines = new ArrayList<String>();
	private ArrayList<String[]> staffs = new ArrayList<String[]>();
	private int counter;

	public DrumFileScanner(File file) {
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {

				String data = reader.nextLine();

				// automatically put in standard guitar keys if the file does not have it
				if (!data.equals("") && !Character.isLetter(data.toCharArray()[0])) {
					if (counter == 0 || counter % 6 == 0)
						data = new String("CC" + data);
					else if (counter % 6 == 1)
						data = new String("HH" + data);
					else if (counter % 6 == 2)
						data = new String("SD" + data);
					else if (counter % 6 == 3)
						data = new String("HT" + data);
					else if (counter % 6 == 4)
						data = new String("MT" + data);
					else if (counter % 6 == 5)
						data = new String("BD" + data);
				
				}

				this.lines.add(data);
				counter++;
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File Scan Error");
			e.printStackTrace();
		}
		
		
		
		

	}

	public ArrayList<String[]> getDStaffs() {
		char[] tmpLine;
		for (int i = 0; i < lines.size(); i++) {
			tmpLine = lines.get(i).toCharArray();
			if (tmpLine.length > 0 && tmpLine[2] == '|') {
				String[] tmpStaff = { lines.get(i), lines.get(i + 1), lines.get(i + 2), lines.get(i + 3),
						lines.get(i + 4), lines.get(i + 5) };
				staffs.add(tmpStaff);
				i = i + 5;
			}
		}
		return staffs;
	}

}