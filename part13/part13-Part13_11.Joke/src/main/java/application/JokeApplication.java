package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application{

	public static void main(String[] args) {
		launch(JokeApplication.class);
	}

	public void start(Stage window) {

		BorderPane layout = new BorderPane();

		// menu layout
		HBox horizontalMenu = new HBox();
		horizontalMenu.setAlignment(Pos.CENTER);
		horizontalMenu.setSpacing(20);
		horizontalMenu.setPadding(new Insets(20,20,20,20));
		Button joke = new Button("Joke");
		Button answer = new Button("Answer");
		Button explanation = new Button("Explanation");

		// adds the buttons to the screen
		horizontalMenu.getChildren().addAll(joke, answer, explanation);

		// sets the layout for the specific text. calls the create view method
		StackPane jokeScreen = createView("What do you call a bear with no teeth?");
		StackPane answerScreen = createView("A gummy bear.");
		StackPane explanationScreen = createView("It is a pun. Gummy bears are a popular candy");

		// gives buttons functionalitly 
		joke.setOnAction((event) -> layout.setCenter(jokeScreen));
		answer.setOnAction((event) -> layout.setCenter(answerScreen));
		explanation.setOnAction((event) -> layout.setCenter(explanationScreen));

		// default view
		layout.setTop(horizontalMenu);
		layout.setCenter(jokeScreen);

		Scene scene = new Scene(layout);
		String cssFile = getClass().getResource("styles.css").toExternalForm();
		scene.getStylesheets().add(cssFile);
		window.setScene(scene);
		window.show();
	}

	private StackPane createView(String text) {

		StackPane layout = new StackPane();
		layout.setPrefSize(300, 180);
		layout.getChildren().add(new Label(text));
		layout.setAlignment(Pos.CENTER);

		return layout;
    }
}
