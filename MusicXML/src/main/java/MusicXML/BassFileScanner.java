package MusicXML;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.io.File;

public class BassFileScanner {
	private ArrayList<String> lines = new ArrayList<String>();
	private ArrayList<String[]> staffs = new ArrayList<String[]>();
	private int counter;

	public BassFileScanner(File file) {
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {

				String data = reader.nextLine();

				// automatically put in standard guitar keys if the file does not have it
				if (!data.equals("") && !Character.isLetter(data.toCharArray()[0])) {
					if (counter == 0 || counter % 4 == 0)
						data = new String("E" + data);
					else if (counter % 4 == 1)
						data = new String("A" + data);
					else if (counter % 4 == 2)
						data = new String("D" + data);
					else if (counter % 4 == 3)
						data = new String("G" + data);

				}

				String newdata = data.replaceAll("\\s+","");
				this.lines.add(newdata);
				counter++;
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File Scan Error");
			e.printStackTrace();
		}

	}

	public ArrayList<String[]> getStaffs() {
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).contains("|-") || lines.get(i).contains("-|")) {
				String[] tmpStaff = { lines.get(i), lines.get(i + 1), lines.get(i + 2), lines.get(i + 3) };
				staffs.add(tmpStaff);
				i = i + 3;
			}
		}
		return staffs;
	}

}
