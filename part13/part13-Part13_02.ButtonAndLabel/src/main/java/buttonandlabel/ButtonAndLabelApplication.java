package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    public void start(Stage window) {
		Button buttonComponent = new Button("This is a button");
		Label textComponent = new Label("Text element");
		buttonComponent.setFont(Font.font("Arial", 12));
		textComponent.setFont(Font.font("Arial", 12));

		FlowPane componentGroup = new FlowPane();
		componentGroup.getChildren().add(buttonComponent);
		componentGroup.getChildren().add(textComponent);

		Scene view = new Scene(componentGroup);

		window.setScene(view);
		window.show();
	}

	public static void main(String[] args) {
		launch(ButtonAndLabelApplication.class);
	}
}