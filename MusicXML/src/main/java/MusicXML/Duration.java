package MusicXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Duration {
	
	private Map<Integer, Integer> durationMap = new TreeMap<Integer, Integer>();
	private int difference;

	public Duration(Map<Integer, List<Character>> notesMap, int measureSpaces) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for(Map.Entry<Integer,List<Character>> entry : notesMap.entrySet()){
			Integer index = entry.getKey();  
			tmp.add(index);
		}
		
		for(int i = 0; i < tmp.size(); i++) {
			if(i == tmp.size() - 1) {
				difference = measureSpaces - tmp.get(i);
			}
			else {
				difference = tmp.get(i+1) - tmp.get(i);
			}
			durationMap.put(tmp.get(i), timeDuration(difference, measureSpaces));
		}
	}
	
	/*
	 * This part only goes up to quarter notes
	 * To modify for eighth notes and beyond, 
	 * modify timeDuration() and getType()
	 * 
	 * */
	private Integer timeDuration(int diff, int spaces) {
		int div = spaces / 4;
		Integer duration;
		
		if(diff <= div)
			duration = 1;
		else if(diff <= 2 * div)
			duration = 2;
		else if(diff <= 3 * div)
			duration = 3;
		else
			duration = 4;
		return duration;
	}
	
	public String getType(Integer dur) {
		String type = "";
		if(dur == 1)
			type = "quarter";
		else if(dur == 2)
			type = "half";
		else if(dur == 3)
			type = "half";
		else if(dur == 4)
			type = "whole";
		return type;
	}
	
	public Integer getNoteDuration(int index) {
		return durationMap.get(index);
	}
	
}
