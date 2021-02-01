package MusicXML;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class JFXDemo extends Application {
    public static void main(String[] args) {
        launch(args);									// this starts the application
    }
    
    @Override
    public void start(Stage primaryStage) {
        
    	Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("MainDemo.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);					// add a scene to the Stage
        primaryStage.show();							// show the Stage (a blank window)
    }
}
