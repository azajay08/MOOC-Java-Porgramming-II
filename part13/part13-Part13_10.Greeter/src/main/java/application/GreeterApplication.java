package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

	public void start(Stage window) {
		Label instructions = new Label("Enter your name and start.");
		Label error = new Label("");
		Button startButton = new Button("Start");
		TextField inputBox = new TextField("");

		// basic layout for the starting screen
		GridPane startLayout = new GridPane();
		startLayout.add(instructions, 0, 0);
		startLayout.add(inputBox, 0, 1);
		startLayout.add(startButton, 0, 2);
		startLayout.add(error, 0, 3);

		// start layout in more detial
		startLayout.setPrefSize(300, 180);
		startLayout.setAlignment(Pos.CENTER);
		startLayout.setVgap(10);
		startLayout.setHgap(10);
		startLayout.setPadding(new Insets(20, 20, 20, 20));

		Scene startView = new Scene(startLayout);
		// Sets the font globally for the scene to stop the strange characters appearing
		String cssFile = getClass().getResource("styles.css").toExternalForm();
		startView.getStylesheets().add(cssFile);

		Label greeting = new Label("");

		// basic layout for welcome screen
		GridPane welcomeLayout = new GridPane();
		welcomeLayout.add(greeting, 0, 0);

		// welcome layout in more detial
		welcomeLayout.setPrefSize(300, 180);
		welcomeLayout.setAlignment(Pos.CENTER);
		welcomeLayout.setVgap(10);
		welcomeLayout.setHgap(10);
		welcomeLayout.setPadding(new Insets(20, 20, 20, 20));

		Scene welcomeView = new Scene(welcomeLayout);
		welcomeView.getStylesheets().add(cssFile);

		// Adds the functionality of the button and takes the input
		startButton.setOnAction((event) -> {
			if (inputBox.getText().isEmpty()) {
				error.setText("Text field is empty, try again");
				return;
			}
			String name = inputBox.getText();
			greeting.setText("Welcome " + name + "!");
			window.setScene(welcomeView);
		});

		window.setScene(startView);
		window.show();
	}

	public static void main(String[] args) {
		launch(GreeterApplication.class);
	}
}
