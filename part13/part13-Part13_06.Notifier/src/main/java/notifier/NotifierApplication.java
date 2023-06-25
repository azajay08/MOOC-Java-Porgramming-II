package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application {


	public static void main(String[] args) {
		launch(NotifierApplication.class);
	}

	@Override
	public void start(Stage stage) {
		TextField textBox = new TextField("");
		Button button = new Button("Update");
		Label label = new Label("");

		button.setOnAction((event) -> {
			label.setText(textBox.getText());
		});

		VBox layout = new VBox();
		layout.getChildren().addAll(textBox, button, label);

		Scene scene = new Scene(layout);
		String cssFile = getClass().getResource("styles.css").toExternalForm();
		scene.getStylesheets().add(cssFile);
		stage.setScene(scene);
		stage.show();
	}
}
