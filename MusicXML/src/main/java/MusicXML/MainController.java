package MusicXML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
public class MainController {

	// declare variables
	@FXML
	private Button addbtn;
	
	@FXML
	private Button savebtn;
	
	@FXML
	private Button viewbtn;
	
	@FXML
	private Button convertbttn;
	
	@FXML
	private ListView<File> listview;
	
	@FXML
	private TextArea txtTextArea;
	
	@FXML
	private TextArea xmlTextArea;
	
	@FXML
	private TextField txtPath;
	
	@FXML
	private Tab txtTab;
	
	@FXML
	private Tab xmlTab;
	
	@FXML
	private TabPane tp;
	
	@FXML
	private Alert alert;
	
	// this method sets the action for when the "Upload File" button is pressed, only one file can be opened at a time and must be a .txt file
	public void addSongAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		
		// filter file extension -- remove below code if no extension filter is needed
		fc.getExtensionFilters().add(new ExtensionFilter("TXT Files", "*.txt"));
		
		List<File> selectedFiles = fc.showOpenMultipleDialog(null);
		
		if(selectedFiles != null) {
			if(selectedFiles.size() > 1) {
				for(int i = 0; i < selectedFiles.size(); i++) {
					listview.getItems().add(selectedFiles.get(i).getAbsoluteFile());
					showOnlyFileName();
				}
			}
			else {
				
				listview.getItems().add(selectedFiles.get(0).getAbsoluteFile());
				showOnlyFileName();
			}
		}
		else {
			System.out.println("no file selected");
		}	

	}
	
	
	public void saveAction(ActionEvent event) {
		this.XMLWriter();
		File file = new File("export.xml");
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("XML Files", "*.xml"));
		File dest = fc .showSaveDialog(null);
		if (dest != null) {
		    try {
		        Files.copy(file.toPath(), dest.toPath());
		    } catch (IOException ex) {
		        System.out.println("no destination selected");
		    }
		}
	}
	
	public void viewAction(ActionEvent event) {
		tp.getSelectionModel().select(txtTab);
		txtPath.clear();
		txtTextArea.clear();
		File tab;
		tab = listview.getSelectionModel().getSelectedItem();
		txtPath.appendText(tab.getAbsolutePath());
		try {
			Scanner reader = new Scanner (tab);
	
			while (reader.hasNextLine()) {
				txtTextArea.appendText(reader.nextLine());
				txtTextArea.appendText("\n");
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("File Scan Error");
			e.printStackTrace();
		}
	}
	
	public void convertAction(ActionEvent event) {
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Instrument Type Selection");
		alert.setHeaderText("Detected: Guitar Tabs");
		alert.setContentText("Proceed with conversion as:");
		
		ButtonType detectbttn = new ButtonType("Detected", ButtonData.CANCEL_CLOSE);
		ButtonType guitarbttn = new ButtonType("Guitar");
		ButtonType drumsbttn = new ButtonType("Drums");
		alert.getButtonTypes().setAll(detectbttn, guitarbttn, drumsbttn);
		alert.show();
		
        txtTextArea.appendText("\n" + "Conversion complete");
	}
	
	
	public void showOnlyFileName() {
		listview.setCellFactory((Callback<ListView<File>, ListCell<File>>) new Callback<ListView<File>, ListCell<File>>() {
		    public ListCell<File> call(ListView<File> param) {
		        return new ListCell<File>() {
		            @Override
		            protected void updateItem(File item, boolean empty) {
		                super.updateItem(item, empty);
		                setText(item == null || empty ? null : item.getName());
		            }
		        };
		    }
		});
	}
	
	public void XMLWriter(){
	      try {

	          DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	          DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	          // root elements
	          Document doc = docBuilder.newDocument();
	          
	          Element rootElement = doc.createElement("score-partwise");
	          doc.appendChild(rootElement);
	          
	          Element partList = doc.createElement("part-list");
	          rootElement.appendChild(partList);
	          
	          Element scorePart = doc.createElement("score-part");
	          partList.appendChild(scorePart);
	          
	          Attr id2 = doc.createAttribute("id");
	          id2.setValue("P1");
	          scorePart.setAttributeNode(id2);
	          
	          Element partName = doc.createElement("part-name");
	          partName.appendChild(doc.createTextNode("Music")); //Music name --- Up for change
	          scorePart.appendChild(partName);
	          
	          
	          Element part = doc.createElement("part");
	          rootElement.appendChild(part);

	          // set attribute to part element

	          Attr id = doc.createAttribute("id");
	          id.setValue("P1");
	          part.setAttributeNode(id);
	          
	          
	          // att elements
	          Element att = doc.createElement("attributes");
	          part.appendChild(att);

	   
	          // shorten way
	          // staff.setAttribute("id", "1");

	          // div elements
	          Element div = doc.createElement("divisions");
	          div.appendChild(doc.createTextNode("1")); //Change later for automation
	          att.appendChild(div);

	          // key elements
	          Element key = doc.createElement("key");
	          //key.appendChild(doc.createTextNode("kolotev"));
	          att.appendChild(key);
	          
	          
	          Element fifth = doc.createElement("fifths");
	          fifth.appendChild(doc.createTextNode("0")); //Change later for automation
	          key.appendChild(fifth);

	          // time elements
	          Element time = doc.createElement("time");
	          //time.appendChild(doc.createTextNode("StreetNigga"));
	          att.appendChild(time);
	          
	          Element beats = doc.createElement("beats");
	          beats.appendChild(doc.createTextNode("4")); //Change later for automation
	          time.appendChild(beats);
	          
	          Element beatsType = doc.createElement("beat-type");
	          beatsType.appendChild(doc.createTextNode("4")); //Change later for automation
	          time.appendChild(beatsType);

	          // salary elements
	          Element clef = doc.createElement("clef");
	          //clef.appendChild(doc.createTextNode("100000"));
	          att.appendChild(clef);
	          
	          Element sign = doc.createElement("sign");
	          sign.appendChild(doc.createTextNode("G")); //Change later for automation
	          clef.appendChild(sign);
	      
	          Element line = doc.createElement("line");
	          line.appendChild(doc.createTextNode("2")); //Change later for automation
	          clef.appendChild(line);
	          
	          Element note = doc.createElement("note");
	          part.appendChild(note);
	          
	          Element pitch = doc.createElement("Pitch");
	          note.appendChild(pitch);
	          
	          Element step = doc.createElement("step");
	          step.appendChild(doc.createTextNode("C")); //Change later for automation
	          pitch.appendChild(step);
	          
	          Element octave = doc.createElement("octave");
	          octave.appendChild(doc.createTextNode("4")); //Change later for automation
	          pitch.appendChild(octave);
	          
	          Element dur = doc.createElement("duration");
	          dur.appendChild(doc.createTextNode("4")); //Change later for automation
	          note.appendChild(dur);

	          Element type = doc.createElement("type");
	          type.appendChild(doc.createTextNode("whole")); //Change later for automation
	          note.appendChild(type);
	          
	          // write the content into xml file
	          TransformerFactory transformerFactory = TransformerFactory.newInstance();
	          Transformer transformer = transformerFactory.newTransformer();
	          DOMSource source = new DOMSource(doc);
	          StreamResult result = new StreamResult(new File("export.xml"));

//	          System.out.println(result.toString());
	          // Output to console for testing
//	          StreamResult result = new StreamResult(System.out);

	          transformer.transform(source, result);

	          System.out.println("File saved!");

	        } catch (ParserConfigurationException pce) {
	          pce.printStackTrace();
	        } catch (TransformerException tfe) {
	          tfe.printStackTrace();
	        }
	}
}
