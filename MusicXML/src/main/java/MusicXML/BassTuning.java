package MusicXML;

public class BassTuning {
	private char[] tuningStep = new char[6];
	private int tuningOctave;
	private int staffLines;
	
	public BassTuning() {
		tuningStep[0] = 'E';
		tuningStep[1] = 'A';
		tuningStep[2] = 'D';
		tuningStep[3] = 'G';
		
		staffLines = 4;
	}
	
	public String getStaffLines() {
		return String.valueOf(staffLines);
	}
	
	public String getTuningStep(int index) {
		return String.valueOf(tuningStep[index]);
	}
	
	public String getTuningOctave(int index) {
		if(index == 0 || index == 1) tuningOctave = 1;
		else if(index == 2 || index == 3) tuningOctave = 2;
		else tuningOctave = -1;		//for debugging purposes
		
		return String.valueOf(tuningOctave);
	}
	
}