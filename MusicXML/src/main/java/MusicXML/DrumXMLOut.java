package MusicXML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

import javafx.util.Pair;

import org.w3c.dom.DOMImplementation;

public class DrumXMLOut {

	private File outputFile;
	private Document doc;
	private Element mes;
	private int measureNum;
	private Element part;
	private Attr num;

	public DrumXMLOut() {
	}

	public File convertToXML(File inputFile) {

		DrumFileScanner readFile = new DrumFileScanner(inputFile);
		ArrayList<String[]> staffs = readFile.getDStaffs();
		measureNum = 1;

		try {
			// ========================================================================================
			// document header code - mostly unchanged until final submission
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			doc = docBuilder.newDocument();

			// <score-partwise>
			Element scorePartwise = doc.createElement("score-partwise");
			doc.appendChild(scorePartwise);

			Attr version = doc.createAttribute("version");
			version.setValue("3.1");
			scorePartwise.setAttributeNode(version);

			Element partList = doc.createElement("part-list");
			scorePartwise.appendChild(partList);

			Element scorePart = doc.createElement("score-part");
			partList.appendChild(scorePart);

			Attr id2 = doc.createAttribute("id");
			id2.setValue("P1");
			scorePart.setAttributeNode(id2);

			Element partName = doc.createElement("part-name");
			partName.appendChild(doc.createTextNode("DrumSet")); // Music name --- Up for change
			scorePart.appendChild(partName);
			
			Element score1 = doc.createElement("score-insrument");
			scorePart.appendChild(score1);
			
			Attr newID = doc.createAttribute("id");
			newID.setValue("P1-I36");
			score1.setAttributeNode(newID);
			
			Element in1 = doc.createElement("instrument-name");
			in1.appendChild(doc.createTextNode("Bass Drum"));
			score1.appendChild(in1);
			
			Element score2 = doc.createElement("score-insrument");
			scorePart.appendChild(score2);
			
			Attr newID2 = doc.createAttribute("id");
			newID2.setValue("P1-I37");
			score2.setAttributeNode(newID2);
			
			Element in2 = doc.createElement("instrument-name");
			in2.appendChild(doc.createTextNode("Bass Drum 2"));
			score2.appendChild(in2);
			
			Element score3 = doc.createElement("score-insrument");
			scorePart.appendChild(score3);
			
			Attr newID3 = doc.createAttribute("id");
			newID3.setValue("P1-I38");
			score3.setAttributeNode(newID3);
			
			Element in3 = doc.createElement("instrument-name");
			in3.appendChild(doc.createTextNode("Side Stick"));
			score3.appendChild(in3);
			
			Element score4 = doc.createElement("score-insrument");
			scorePart.appendChild(score4);
			
			Attr newID4 = doc.createAttribute("id");
			newID4.setValue("P1-I39");
			score4.setAttributeNode(newID4);
			
			Element in4 = doc.createElement("instrument-name");
			in4.appendChild(doc.createTextNode("Snare"));
			score4.appendChild(in4);
			
			Element score5 = doc.createElement("score-insrument");
			scorePart.appendChild(score5);
			
			Attr newID5 = doc.createAttribute("id");
			newID5.setValue("P1-I42");
			score5.setAttributeNode(newID5);
			
			Element in5 = doc.createElement("instrument-name");
			in5.appendChild(doc.createTextNode("Low Floor Tom"));
			score5.appendChild(in5);
			
			Element score6 = doc.createElement("score-insrument");
			scorePart.appendChild(score6);
			
			Attr newID6 = doc.createAttribute("id");
			newID6.setValue("P1-I43");
			score6.setAttributeNode(newID6);
			
			Element in6 = doc.createElement("instrument-name");
			in6.appendChild(doc.createTextNode("Closed Hi-Hat"));
			score6.appendChild(in6);
			
			Element score7 = doc.createElement("score-insrument");
			scorePart.appendChild(score7);
			
			Attr newID7 = doc.createAttribute("id");
			newID7.setValue("P1-I44");
			score7.setAttributeNode(newID7);
			
			Element in7 = doc.createElement("instrument-name");
			in7.appendChild(doc.createTextNode("High Floor Tom"));
			score7.appendChild(in7);
			
			Element score8 = doc.createElement("score-insrument");
			scorePart.appendChild(score8);
			
			Attr newID8 = doc.createAttribute("id");
			newID8.setValue("P1-I45");
			score8.setAttributeNode(newID8);
			
			Element in8 = doc.createElement("instrument-name");
			in8.appendChild(doc.createTextNode("Pedal Hi-Hat"));
			score8.appendChild(in8);
			
			Element score9 = doc.createElement("score-insrument");
			scorePart.appendChild(score9);
			
			Attr newID9 = doc.createAttribute("id");
			newID9.setValue("P1-I46");
			score9.setAttributeNode(newID9);
			
			Element in9 = doc.createElement("instrument-name");
			in9.appendChild(doc.createTextNode("Low Tom"));
			score9.appendChild(in9);
			
			Element score10 = doc.createElement("score-insrument");
			scorePart.appendChild(score10);
			
			Attr newID10 = doc.createAttribute("id");
			newID10.setValue("P1-I47");
			score10.setAttributeNode(newID10);
			
			Element in10 = doc.createElement("instrument-name");
			in10.appendChild(doc.createTextNode("Open Hi-Hat"));
			score10.appendChild(in10);
			
			Element score11 = doc.createElement("score-insrument");
			scorePart.appendChild(score11);
			
			Attr newID11 = doc.createAttribute("id");
			newID11.setValue("P1-I48");
			score11.setAttributeNode(newID11);
			
			Element in11 = doc.createElement("instrument-name");
			in11.appendChild(doc.createTextNode("Low-Mid Tom"));
			score8.appendChild(in11);
			
			Element score12 = doc.createElement("score-insrument");
			scorePart.appendChild(score12);
			
			Attr newID12 = doc.createAttribute("id");
			newID12.setValue("P1-I49");
			score12.setAttributeNode(newID12);
			
			Element in12 = doc.createElement("instrument-name");
			in12.appendChild(doc.createTextNode("Hi-Mid Tom"));
			score12.appendChild(in12);
			
			Element score13 = doc.createElement("score-insrument");
			scorePart.appendChild(score13);
			
			Attr newID13 = doc.createAttribute("id");
			newID13.setValue("P1-I50");
			score13.setAttributeNode(newID13);
			
			Element in13 = doc.createElement("instrument-name");
			in13.appendChild(doc.createTextNode("Crash Cymbal"));
			score13.appendChild(in13);
			
			Element score14 = doc.createElement("score-insrument");
			scorePart.appendChild(score14);
			
			Attr newID14 = doc.createAttribute("id");
			newID14.setValue("P1-I51");
			score14.setAttributeNode(newID14);
			
			Element in14 = doc.createElement("instrument-name");
			in14.appendChild(doc.createTextNode("High Tom"));
			score14.appendChild(in14);
			
			Element score15 = doc.createElement("score-insrument");
			scorePart.appendChild(score15);
			
			Attr newID15 = doc.createAttribute("id");
			newID15.setValue("P1-I52");
			score15.setAttributeNode(newID15);
			
			Element in15 = doc.createElement("instrument-name");
			in15.appendChild(doc.createTextNode("Ride Cymbal 1"));
			score15.appendChild(in15);
			
			Element score16 = doc.createElement("score-insrument");
			scorePart.appendChild(score16);
			
			Attr newID16 = doc.createAttribute("id");
			newID16.setValue("P1-I53");
			score16.setAttributeNode(newID16);
			
			Element in16 = doc.createElement("instrument-name");
			in16.appendChild(doc.createTextNode("Chinese Cymbal"));
			score16.appendChild(in16);
			
			Element score17 = doc.createElement("score-insrument");
			scorePart.appendChild(score17);
			
			Attr newID17 = doc.createAttribute("id");
			newID17.setValue("P1-I54");
			score17.setAttributeNode(newID17);
			
			Element in17 = doc.createElement("instrument-name");
			in17.appendChild(doc.createTextNode("Ride Bell"));
			score17.appendChild(in17);
			
			Element score18 = doc.createElement("score-insrument");
			scorePart.appendChild(score18);
			
			Attr newID18 = doc.createAttribute("id");
			newID18.setValue("P1-I55");
			score18.setAttributeNode(newID18);
			
			Element in18 = doc.createElement("instrument-name");
			in18.appendChild(doc.createTextNode("Tambourine"));
			score18.appendChild(in18);
			
			Element score19 = doc.createElement("score-insrument");
			scorePart.appendChild(score19);
			
			Attr newID19 = doc.createAttribute("id");
			newID19.setValue("P1-I56");
			score19.setAttributeNode(newID19);
			
			Element in19 = doc.createElement("instrument-name");
			in19.appendChild(doc.createTextNode("Splash Cymbal"));
			score19.appendChild(in19);
			
			Element score20 = doc.createElement("score-insrument");
			scorePart.appendChild(score20);
			
			Attr newID20 = doc.createAttribute("id");
			newID20.setValue("P1-I57");
			score20.setAttributeNode(newID20);
			
			Element in20 = doc.createElement("instrument-name");
			in20.appendChild(doc.createTextNode("Cowbell"));
			score20.appendChild(in20);
			
			Element score21 = doc.createElement("score-insrument");
			scorePart.appendChild(score21);
			
			Attr newID21 = doc.createAttribute("id");
			newID21.setValue("P1-I58");
			score21.setAttributeNode(newID21);
			
			Element in21 = doc.createElement("instrument-name");
			in21.appendChild(doc.createTextNode("Crash Cymbal 2"));
			score21.appendChild(in21);
			
			Element score22 = doc.createElement("score-insrument");
			scorePart.appendChild(score22);
			
			Attr newID22 = doc.createAttribute("id");
			newID22.setValue("P1-I60");
			score22.setAttributeNode(newID22);
			
			Element in22 = doc.createElement("instrument-name");
			in22.appendChild(doc.createTextNode("Ride Cymbal 2"));
			score22.appendChild(in22);
			
			Element score23 = doc.createElement("score-insrument");
			scorePart.appendChild(score23);
			
			Attr newID23 = doc.createAttribute("id");
			newID23.setValue("P1-I64");
			score23.setAttributeNode(newID23);
			
			Element in23 = doc.createElement("instrument-name");
			in23.appendChild(doc.createTextNode("Open Hi Conga"));
			score23.appendChild(in23);
			
			Element score24 = doc.createElement("score-insrument");
			scorePart.appendChild(score24);
			
			Attr newID24 = doc.createAttribute("id");
			newID24.setValue("P1-I65");
			score24.setAttributeNode(newID24);
			
			Element in24 = doc.createElement("instrument-name");
			in24.appendChild(doc.createTextNode("Low Conga"));
			score24.appendChild(in24);
			

			/*
			 * ============================================================================
			 * <part id>
			 */
			part = doc.createElement("part");
			scorePartwise.appendChild(part);

			Attr id = doc.createAttribute("id");
			id.setValue("P1");
			part.setAttributeNode(id);

			/*
			 * ============================================================================
			 * <note>
			 */
			for (int s = 0; s < staffs.size(); s++) {
				DrumMeasures measures = new DrumMeasures(staffs.get(s));
				DrumKeys keys = new DrumKeys(staffs.get(s));

				for (int i = 0; i < measures.getMeasures().size(); i++) {
					/*
					 * ============================================================================
					 * calling other classes
					 */
					DrumNotes notes = new DrumNotes(measures.getMeasures().get(i));

					// note mapping
					Map<Pair<Integer, Integer>, List<Character>> notesMap = notes.getNotesMapping();

					// duration mapping
					DrumDuration duration = new DrumDuration(notesMap,
							measures.getMeasureSpaces(measures.getMeasures().get(i)));

					/*
					 * ============================================================================
					 * <measure number>
					 */
					if (measureNum == 1) {
						createXMLMeasure();
						createXMLAttribute();
					} else {
						createXMLMeasure();
					}

					Integer prevIndex = -1;
					// get notes and their attributes
					for (Map.Entry<Pair<Integer, Integer>, List<Character>> entry : notesMap.entrySet()) {
						Integer index = entry.getKey().getKey();
						Integer gString = entry.getKey().getValue();
						List<Character> value = entry.getValue();

						for (int n = 0; n < value.size(); n++) {
							/*
							 * ============================================================================
							 * <note>
							 */
							char noteNum = value.get(n);

							Element note = doc.createElement("note");
							mes.appendChild(note);

							// <chord>
							if (prevIndex >= 0 && index == prevIndex && n < 1) {
								Element chord = doc.createElement("chord");
								note.appendChild(chord);
							}

							// <grace>
							int keepmod = noteNum;
							if (noteNum >= 100) {
								Element grace = doc.createElement("grace");
								note.appendChild(grace);

								noteNum = (char) (value.get(n) - 100);
							}

							// <pitch>
							Element pitch = doc.createElement("unpitched");
							note.appendChild(pitch);

							Element step = doc.createElement("display-step");
							step.appendChild(doc.createTextNode(notes.getNote(keys.getKeyInString(gString), noteNum)));
							pitch.appendChild(step);


							// <octave>
							Element octave = doc.createElement("display-octave");
							octave.appendChild(doc.createTextNode(String.valueOf(notes.getOctave(gString, noteNum)))); // automated
							pitch.appendChild(octave);

							// <duration>
							if (keepmod >= 100) {
								// do nothing, grace notes have no duration
							} else {
								Element dur = doc.createElement("duration");
								dur.appendChild(doc.createTextNode(duration.getDuration(index).toString())); // automated
								note.appendChild(dur);
							}

							// <voice>
							Element voice = doc.createElement("voice");
							voice.appendChild(doc.createTextNode("1")); // Change for later automation
							note.appendChild(voice);

							if (keepmod >= 100) {
								// <stem>
								Element stem = doc.createElement("stem");
								stem.appendChild(doc.createTextNode("none")); // Change for later automation
								note.appendChild(stem);
							} else {
								// <type>
								Element type = doc.createElement("type");
								type.appendChild(doc.createTextNode(duration.getType(duration.getDuration(index)))); // automated
								note.appendChild(type);
							}

							// <dot>
							if (duration.isDot(duration.getDuration(index))) {
								Element dot = doc.createElement("dot");
								note.appendChild(dot);
							}

							// <notations>
							Element notations = doc.createElement("notations");
							note.appendChild(notations);

							// <technical>
							Element technical = doc.createElement("technical");
							notations.appendChild(technical);

							// <string>
							Element string = doc.createElement("string");
							string.appendChild(doc.createTextNode(String.valueOf(gString + 1)));
							technical.appendChild(string);

							// <fret>
							Element fret = doc.createElement("fret");
							fret.appendChild(doc.createTextNode(String.valueOf(noteNum)));
							technical.appendChild(fret);

							prevIndex = entry.getKey().getKey();
						}
					}
				}
				// <barline location>
				Element barline = doc.createElement("barline");
				mes.appendChild(barline);

				Attr loc = doc.createAttribute("location");
				loc.setValue("right");
				barline.setAttributeNode(loc);

				// <bar-style>
				Element style = doc.createElement("bar-style");
				style.appendChild(doc.createTextNode("light-heavy"));
				barline.appendChild(style);
			}

			// ========================================================================================
			// document export code

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// doc type
			DOMImplementation domImpl = doc.getImplementation();
			DocumentType doctype = domImpl.createDocumentType("doctype", "-//Recordare//DTD MusicXML 3.1 Partwise//EN",
					"http://www.musicxml.org/dtds/partwise.dtd");

			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());

			DOMSource source = new DOMSource(doc);
			outputFile = new File("XMLOut_Export.xml");
			StreamResult result = new StreamResult(outputFile);

			transformer.transform(source, result);
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		return outputFile;
	}

