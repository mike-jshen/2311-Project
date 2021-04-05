package MusicXML;

import java.util.ArrayList;
import javafx.util.Pair;

public class Drumset {
	ArrayList<Pair<String, String>> drumset = new ArrayList<Pair<String, String>>();
	ArrayList<Pair<String, String>> drumsetTab = new ArrayList<Pair<String, String>>();
	
	public Drumset() {
		drumset.add(new Pair<>("P1-I36", "Bass Drum 1"));
		drumset.add(new Pair<>("P1-I37", "Bass Drum 2"));
		drumset.add(new Pair<>("P1-I38", "Side Stick"));
		drumset.add(new Pair<>("P1-I39", "Snare"));
		drumset.add(new Pair<>("P1-I42", "Low Floor Tom"));
		drumset.add(new Pair<>("P1-I43", "Closed Hi-Hat"));
		drumset.add(new Pair<>("P1-I44", "High Floor Tom"));
		drumset.add(new Pair<>("P1-I45", "Pedal Hi-Hat"));
		drumset.add(new Pair<>("P1-I46", "Low Tom"));
		drumset.add(new Pair<>("P1-I47", "Open Hi-Hat"));
		drumset.add(new Pair<>("P1-I48", "Low-Mid Tom"));
		drumset.add(new Pair<>("P1-I49", "Hi-Mid Tom"));
		drumset.add(new Pair<>("P1-I50", "Crash Cymbal 1"));
		drumset.add(new Pair<>("P1-I51", "High Tom"));
		drumset.add(new Pair<>("P1-I52", "Ride Cymbal 1"));
		drumset.add(new Pair<>("P1-I53", "Chinese Cymbal"));
		drumset.add(new Pair<>("P1-I54", "Ride Bell"));
		drumset.add(new Pair<>("P1-I55", "Tambourine"));
		drumset.add(new Pair<>("P1-I56", "Splash Cymbal"));
		drumset.add(new Pair<>("P1-I57", "Cowbell"));
		drumset.add(new Pair<>("P1-I58", "Crash Cymbal 2"));
		drumset.add(new Pair<>("P1-I60", "Ride Cymbal 2"));
		drumset.add(new Pair<>("P1-I64", "Open Hi Conga"));
		drumset.add(new Pair<>("P1-I64", "Low Conga"));
		
		drumsetTab.add(new Pair<>("BD", "P1-I36"));
		drumsetTab.add(new Pair<>("KD", "P1-I36"));
		drumsetTab.add(new Pair<>("B", "P1-I36"));	
		drumsetTab.add(new Pair<>("SD", "P1-I39"));
		drumsetTab.add(new Pair<>("FT", "P1-I42"));
		drumsetTab.add(new Pair<>("HH", "P1-I43"));
		drumsetTab.add(new Pair<>("MT", "P1-I46"));
		drumsetTab.add(new Pair<>("HT", "P1-I48"));	
		drumsetTab.add(new Pair<>("CC", "P1-I50"));
		drumsetTab.add(new Pair<>("C", "P1-I50"));
		drumsetTab.add(new Pair<>("RC", "P1-I52"));
		drumsetTab.add(new Pair<>("R", "P1-I52"));
	}
		
}
