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
		ArrayList<List<String>> staffs = readFile.getDrumStaffs();
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
			Attr id = doc.createAttribute("id");

			id.setValue("P1");
			scorePart.setAttributeNode(id);

			Element partName = doc.createElement("part-name");
			partName.appendChild(doc.createTextNode("DrumSet"));
			scorePart.appendChild(partName);

			Drumset set = new Drumset();
			for (int i = 0; i < set.drumset.size(); i++) {
				Element scoreInstr = doc.createElement("score-instrument");
				scorePart.appendChild(scoreInstr);
				Attr id_instr = doc.createAttribute("id");

				id_instr.setValue(set.drumset.get(i).getKey()); // id in key of drumset Pair<key, value>
				scoreInstr.setAttributeNode(id_instr);

				Element instrName = doc.createElement("instrument-name");
				instrName.appendChild(doc.createTextNode(set.drumset.get(i).getValue())); // id in value of drumset
																							// Pair<key, value>
				scoreInstr.appendChild(instrName);
			}

			/*
			 * ============================================================================
			 * <part id>
			 */

			part = doc.createElement("part");
			scorePartwise.appendChild(part);

			Attr id2 = doc.createAttribute("id");
			id2.setValue("P1");
			part.setAttributeNode(id2);

			/*
			 * ============================================================================
			 * <note>
			 */
			for (int s = 0; s < staffs.size(); s++) {
				DrumMeasures measures = new DrumMeasures(staffs.get(s));
				DrumInstrument keys = new DrumInstrument(staffs.get(s));

				for (int i = 0; i < measures.getMeasures().size(); i++) {
					/*
					 * ============================================================================
					 * calling other classes
					 */
					DrumNotes notes = new DrumNotes(measures.getMeasures().get(i));

					// note mapping
					Map<Pair<Integer, Integer>, List<Character>> notesMap = notes.getNotesMapping();
					Map<Pair<Integer, Integer>, List<Character>> notesMapLow = notes.getNotesLowMapping();

					// duration mapping
					DrumDuration duration = new DrumDuration(notesMap,
							measures.getMeasureSpaces(measures.getMeasures().get(i)));
					DrumDuration durationLow = new DrumDuration(notesMapLow,
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
					int beam = 0;
					Element beam_status;
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

							// <pitch>
							Element pitch = doc.createElement("unpitched");
							note.appendChild(pitch);

							Element step = doc.createElement("display-step");
							step.appendChild(doc.createTextNode(notes.getStep(keys.getInstrInString(gString))));
							pitch.appendChild(step);

							// <octave>
							Element octave = doc.createElement("display-octave");
							octave.appendChild(doc
									.createTextNode(String.valueOf(notes.getOctave(keys.getInstrInString(gString))))); // automated
							pitch.appendChild(octave);

							// <duration>
							Element dur = doc.createElement("duration");
							dur.appendChild(doc.createTextNode(duration.getDuration(index).toString())); // automated
							note.appendChild(dur);

							// <instrument>
							Element instr = doc.createElement("instrument");
							note.appendChild(instr);
							Attr id3 = doc.createAttribute("id");
							id3.setValue(keys.getInstrID(keys.getInstrInString(gString), set.drumsetTab));
							instr.setAttributeNode(id3);

							// <voice>
							Element voice = doc.createElement("voice");
							voice.appendChild(doc.createTextNode("1")); // Change for later automation
							note.appendChild(voice);

							// <type>
							Element type = doc.createElement("type");
							type.appendChild(doc.createTextNode(duration.getType(duration.getDuration(index)))); // automated
							note.appendChild(type);

							// <stem>
							Element stem = doc.createElement("stem");
							stem.appendChild(doc.createTextNode("up")); // Change for later automation
							note.appendChild(stem);

							// <beam>
							if (!(prevIndex >= 0 && index == prevIndex && n < 1)) { // not chord
								if (duration.getType(duration.getDuration(index)).equals("eighth")
										|| duration.getType(duration.getDuration(index)).equals("16th")) {

									beam++;
									// beam 1
									Element beam1 = doc.createElement("beam");
									note.appendChild(beam1);

									Attr number1 = doc.createAttribute("number");
									number1.setValue("1");
									beam1.setAttributeNode(number1);

									if (beam == 1)
										beam1.appendChild(doc.createTextNode("begin"));
									else if (beam == 2 || beam == 3)
										beam1.appendChild(doc.createTextNode("continue"));
									else
										beam1.appendChild(doc.createTextNode("end"));

									if (duration.getType(duration.getDuration(index)).equals("16th")) {
										// beam 2
										Element beam2 = doc.createElement("beam");
										note.appendChild(beam2);

										Attr number2 = doc.createAttribute("number");
										number2.setValue("2");
										beam2.setAttributeNode(number2);
										
										if (beam == 1)
											beam2.appendChild(doc.createTextNode("begin"));
										else if (beam == 2 || beam == 3)
											beam2.appendChild(doc.createTextNode("continue"));
										else
											beam2.appendChild(doc.createTextNode("end"));
									}

									if (beam == 4)
										beam = 0;
								}
							}
							// <dot>
							if (duration.isDot(duration.getDuration(index))) {
								Element dot = doc.createElement("dot");
								note.appendChild(dot);
							}

							// <notehead>
							if (noteNum == 'x' || noteNum == 'X') {
								Element notehead = doc.createElement("notehead");
								notehead.appendChild(doc.createTextNode("x"));
								note.appendChild(notehead);
							}

							prevIndex = entry.getKey().getKey();
						}
					}

					// <backup>
					Element backup = doc.createElement("backup");
					mes.appendChild(backup);

					Element dur_backup = doc.createElement("duration");
					dur_backup.appendChild(doc.createTextNode("16"));
					backup.appendChild(dur_backup);

					// low map
					for (Map.Entry<Pair<Integer, Integer>, List<Character>> entry : notesMapLow.entrySet()) {
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

							// <pitch>
							Element pitch = doc.createElement("unpitched");
							note.appendChild(pitch);

							Element step = doc.createElement("display-step");
							step.appendChild(doc.createTextNode(notes.getStep(keys.getInstrInString(gString))));
							pitch.appendChild(step);

							// <octave>
							Element octave = doc.createElement("display-octave");
							octave.appendChild(doc
									.createTextNode(String.valueOf(notes.getOctave(keys.getInstrInString(gString))))); // automated
							pitch.appendChild(octave);

							// <duration>
							Element dur = doc.createElement("duration");
							dur.appendChild(doc.createTextNode(durationLow.getDuration(index).toString())); // automated
							note.appendChild(dur);

							// <instrument>
							Element instr = doc.createElement("instrument");
							note.appendChild(instr);
							Attr id3 = doc.createAttribute("id");
							id3.setValue(keys.getInstrID(keys.getInstrInString(gString), set.drumsetTab));
							instr.setAttributeNode(id3);

							// <voice>
							Element voice = doc.createElement("voice");
							voice.appendChild(doc.createTextNode("1")); // Change for later automation
							note.appendChild(voice);

							// <type>
							Element type = doc.createElement("type");
							type.appendChild(doc.createTextNode(durationLow.getType(durationLow.getDuration(index)))); // automated
							note.appendChild(type);

							// <stem>
							Element stem = doc.createElement("stem");
							stem.appendChild(doc.createTextNode("down")); // Change for later automation
							note.appendChild(stem);

							// <dot>
							if (durationLow.isDot(durationLow.getDuration(index))) {
								Element dot = doc.createElement("dot");
								note.appendChild(dot);
							}

							// <notehead>
							if (noteNum == 'x' || noteNum == 'X') {
								Element notehead = doc.createElement("notehead");
								notehead.appendChild(doc.createTextNode("x"));
								note.appendChild(notehead);
							}

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
		div.appendChild(doc.createTextNode("4")); // Change division
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
		sign.appendChild(doc.createTextNode("percussion")); // SIGN HAS BEEN CHANGED TO TAB SINCE WE ARE READING TABS
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