package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {

	private Dictionary dictionary;

	public InputView(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	// Retrieves the view setting 
	public Parent getView() {
		Label wordText = new Label("Word");
		Label translationText = new Label("Translation");
		TextField wordField = new TextField();
		TextField translationField = new TextField();
		Button addButton = new Button("Add the word pair");

		GridPane layout = new GridPane();
		// sets the layout
		layout.setAlignment(Pos.CENTER);
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		
		// adds the components to the layout
		layout.add(wordText, 0, 0);
		layout.add(wordField, 0, 1);
		layout.add(translationText, 0, 2);
		layout.add(translationField, 0, 3);
		layout.add(addButton, 0, 4);


		// implements functionality to the button
		addButton.setOnMouseClicked((event) -> {
			this.dictionary.addWord(wordField.getText(), translationField.getText());
			wordField.clear();
			translationField.clear();
		});

		return layout;

	}

}