package MusicXML;

import java.util.ArrayList;

public class BassMeasures {
	private ArrayList<String[]> measureList = new ArrayList<String[]>();

	public BassMeasures(String[] singleStaff) {
		ArrayList<String> tmpMeasure = new ArrayList<String>();
		String[] singleMeasure = new String[4];
		for (int i = 0; i < 4; i++) {
			String selectedLine = singleStaff[i];
			String lineWithoutKey = selectedLine.substring(2);

			String[] measures = lineWithoutKey.split("\\|");

			for (String measure : measures)
				tmpMeasure.add(measure);
		}

		for (int i = 0; i < tmpMeasure.size() / 4; i++) {

			for (int j = i; j < tmpMeasure.size(); j = j + tmpMeasure.size() / 4) {
				singleMeasure[j / (tmpMeasure.size() / 4)] = tmpMeasure.get(j);

			}
			measureList.add(singleMeasure.clone());
		}
	}

	public ArrayList<String[]> getMeasures() {
		return measureList;
	}

	public int getNumOfMeasures(String[] singleStaff) {
		return measureList.size();
	}

	public int getMeasureSpaces(String[] singleMeasure) {
		int measureSpaces = 0;
		char[] tmp = singleMeasure[0].toCharArray();
		for (int i = 0; i < tmp.length; i++) {
			measureSpaces++;
		}
		return measureSpaces;
	}

}