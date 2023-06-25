package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

	@Override
	public void start(Stage window) {
		BorderPane layout = new BorderPane();
		Label north = new Label("NORTH");
		Label east = new Label("EAST");
		Label south = new Label("SOUTH");
		layout.setTop(north);
		layout.setRight(east);
		layout.setBottom(south);
		north.setFont(Font.font("Arial", 12));
		east.setFont(Font.font("Arial", 12));
		south.setFont(Font.font("Arial", 12));

		Scene view = new Scene(layout);

		window.setScene(view);
		window.show();
	}

	public static void main(String[] args) {
		launch(BorderPaneApplication.class);
	}
}