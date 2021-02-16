
package MusicXML;

public class Tabs2Notes {

	public String notes(String gString, char i ) {
		
		String newNote = "";
			
		/*
		 * THIS IS UNFISHED, IT STILL NEEDS A PROPER PARSER... 
		 * therefore we need to put this all in a loop, and to get the proper parsed objects...
		 * this being the String and the note that was needed.
		 * 
		 */
		
		
			//e STRING this is top string
		if(gString == "e" && i == '0') {
			
			newNote = "e";
			
		}
			
		else if (gString == "e" && i == '1') {
				
			newNote = "F";
				
		}
			
		else if (gString == "e" && i == '2') {
				
			newNote = "F#";
				
		}
		
		else if (gString == "e" && i == '3') {
			
			newNote = "G";
		}
		
		else if (gString == "e" && i == '4') {
			
			newNote = "G#";
		}
		
		else if (gString == "e" && i == '5') {
			
			newNote = "A";
		}
		
		else if (gString == "e" && i == '6') {
			
			newNote = "A#";
		}
		
		else if (gString == "e" && i == '7') {
			
			newNote = "B";
		}
		
		else if (gString == "e" && i == '8') {
			
			newNote = "C";
		}
		
		else if (gString == "e" && i == '9') {
			
			newNote = "C#";
		}
			
			//B STRING
		if(gString == "B" && i == '0') {
			
			newNote = "B";
			
		}
			
		else if (gString == "B" && i == '1') {
				
			newNote = "C";
				
		}
			
		else if (gString == "B" && i == '2') {
				
			newNote = "C#";
				
		}
		
		else if (gString == "B" && i == '3') {
			
			newNote = "D";
		}
		
		else if (gString == "B" && i == '4') {
			
			newNote = "D#";
		}
		
		else if (gString == "B" && i == '5') {
			
			newNote = "E";
		}
		
		else if (gString == "B" && i == '6') {
			
			newNote = "F";
		}
		
		else if (gString == "B" && i == '7') {
			
			newNote = "F#";
		}
		
		else if (gString == "B" && i == '8') {
			
			newNote = "G";
		}
		
		else if (gString == "B" && i == '9') {
			
			newNote = "G#";
		}
		
			//G STRING
		if(gString == "G" && i == '0') {
			
			newNote = "G";
			
		}
			
		else if (gString == "G" && i == '1') {
				
			newNote = "G#";
				
		}
			
		else if (gString == "G" && i == '2') {
				
			newNote = "A";
				
		}
		
		else if (gString == "G" && i == '3') {
			
			newNote = "A#";
		}
		
		else if (gString == "G" && i == '4') {
			
			newNote = "B";
		}
		
		else if (gString == "G" && i == '5') {
			
			newNote = "C";
		}
		
		else if (gString == "G" && i == '6') {
			
			newNote = "C#";
		}
		
		else if (gString == "G" && i == '7') {
			
			newNote = "D";
		}
		
		else if (gString == "G" && i == '8') {
			
			newNote = "D#";
		}
		
		else if (gString == "G" && i == '9') {
			
			newNote = "E";
		}
		
			//D STRING
		
		if(gString == "D" && i == '0') {
			
			newNote = "D";
			
		}
			
		else if (gString == "D" && i == '1') {
				
			newNote = "D#";
				
		}
			
		else if (gString == "D" && i == '2') {
				
			newNote = "E";
				
		}
		
		else if (gString == "D" && i == '3') {
			
			newNote = "F";
		}
		
		else if (gString == "D" && i == '4') {
			
			newNote = "F#";
		}
		
		else if (gString == "D" && i == '5') {
			
			newNote = "G";
		}
		
		else if (gString == "D" && i == '6') {
			
			newNote = "G#";
		}
		
		else if (gString == "D" && i == '7') {
			
			newNote = "A";
		}
		
		else if (gString == "D" && i == '8') {
			
			newNote = "A#";
		}
		
		else if (gString == "D" && i == '9') {
			
			newNote = "B";
		}
		
			//A string
		
		if(gString == "A" && i == '0') {
			
			newNote = "A";
			
		}
			
		else if (gString == "A" && i == '1') {
				
			newNote = "A#";
				
		}
			
		else if (gString == "A" && i == '2') {
				
			newNote = "B";
				
		}
		
		else if (gString == "A" && i == '3') {
			
			newNote = "C";
		}
		
		else if (gString == "A" && i == '4') {
			
			newNote = "C#";
		}
		
		else if (gString == "A" && i == '5') {
			
			newNote = "D";
		}
		
		else if (gString == "A" && i == '6') {
			
			newNote = "D#";
		}
		
		else if (gString == "A" && i == '7') {
			
			newNote = "E";
		}
		
		else if (gString == "A" && i == '8') {
			
			newNote = "F";
		}
		
		else if (gString == "A" && i == '9') {
			
			newNote = "F#";
		}
		
			//E string
		
		if(gString == "E" && i == '0') {
			
			newNote = "E";
			
		}
			
		else if (gString == "E" && i == '1') {
				
			newNote = "F";
				
		}
			
		else if (gString == "E" && i == '2') {
				
			newNote = "F#";
				
		}
		
		else if (gString == "E" && i == '3') {
			
			newNote = "G";
		}
		
		else if (gString == "E" && i == '4') {
			
			newNote = "G#";
		}
		
		else if (gString == "E" && i == '5') {
			
			newNote = "A";
		}
		
		else if (gString == "E" && i == '6') {
			
			newNote = "A#";
		}
		
		else if (gString == "E" && i == '7') {
			
			newNote = "B";
		}
		
		else if (gString == "E" && i == '8') {
			
			newNote = "C";
		}
		
		else if (gString == "E" && i == '9') {
			
			newNote = "C#";
		}


		
	return newNote;
	}
		
		
	public String tOrB() {
			
		String pogChamp = "pogChamp";
		
			
		return pogChamp;
	}
}
	
	
