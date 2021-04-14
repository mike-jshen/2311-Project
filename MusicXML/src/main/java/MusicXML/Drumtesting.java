package MusicXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Drumtesting {

	public static void main(String[] args) {
		File file = new File("sampleDrums.txt");
		DrumFileScanner readFile = new DrumFileScanner(file);

		ArrayList<List<String>> staffs = readFile.getDrumStaffs();

		for (int i = 0; i < staffs.size(); i++) {
			for (int j = 0; j < staffs.get(i).size(); j++) {
				System.out.println(staffs.get(i).get(j));
			}
			System.out.println();
		}

		System.out.println("=======================Measure1===========================");
		DrumMeasures measures = new DrumMeasures(staffs.get(0));
		
		for (int i = 0; i < measures.getMeasures().size(); i++) {
			for (int j = 0; j < measures.getMeasures().get(i).size(); j++) {
				System.out.println(measures.getMeasures().get(i).get(j));
			}
			System.out.println();
		}
		
		System.out.println("=======================Measure2==========================");
		DrumMeasures measures2 = new DrumMeasures(staffs.get(1));
		
		for (int i = 0; i < measures2.getMeasures().size(); i++) {
			for (int j = 0; j < measures2.getMeasures().get(i).size(); j++) {
				System.out.println(measures2.getMeasures().get(i).get(j));
			}
			System.out.println();
		}

	}

}
