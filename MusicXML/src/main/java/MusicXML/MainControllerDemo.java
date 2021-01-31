package MusicXML;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
public class MainControllerDemo {

	
	// declare variables
	@FXML
	private Button uploadbtn;
	
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
			
			// ---------------------------------
			FileScanner read = new FileScanner(selectedFile.getAbsoluteFile());
				// ------------------------------------------------------------------------------------------------------------
				// find spaces between bars (Consult FileScanner Class)
				System.out.println("Length of one line: " + read.LineLength(0));

							
				read.SpaceCounter(); // Count the number of spaces in each bar & count how many bars there are (Evokes void method)
				System.out.println("Number of spaces in the first bar: " + read.spacesBetweenBar);		
				
				System.out.println("The key of string 3 is: " + read.KeyFinder(2));		// 
				
				read.getLines();
				int measureNum = 3; // change this to see the measure output
				System.out.println("Measure " + measureNum);
				for(int i = measureNum; i < read.measures.size();  i = i + read.measures.size()/6) {
					System.out.println(read.measures.get(i));
				}
						
			//------------------------------------		

			
		}
		else {
			System.out.println("no file selected");
		}
		
		
		

	}
}
