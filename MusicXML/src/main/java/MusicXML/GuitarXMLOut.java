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

public class GuitarXMLOut {

	private File outputFile;
	private Document doc;
	private Element mes;
	private int measureNum;
	private Element part;
	private Attr num;

	public GuitarXMLOut() {
	}

	public File convertToXML(File inputFile) {

		GuitarFileScanner readFile = new GuitarFileScanner(inputFile);
		ArrayList<String[]> staffs = readFile.getStaffs();
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
			partName.appendChild(doc.createTextNode("Classical Guitar")); // Music name --- Up for change
			scorePart.appendChild(partName);

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
				GuitarMeasures measures = new GuitarMeasures(staffs.get(s));
				GuitarKeys keys = new GuitarKeys(staffs.get(s));

				for (int i = 0; i < measures.getMeasures().size(); i++) {
					/*
					 * ============================================================================
					 * calling other classes
					 */
					GuitarNotes notes = new GuitarNotes(measures.getMeasures().get(i));

					// note mapping
					Map<Pair<Integer, Integer>, List<Integer>> notesMap = notes.getNotesMapping();

					// duration mapping
					GuitarDuration duration = new GuitarDuration(notesMap,
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
					for (Map.Entry<Pair<Integer, Integer>, List<Integer>> entry : notesMap.entrySet()) {
						Integer index = entry.getKey().getKey();
						Integer gString = entry.getKey().getValue();
						List<Integer> value = entry.getValue();

						for (int n = 0; n < value.size(); n++) {
							/*
							 * ============================================================================
							 * <note>
							 */
							int noteNum = value.get(n);

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

								noteNum = value.get(n) - 100;
							}

							// <pitch>
							Element pitch = doc.createElement("pitch");
							note.appendChild(pitch);

							Element step = doc.createElement("step");
							step.appendChild(doc.createTextNode(notes.getNote(keys.getKeyInString(gString), noteNum)));
							pitch.appendChild(step);

							// <alter>
							if (notes.getAlter(keys.getKeyInString(gString), noteNum) != 0) {
								Element alter = doc.createElement("alter");
								alter.appendChild(doc.createTextNode(
										String.valueOf(notes.getAlter(keys.getKeyInString(gString), noteNum))));
								pitch.appendChild(alter);
							}

							// <octave>
							Element octave = doc.createElement("octave");
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
		sign.appendChild(doc.createTextNode("TAB")); // SIGN HAS BEEN CHANGED TO TAB SINCE WE ARE READING TABS
		clef.appendChild(sign);

		Element line = doc.createElement("line");
		line.appendChild(doc.createTextNode("5")); // Change later for automation
		clef.appendChild(line);

		/*
		 * ============================================================================
		 * <staff-details> (staff lines, staff tuning --> tuning-step, tuning-octave)
		 */
		GuitarTuning guitarTuning = new GuitarTuning();

		Element stafDet = doc.createElement("staff-details");
		att.appendChild(stafDet);

		Element staffLine = doc.createElement("staff-lines");
		staffLine.appendChild(doc.createTextNode(guitarTuning.getStaffLines())); // "6" lines in staff of guitar
																					// tabs
		stafDet.appendChild(staffLine);

		for (int i = 0; i < 6; i++) {
			Element staffLineTune = doc.createElement("staff-tuning");
			stafDet.appendChild(staffLineTune); // FOR THIS PART THIS WILL LOOP, BUT FOR THIS XML IT WILL BE
												// HARDCODED

			Attr lineAtt = doc.createAttribute("line");
			lineAtt.setValue(String.valueOf(i + 1)); // Loops depending on what line of the tab its on
			staffLineTune.setAttributeNode(lineAtt);

			Element tuneStep = doc.createElement("tuning-step");
			tuneStep.appendChild(doc.createTextNode(guitarTuning.getTuningStep(i))); // automated
			staffLineTune.appendChild(tuneStep);

			Element tuneOctave = doc.createElement("tuning-octave");
			tuneOctave.appendChild(doc.createTextNode(guitarTuning.getTuningOctave(i))); // automated
			staffLineTune.appendChild(tuneOctave);
		}
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
