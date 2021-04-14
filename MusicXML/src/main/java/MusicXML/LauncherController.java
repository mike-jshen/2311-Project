package MusicXML;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LauncherController {
	@FXML
	private JFXButton launchbttn;
	@FXML
	private JFXButton closeButton;
	@FXML
	private JFXButton reqbttn;
	@FXML
	private JFXButton testdocbttn;
	@FXML
	private JFXButton manualbttn;
	@FXML
	private JFXButton designbttn;

	public void launchAction(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("musicXML.fxml"));
			Parent root = (Parent) fxmlLoader.load();

			Stage stage = new Stage();
			stage.setTitle("Group3 Tab Converter");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Cannot load program window");
		}
	}

	@FXML
	private void closeButtonAction(){
	    // get a handle to the stage
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public void reqdocAction(ActionEvent event) {
		showFile("reqdoc.pdf");
	}
	
	public void testdocAction(ActionEvent event) {
		showFile("testdoc.pdf");
	}
	
	public void manualAction(ActionEvent event) {
		showFile("manual.pdf");
	}
	
	public void designAction(ActionEvent event) {
		showFile("DesignDoc.pdf");
	}
	
	private void showFile(String fileName) {
		File pdfFile = new File(fileName);
		if (Desktop.isDesktopSupported()) {
	        new Thread(() -> {
	            try {
	                Desktop.getDesktop().open(pdfFile);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }).start();
	    }
	}
}
