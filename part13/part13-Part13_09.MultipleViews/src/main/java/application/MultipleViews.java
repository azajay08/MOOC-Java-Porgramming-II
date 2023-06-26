package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

	public void start(Stage window) {
		BorderPane layout = new BorderPane();

		Button toFirst = new Button("To the first view!");
		Button toSecond = new Button("To the second view!");
		Button toThird = new Button("To the third view!");

		Label first = new Label("First view!");
		Label second = new Label ("Second view!");
		Label third = new Label("Third view!");

		layout.setTop(first);
		layout.setCenter(toSecond);

		VBox vertBox = new VBox();
		vertBox.getChildren().addAll(toThird, second);

		GridPane gPane = new GridPane();
		gPane.add(third, 0, 0);
		gPane.add(toFirst, 1, 1);

		Scene firstScene = new Scene(layout);
		Scene secondScene = new Scene(vertBox);
		Scene thirdScene = new Scene(gPane);
		String cssFile = getClass().getResource("styles.css").toExternalForm();
    	firstScene.getStylesheets().add(cssFile);
		secondScene.getStylesheets().add(cssFile);
		thirdScene.getStylesheets().add(cssFile);

		toSecond.setOnAction((event) -> {
			window.setScene(secondScene);
		});

		toThird.setOnAction((event) -> {
			window.setScene(thirdScene);
		});

		toFirst.setOnAction((event) -> {
			window.setScene(firstScene);
		});

		window.setScene(firstScene);
		window.show();

	}
	public static void main(String[] args) {
		launch(MultipleViews.class);
		}

}


// String cssFile = getClass().getResource("styles.css").toExternalForm();
// 		scene.getStylesheets().add(cssFile);