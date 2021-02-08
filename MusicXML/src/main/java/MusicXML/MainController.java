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
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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
	private ListView<File> listview;
	
	@FXML
	private TextArea text;
	
	@FXML
	private TextArea xmltext;
	
	@FXML
	private Button convertbttn;
	
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
		text.clear();
		File tab;
		tab = listview.getSelectionModel().getSelectedItem();
		try {
			Scanner reader = new Scanner (tab);
	
			while (reader.hasNextLine()) {
				text.appendText(reader.nextLine());
				text.appendText("\n");
			}
			reader.close();
		}
		catch (IOException e) {
			System.out.println("File Scan Error");
			e.printStackTrace();
		}
	}
	
	public void convertAction(ActionEvent event) throws Exception, IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("export.txt"));

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("export.xml");
        XPathFactory xPathFactory = XPathFactory.newInstance();
        writer.append(xPathFactory.newXPath().compile("//score-partwise/part-list").evaluate(document));
        writer.newLine();
        writer.append(xPathFactory.newXPath().compile("//note/part").evaluate(document));
        writer.newLine();
        writer.close();
        
        Scanner reader = new Scanner ("export.txt");
    	
		while (reader.hasNextLine()) {
			xmltext.appendText(reader.nextLine());
			xmltext.appendText("\n");
		}
		reader.close();
        
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
}
