package Lab;

import java.io.File;
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

public class XMLWriter {

	public static void main(String argv[]) {

		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();

			Element rootElement = doc.createElement("score-partwise");
			doc.appendChild(rootElement);
			
			Attr root = doc.createAttribute("version"); //ADDED ATTRIBUTE TO SCORE PARTWISE
			root.setValue("3.1");
			rootElement.setAttributeNode(root);

			Element partList = doc.createElement("part-list");
			rootElement.appendChild(partList);

			Element scorePart = doc.createElement("score-part");
			partList.appendChild(scorePart);

			Attr id2 = doc.createAttribute("id");
			id2.setValue("P1");
			scorePart.setAttributeNode(id2);

			Element partName = doc.createElement("part-name");
			partName.appendChild(doc.createTextNode("Music")); // Music name --- Up for change
			scorePart.appendChild(partName);

			Element part = doc.createElement("part");
			rootElement.appendChild(part);

			// set attribute to part element

			Attr id = doc.createAttribute("id");
			id.setValue("P1");
			part.setAttributeNode(id);

			Element mes = doc.createElement("measure");
			part.appendChild(mes);

			Attr num = doc.createAttribute("number");
			num.setValue("0");
			mes.setAttributeNode(num);

			// att elements
			Element att = doc.createElement("attributes");
			mes.appendChild(att);

			// shorten way
			// staff.setAttribute("id", "1");

			// div elements
			Element div = doc.createElement("divisions");
			div.appendChild(doc.createTextNode("1")); // Change later for automation
			att.appendChild(div);

			// key elements
			Element key = doc.createElement("key");
			// key.appendChild(doc.createTextNode("kolotev"));
			att.appendChild(key);

			Element fifth = doc.createElement("fifths");
			fifth.appendChild(doc.createTextNode("0")); // Change later for automation
			key.appendChild(fifth);

			// time elements
			Element time = doc.createElement("time");
			// time.appendChild(doc.createTextNode("StreetN"));
			att.appendChild(time);

			Element beats = doc.createElement("beats");
			beats.appendChild(doc.createTextNode("4")); // Change later for automation
			time.appendChild(beats);

			Element beatsType = doc.createElement("beat-type");
			beatsType.appendChild(doc.createTextNode("4")); // Change later for automation
			time.appendChild(beatsType);

			// salary elements
			Element clef = doc.createElement("clef");
			// clef.appendChild(doc.createTextNode("100000"));
			att.appendChild(clef);
			
			Element stafDet = doc.createElement("staff-details");
			att.appendChild(stafDet);
			
			Element staffLine = doc.createElement("staff-lines");
			staffLine.appendChild(doc.createTextNode("6")); //Change depending on number of lines in a guitar tab
			stafDet.appendChild(staffLine);
			
			// starts looping here
			Element staffLineTune = doc.createElement("staff-tuning");
			stafDet.appendChild(staffLineTune); //FOR THIS PART THIS WILL LOOP, BUT FOR THIS XML IT WILL BE HARDCODED
			
			Attr lineAtt = doc.createAttribute("line");
			lineAtt.setValue("1"); //Loops depending on what line of the tab its on
			staffLineTune.setAttributeNode(lineAtt);
			
			Element tuneStep = doc.createElement("tuning-step");
			tuneStep.appendChild(doc.createTextNode("E")); //This changes depending on the letter infront of the tab
			staffLineTune.appendChild(tuneStep);
			
			Element tuneOctave = doc.createElement("tuning-octave");
			tuneOctave.appendChild(doc.createTextNode("2")); //Change for automation... need to create octave methode
			staffLineTune.appendChild(tuneOctave);
			
			//ends looping here

			Element sign = doc.createElement("sign");
			sign.appendChild(doc.createTextNode("TAB")); // SIGN HAS BEEN CHANGED TO TAB SINCE WE ARE READING TABS
			clef.appendChild(sign);

			Element line = doc.createElement("line");
			line.appendChild(doc.createTextNode("2")); // Change later for automation
			clef.appendChild(line);

			Element note = doc.createElement("note");
			part.appendChild(note);

			Element pitch = doc.createElement("Pitch");
			note.appendChild(pitch);

			Element step = doc.createElement("step");
			step.appendChild(doc.createTextNode("C")); // Change later for automation
			pitch.appendChild(step);

			Element octave = doc.createElement("octave");
			octave.appendChild(doc.createTextNode("4")); // Change later for automation
			pitch.appendChild(octave);

			Element dur = doc.createElement("duration");
			dur.appendChild(doc.createTextNode("4")); // Change later for automation
			note.appendChild(dur);

			Element type = doc.createElement("type");
			type.appendChild(doc.createTextNode("whole")); // Change later for automation
			note.appendChild(type);

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("export2.xml"));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}