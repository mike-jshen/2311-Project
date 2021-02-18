package MusicXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLOut {
	
	private File outputFile;
	
	public XMLOut() {
	}
	
	public File convertToXML(File inputFile) {
		 
		FileScanner readFile = new FileScanner(inputFile);
		ArrayList <String[]> staffs = readFile.getStaffs();
		int measureNum = 0;
		
		try {
			//========================================================================================
			// document header code - mostly unchanged until final submission
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			Document doc = docBuilder.newDocument();
	        
			Element rootElement = doc.createElement("score-partwise");
	        doc.appendChild(rootElement);
	        
	        Element partList = doc.createElement("part-list");
	        rootElement.appendChild(partList);
	        
	        Element scorePart = doc.createElement("score-part");
	        partList.appendChild(scorePart);
	        
	        Attr scorePart_id = doc.createAttribute("id");
	        scorePart_id.setValue("P1");
	        scorePart.setAttributeNode(scorePart_id);
	        
	        Element partName = doc.createElement("part-name");
	        partName.appendChild(doc.createTextNode("Music")); //Music name --- Up for change
	        scorePart.appendChild(partName);
	        
	        Element part = doc.createElement("part");
	        rootElement.appendChild(part);

	        Attr part_id = doc.createAttribute("id");
	        part_id.setValue("P1");
	        part.setAttributeNode(part_id);
	        
	        // measure elements
	        Element mesure = doc.createElement("measure");
	        part.appendChild(mesure);
	        
	        Attr num = doc.createAttribute("number");
	        num.setValue("0");
	        mesure.setAttributeNode(num);
	        
	        // attributes elements
	        Element attr = doc.createElement("attributes");
	        mesure.appendChild(attr);

	        // divisions elements
	        Element div = doc.createElement("divisions");
	        div.appendChild(doc.createTextNode("2")); //Change later for automation
	        attr.appendChild(div);

	        // key elements
	        Element key = doc.createElement("key");
	        attr.appendChild(key);
	        
	        Element fifth = doc.createElement("fifths");
	        fifth.appendChild(doc.createTextNode("0")); //Change later for automation
	        key.appendChild(fifth);

	        // time elements
	        Element time = doc.createElement("time");
	        attr.appendChild(time);
	        
	        Element beats = doc.createElement("beats");
	        beats.appendChild(doc.createTextNode("4")); //Change later for automation
	        time.appendChild(beats);
	        
	        Element beatsType = doc.createElement("beat-type");
	        beatsType.appendChild(doc.createTextNode("4")); //Change later for automation
	        time.appendChild(beatsType);

	        Element clef = doc.createElement("clef");
	        attr.appendChild(clef);
	        
	        Element sign = doc.createElement("sign");
	        sign.appendChild(doc.createTextNode("G")); //Change later for automation - Currently Treble Clef (aka G Clef)
	        clef.appendChild(sign);
	    
	        Element line = doc.createElement("line");
	        line.appendChild(doc.createTextNode("2")); //Change later for automation
	        clef.appendChild(line);
	        
	        //========================================================================================
			// mid-term submission changes occur here
	        
			
			for(int s = 0; s < staffs.size(); s++) {
				Measures measures = new Measures(staffs.get(s));
				Keys keys = new Keys(staffs.get(s));
				
				for(int i = 0; i < measures.getMeasures().size(); i++) {
					Notes notes = new Notes(measures.getMeasures().get(i));
					
					// note mapping 
					Map<Integer, List<Character>> notesMap = notes.notesMapping();
					
					// duration mapping
					Duration duration = new Duration(notesMap, measures.getMeasureSpaces(measures.getMeasures().get(i)));
					
					// look through vertical array list to find notes
					for(int j = 0; j < notes.vertical.size(); j++) {
						for(int k = 0; k < 6; k++) {
							if(Character.isDigit(notes.vertical.get(j)[k])) {
								
								// at the discovery of a note, append the note with pitch, duration, and type
								Element note = doc.createElement("note");
						        mesure.appendChild(note);
						        
						        // set chord if another note is in the same vertical
						        if(notesMap.get(Integer.valueOf(j)).size() > 1) {
						        	Element chord = doc.createElement("chord");
							        note.appendChild(chord);
						        }
						        
						        Element pitch = doc.createElement("pitch");
						        note.appendChild(pitch);
						        
						        Element step = doc.createElement("step");
						        step.appendChild(doc.createTextNode(notes.getNote(keys.getKeyInString(k), notes.vertical.get(j)[k])));
						        pitch.appendChild(step);
						        
						        Element octave = doc.createElement("octave");
						        octave.appendChild(doc.createTextNode("4")); //Change later for automation
						        pitch.appendChild(octave);
						        
						        Element dur = doc.createElement("duration");
						        dur.appendChild(doc.createTextNode(duration.getNoteDuration(j).toString())); //Change later for automation
						        note.appendChild(dur);

						        Element type = doc.createElement("type");
						        type.appendChild(doc.createTextNode(duration.getType(duration.getNoteDuration(j)))); //Change later for automation
						        note.appendChild(type);
						        
						        duration.getType(duration.getNoteDuration(j));
						        if(duration.dot == true) {
						        	Element dot = doc.createElement("dot");
							        note.appendChild(dot);
						        }
							}
						}
					}
					
					if(measureNum < (staffs.size() * measures.getMeasures().size() - 1)) {
						// create new measure
						measureNum++;
						mesure = doc.createElement("measure");
						part.appendChild(mesure);
					        
					    num = doc.createAttribute("number");
					    num.setValue(Integer.toString(measureNum));
					    mesure.setAttributeNode(num);
					}
				}
			}
			
			//========================================================================================
			// document export code
			
			 TransformerFactory transformerFactory = TransformerFactory.newInstance();
		     Transformer transformer = transformerFactory.newTransformer();
		     DOMSource source = new DOMSource(doc);
		     outputFile = new File("XMLOut_Export.xml");
		     StreamResult result = new StreamResult(outputFile);
		     
		     transformer.transform(source, result);
		}
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		return outputFile;
	}
}
