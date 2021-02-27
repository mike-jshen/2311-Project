package MusicXML;

public class GuitarTuning {
	private char[] tuningStep = new char[6];
	private int tuningOctave;
	private int staffLines;
	
	public GuitarTuning() {
		tuningStep[0] = 'E';
		tuningStep[1] = 'A';
		tuningStep[2] = 'D';
		tuningStep[3] = 'G';
		tuningStep[4] = 'B';
		tuningStep[5] = 'E';
		
		staffLines = 6;
	}
	
	public String getStaffLines() {
		return String.valueOf(staffLines);
	}
	
	public String getTuningStep(int index) {
		return String.valueOf(tuningStep[index]);
	}
	
	public String getTuningOctave(int index) {
		if(index == 0 || index == 1) tuningOctave = 2;
		else if(index == 2 || index == 3 || index == 4) tuningOctave = 3;
		else if(index == 5) tuningOctave = 4;
		else tuningOctave = -1;		//for debugging purposes
		
		return String.valueOf(tuningOctave);
	}
	
}