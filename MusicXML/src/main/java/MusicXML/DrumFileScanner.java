package MusicXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class DrumFileScanner {

	private ArrayList<String> lines = new ArrayList<String>();
	private ArrayList<List<String>> staffs = new ArrayList<List<String>>();
	int numOfInstr;

	public DrumFileScanner(File file) {
		try {
			int currNumOfInstr = 0;
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {

				String data = reader.nextLine();

				// find the number of instruments
				if (!data.equals("") && data.contains("|-")) {
					currNumOfInstr++;
				} else {
					currNumOfInstr = 0;
				}

				this.lines.add(data);
				if (currNumOfInstr >= numOfInstr)
					numOfInstr = currNumOfInstr;
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File Scan Error");
			e.printStackTrace();
		}

	}

	public ArrayList<List<String>> getDrumStaffs() {
		boolean newStaff = false;
		List<String> tmpStaff = new ArrayList<String>();
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).contains("|-") || lines.get(i).contains("-|")) {
				tmpStaff.add(lines.get(i));
			} else if (i < lines.size() - 1) {
				if (lines.get(i + 1).contains("|-") || lines.get(i + 1).contains("-|")) {
					newStaff = true;
				}
			}
			if (newStaff || i == lines.size() - 1) {
				List<String> cloned = new ArrayList<String>(tmpStaff);
				staffs.add(cloned);
				tmpStaff.clear();
				newStaff = false;
			}
		}
		return staffs;
	}

}