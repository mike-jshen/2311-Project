package MusicXML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InstrumentDetection {
	private ArrayList<String> lines = new ArrayList<String>();
	boolean drums;
	boolean bass;
	boolean guitar;

	public InstrumentDetection(File file) {
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {

				String data = reader.nextLine();
				lines.add(data);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File Scan Error");
			e.printStackTrace();
		}
	}

	public String getDetectedInstrument() {
		String instrument = "";
		for (int i = 0; i < lines.size(); i++) {
			if (!lines.get(i).equals("") && lines.get(i).contains("-")) {
				// simple check for drums
				if (lines.get(i).contains("x") || lines.get(i).contains("o")) {
					if(lines.get(i).contains("|")) {
						instrument = "Drums";
						break;
					}
				}

				// check if the next 3 lines exist (4 total - bass) or 5 lines exists (6 total -
				// guitar)
				else if (i + 3 < lines.size()) {
					if (lines.get(i + 1).contains("-") && lines.get(i + 2).contains("-")
							&& lines.get(i + 3).contains("-")) {
						instrument = "Bass";
					}
				}
				if (i + 5 < lines.size()) {
					if (lines.get(i + 1).contains("-") && lines.get(i + 2).contains("-")
							&& lines.get(i + 3).contains("-") && lines.get(i + 4).contains("-")
							&& lines.get(i + 5).contains("-")) {
						instrument = "Guitar";
						break;
					}
				}
			}
		}
		return instrument;
	}
}
