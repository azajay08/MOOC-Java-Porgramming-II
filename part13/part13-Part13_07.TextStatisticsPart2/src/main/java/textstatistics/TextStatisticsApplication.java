package textstatistics;

import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

	public static void main(String[] args) {
		launch(TextStatisticsApplication.class);
	}

	@Override
	public void start(Stage window) throws Exception {

		BorderPane layout = new BorderPane();
		HBox horizontalBox = new HBox();
		horizontalBox.setSpacing(10);
		Label letters = new Label();
		Label words = new Label();
		Label longest = new Label();
		horizontalBox.getChildren().add(letters);
		horizontalBox.getChildren().add(words);
		horizontalBox.getChildren().add(longest);

		letters.setText("Letters: " + 0);
		words.setText("Words: " + 0);
		longest.setText("The longest word is: ");

		TextArea textField = new TextArea("");
		textField.textProperty().addListener((change, oldValue, newValue) -> {
			int charCount = newValue.length();
			String[] wordSplit = newValue.split(" ");
			int wordCount = wordSplit.length;

			String longestWord = Arrays.stream(wordSplit)
				.max((word1, word2) -> Integer.compare(word1.length(), word2.length()))
				.orElse("");

			letters.setText("Letters: " + charCount);
			words.setText("Words: " + wordCount);
			longest.setText("The longest word is: " + longestWord);
		});
		
		layout.setCenter(textField);
		layout.setBottom(horizontalBox);


		Scene scene = new Scene(layout);
		String cssFile = getClass().getResource("styles.css").toExternalForm();
		scene.getStylesheets().add(cssFile);
		window.setScene(scene);
		window.show();

	}

}

