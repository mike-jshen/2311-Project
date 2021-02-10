package MusicXML;

public class Tabs2Notes {

	
	public String notes(String gString, char i ) {
	
		String newNote = "";
		
		
		if(gString == "E" && i == '0') {
			
			newNote = "E";
		
		}
		
		else if (gString == "E" && i == '1') {
			
			newNote = "F";
			
		}
		
		else if (gString == "E" && i == '2') {
			
			newNote = "F#";
			
		}
		
	
	return newNote;
	}
	
	
	public String tOrB() {
		
		String pog = "";
	
		
		return pog;
	}
}
