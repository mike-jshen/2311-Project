package MusicXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.File;

//Not all of the above are needed, they are there just in case.

public class ConsoleTesting {
	
	public static void main (String[] args) throws Exception{
		
		File file = new File("tab1.txt");
		FileScanner readFile = new FileScanner(file);
		

		ArrayList <String[]> staffs = readFile.getStaffs();
		Keys keys = new Keys(staffs.get(0));
		
		keys.getAllKeys();
		
		for(int i = 0; i < staffs.size(); i++) {
			for(int j = 0; j < 6; j++) {
				System.out.println(staffs.get(i)[j]);
			}
			System.out.println();
		}
		
		Measures measures = new Measures(staffs.get(0));
		
		for(int i = 0; i < measures.getMeasures().size(); i++) {
			for(int j = 0; j < 6; j++) {
				System.out.println(measures.getMeasures().get(i)[j]);
			}
			System.out.println();
		}
		
		Notes notes = new Notes(measures.getMeasures().get(0));
		
		Map<Integer, List<Character>> notesMap = notes.notesMapping();
		
		for(Map.Entry<Integer,List<Character>> entry : notesMap.entrySet()){
			Integer index = entry.getKey();
			List<Character> value = entry.getValue();
			   
			System.out.print("At index: " + index + " ");
			System.out.print("   Values: ");
			for(int i = 0; i < value.size(); i++) {
				System.out.print(value.get(i) + " ");
			}
			System.out.println();
		}

	
		XMLOut test = new XMLOut();
		test.convertToXML(file);
	}
}
