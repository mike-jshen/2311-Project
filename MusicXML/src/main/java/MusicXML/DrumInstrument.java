package MusicXML;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class DrumInstrument {

	private String[] instrArr;

	public DrumInstrument(List<String> singleStaff) {
		instrArr = new String[singleStaff.size()];
		for (int i = 0; i < singleStaff.size(); i++) {
			char[] tmp = singleStaff.get(i).toCharArray();
			String instr = "" + tmp[0] + tmp[1];
			instrArr[i] = instr.replaceAll("\\s+", "");
			;
		}
	}

	public String[] getAllInstr() {
		return instrArr;
	}

	public String getInstrInString(int string) {
		String instr = this.instrArr[string];
		return instr;
	}

	public String getInstrID(String instr, ArrayList<Pair<String, String>> drumsetTab) {
		String id = "";
		for (int i = 0; i < drumsetTab.size(); i++) {
			if (drumsetTab.get(i).getKey().equals(instr)) {
				id = drumsetTab.get(i).getValue();
			}
		}
		return id;
	}

}
