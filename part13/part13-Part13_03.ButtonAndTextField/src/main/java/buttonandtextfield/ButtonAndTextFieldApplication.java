package buttonandtextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonAndTextFieldApplication extends Application {

	public void start(Stage window) {
		Button buttonComponent = new Button("This is the button");
		TextField textComponent = new TextField("This is the text");

		textComponent.setFont(Font.font("Arial", 12));
		buttonComponent.setFont(Font.font("Arial", 12));

		FlowPane componentGroup = new FlowPane();
		componentGroup.getChildren().add(buttonComponent);
		componentGroup.getChildren().add(textComponent);

		Scene view = new Scene(componentGroup);

		window.setScene(view);
		window.show();

	}
	public static void main(String[] args) {
		launch(ButtonAndTextFieldApplication.class);
	}

}
