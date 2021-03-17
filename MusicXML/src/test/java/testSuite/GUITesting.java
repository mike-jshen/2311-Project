package testSuite;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
class GUITesting {

	/**
     * @param stage - Will be injected by the test runner.
	 * @throws IOException 
     */
    @Start
    private void start(Stage primaryStage) throws IOException {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../java/MusicXML/musicXML.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Group3 Tab Converter");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * @param robot - Will be injected by the test runner.
     */
    @Test
    void should_contain_button_with_text(FxRobot robot) {
        FxAssert.verifyThat("#addSongAction", LabeledMatchers.hasText("Add Song"));
    }

    @Test
    void should_contain_button_with_text1(FxRobot robot) {
        FxAssert.verifyThat("#saveAction", LabeledMatchers.hasText("Save"));
    }
    
    @Test
    void should_contain_button_with_text2(FxRobot robot) {
        FxAssert.verifyThat("#convertAction", LabeledMatchers.hasText("Convert"));
    }

}