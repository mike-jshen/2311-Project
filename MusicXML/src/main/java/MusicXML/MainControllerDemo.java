package MusicXML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
public class MainControllerDemo {

	
	// declare variables
	@FXML
	private Button uploadbtn;
	
	@FXML
	private Button downloadbtn;
	
	@FXML
	private ListView<File> listview;
	
	// this method sets the action for when the "Upload File" button is pressed, only one file can be opened at a time and must be a .txt file
	public void uploadFileAction(ActionEvent event) {
		FileChooser fc = new FileChooser();
		
		// filter file extension -- remove below code if no extension filter is needed
		fc.getExtensionFilters().add(new ExtensionFilter("TXT Files", "*.txt"));
		
		File selectedFile = fc.showOpenDialog(null);
		
		if(selectedFile != null) {
			listview.getItems().add(selectedFile.getAbsoluteFile());
			
			// --------------------------------- runs after file is input from JavaFX upload button
			FileScanner read = new FileScanner(selectedFile.getAbsoluteFile());
				// ------------------------------------------------------------------------------------------------------------
				// find spaces between bars (Consult FileScanner Class)
				System.out.println("Length of one line: " + read.LineLength(0));

							
				read.SpaceCounter(0); // Count the number of spaces in each bar & count how many bars there are (Evokes void method)
				System.out.println("Number of spaces in the first bar: " + read.spacesBetweenBar);		
				
				System.out.println("The key of string 3 is: " + read.KeyFinder(2));		// 
				
				ArrayList<String[]> myMeasures = read.getMeasures();
				for(int i = 0; i < myMeasures.size(); i++) {
					for(int j = 0; j < myMeasures.get(i).length; j++) {
						System.out.println(myMeasures.get(i)[j]);
					}
					System.out.println();
				}
			//------------------------------------ end 	
		}
		else {
			System.out.println("no file selected");
		}

	}
	
	
	public void downloadFileAction(ActionEvent event) {
		File file = new File("test.xml");
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
	
}