	private void createXMLAttribute() {
		// <attribute>
		Element att = doc.createElement("attributes");
		mes.appendChild(att);

		// <divisions>
		Element div = doc.createElement("divisions");
		div.appendChild(doc.createTextNode("2")); // Change division
		att.appendChild(div);

		/*
		 * ============================================================================
		 * <key> (fifths)
		 */
		Element key = doc.createElement("key");
		att.appendChild(key);

		Element fifth = doc.createElement("fifths");
		fifth.appendChild(doc.createTextNode("0")); // Change fifth
		key.appendChild(fifth);

		/*
		 * ============================================================================
		 * <time> (beats, beat-type)
		 */
		Element time = doc.createElement("time");
		att.appendChild(time);

		Element beats = doc.createElement("beats");
		beats.appendChild(doc.createTextNode("4")); // Change beats
		time.appendChild(beats);

		Element beatsType = doc.createElement("beat-type");
		beatsType.appendChild(doc.createTextNode("4")); // Change beat-type
		time.appendChild(beatsType);

		/*
		 * ============================================================================
		 * <clef> (sign, line)
		 */
		Element clef = doc.createElement("clef");
		att.appendChild(clef);

		Element sign = doc.createElement("sign");
		sign.appendChild(doc.createTextNode("percusion")); // SIGN HAS BEEN CHANGED TO TAB SINCE WE ARE READING TABS
		clef.appendChild(sign);

		Element line = doc.createElement("line");
		line.appendChild(doc.createTextNode("2")); // Change later for automation
		clef.appendChild(line);

		/*
		 * ============================================================================
		 * <staff-details> (staff lines, staff tuning --> tuning-step, tuning-octave)
		 */
	}

	private void createXMLMeasure() {
		mes = doc.createElement("measure");
		part.appendChild(mes);

		num = doc.createAttribute("number");
		num.setValue(String.valueOf(measureNum));
		mes.setAttributeNode(num);

		// update measureNum
		measureNum++;
	}
}