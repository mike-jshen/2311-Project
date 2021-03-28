package MusicXML;

import java.io.File;

public class ConsoleDetectionTesting {

	public static void main(String[] args) {
		File file = new File("testTab.txt");	
		InstrumentDetection detect = new InstrumentDetection(file);
		System.out.println(detect.getDetectedInstrument());
	}

}
