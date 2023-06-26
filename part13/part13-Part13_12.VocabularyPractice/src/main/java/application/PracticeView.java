package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {

	private Dictionary dictionary;
	private String word;

	public PracticeView(Dictionary dictionary) {
		this.dictionary = dictionary;
		this.word = this.dictionary.getRandomWord();
	}

	// Retrieves the view setting 
	public Parent getView() {
		Label instructions = new Label("Translate the word '" + this.word + "'");
		Label resultText = new Label("");
		TextField translationField = new TextField();
		Button checkButton = new Button("Check");
		
		GridPane layout = new GridPane();
		// sets the layout
		layout.setAlignment(Pos.CENTER);
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(10, 10, 10, 10));

		// adds the components to the layout
		layout.add(instructions, 0, 0);
		layout.add(translationField, 0, 1);
		layout.add(checkButton, 0, 2);
		layout.add(resultText, 0, 3);

		// implements functionality to the button
		checkButton.setOnMouseClicked((event) -> {
			String input = translationField.getText();
			if (this.dictionary.getTranslation(word).equalsIgnoreCase(input)) {
				resultText.setText("Correct!");
			} else {
				resultText.setText("Incorrect! the translation of the word '" + word + "' is '" + this.dictionary.getTranslation(word) + "'.");
				return;
			}
			this.word = dictionary.getRandomWord();
			instructions.setText("Translate the word '" + word + "'");
			translationField.clear();
		});

		return layout;
	}

}