package MusicXML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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
	private ListView<File> listview;
	
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
				
				// --------------------------------- runs after file is input from JavaFX upload button
				FileScanner read = new FileScanner(selectedFiles.get(0).getAbsoluteFile());

								
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
