package MusicXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javafx.util.Pair;

public class DrumDuration {

	private Map<Integer, Integer> durationMap = new TreeMap<Integer, Integer>();
	private int difference;
	private boolean isDot = false;

	public DrumDuration(Map<Pair<Integer, Integer>, List<Character>> notesMap, int measureSpaces) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (Map.Entry<Pair<Integer, Integer>, List<Character>> entry : notesMap.entrySet()) {
			Integer index = entry.getKey().getKey();
			tmp.add(index);
		}
		
		for(int i = 0; i < tmp.size(); i++) {
			System.out.println("index = " + tmp.get(i));
		}

		for (int i = 0; i < tmp.size(); i++) {
			if (i == tmp.size() - 1) {
				difference = measureSpaces - tmp.get(i);
			} else {
				difference = tmp.get(i + 1) - tmp.get(i);
			}
			durationMap.put(tmp.get(i), timeDuration(difference, measureSpaces));
		}
	}

	/*
	 * This part only goes up to eighth notes To modify for sixteenth notes and
	 * beyond, modify timeDuration() and getType()
	 */
	private int timeDuration(int diff, int spaces) {
		int duration = 0;

		double r1 = spaces / 16.00;
		double r2 = 2 * spaces / 16.00;
		double r3 = 3 * spaces / 16.00;
		double r4 = 4 * spaces / 16.00;
		double r6 = 6 * spaces / 16.00;
		double r8 = 8 * spaces / 16.00;
		double r12 = 12 * spaces / 16.00;
		double r16 = 16 * spaces / 16.00;

		if (diff <= (int) r1) {
			duration = 1;
		} else if (diff <= (int) r2) {
			duration = 2;
		} else if (diff <= (int) r3) {
			duration = 3;
		} else if (diff <= (int) r4) {
			duration = 4;
		} else if (diff <= (int) r6) {
			duration = 6;
		} else if (diff <= (int) r8) {
			duration = 8;
		} else if (diff <= (int) r12) {
			duration = 12;
		} else if (diff <= (int) r16) {
			duration = 16;
		}
		else {
			duration = -1; // debug purposes
		}

		return duration;
	}

	public String getType(int dur) {
		String type = "";
		if (dur == 1) {
			type = "16th";
		} else if (dur == 2) {
			type = "eighth";
		} else if (dur == 3) {
			type = "eighth";
		} else if (dur == 4) {
			type = "quarter";
		} else if (dur == 6) {
			type = "quarter";
		} else if (dur == 8) {
			type = "half";
		} else if (dur == 12) {
			type = "half";
		} else if (dur == 16) {
			type = "whole";
		}

		return type;
	}

	public boolean isDot(int dur) {
		if (dur == 3 || dur == 6 || dur == 12)
			isDot = true;
		else
			isDot = false;
		return isDot;
	}

	public Integer getDuration(int index) {
		return durationMap.get(index);
	}

}