package MusicXML;

import java.util.ArrayList;
import java.util.List;

public class DrumMeasures {
	private ArrayList<List<String>> measureList = new ArrayList<List<String>>();

	public DrumMeasures(List<String> singleStaff) {
		ArrayList<String> tmpMeasure = new ArrayList<String>();
		List<String> singleMeasure = new ArrayList<String>();
		for (int i = 0; i < singleStaff.size(); i++) {
			String selectedLine = singleStaff.get(i);
			String lineWithoutKey = selectedLine.substring(3);

			String[] measures = lineWithoutKey.split("\\|");

			for (String measure : measures)
				tmpMeasure.add(measure);
		}

		for (int i = 0; i < tmpMeasure.size() / singleStaff.size(); i++) {

			for (int j = i; j < tmpMeasure.size(); j = j + tmpMeasure.size() / singleStaff.size()) {
				singleMeasure.add((j / (tmpMeasure.size() / singleStaff.size())), tmpMeasure.get(j));
			}
			ArrayList<String> cloned = new ArrayList<String>(singleMeasure);
			measureList.add(cloned);
			singleMeasure.clear();
		}
	}

	public ArrayList<List<String>> getMeasures() {
		return measureList;
	}

	public int getNumOfMeasures(List<String> singleStaff) {
		return measureList.size();
	}

	public int getMeasureSpaces(List<String> singleMeasure) {
		int measureSpaces = 0;
		char[] tmp = singleMeasure.get(0).toCharArray();
		for (int i = 0; i < tmp.length; i++) {
			measureSpaces++;
		}
		return measureSpaces;
	}

}
