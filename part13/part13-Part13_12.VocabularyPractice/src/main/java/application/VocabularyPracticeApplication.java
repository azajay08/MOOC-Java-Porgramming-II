package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application{

	private Dictionary dictionary;

	@Override
	public void init() throws Exception{
		//creates the dictionary
		dictionary = new Dictionary();
	}
	
	@Override
	public void start(Stage window) throws Exception {
		// importing the practice and input view
		PracticeView practiceView = new PracticeView(dictionary);
		InputView inputView = new InputView(dictionary);
		
		// creates a new layout
		BorderPane layout = new BorderPane();
		
		// sets the layout format
		HBox menu = new HBox();
		menu.setPadding(new Insets(10, 10, 10, 10));
		menu.setSpacing(10);
		
		Button practiceButton = new Button("Practice");
		Button inputButton = new Button("Enter new words");
		menu.getChildren().addAll(inputButton, practiceButton);
		
		// plaves the menu bar at the top
		layout.setTop(menu);
		
		// implements functionality for which button is pressed
		practiceButton.setOnMouseClicked((event) -> {
			layout.setCenter(practiceView.getView());
		});
		
		inputButton.setOnMouseClicked((event) -> {
			layout.setCenter(inputView.getView());
		});
		
		// sets the default layout when the application is launched
		layout.setCenter(inputView.getView());
		
		// creates the scene, and sets the font
		Scene view = new Scene(layout, 400, 400);
		String cssFile = getClass().getResource("styles.css").toExternalForm();
		view.getStylesheets().add(cssFile);
		
		window.setScene(view);
		window.show();
	}

	public static void main(String[] args) {
		launch(VocabularyPracticeApplication.class);
	}
}