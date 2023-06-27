package ticTacToe;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application{

	ArrayList<Button> buttons = new ArrayList<>();
	String player = "X";
	boolean gameEnded = false;
	boolean tookTurn = false;


	public void start(Stage window) {
		BorderPane layout = new BorderPane();
		Label turn = new Label("Turn: " + player);
		// Background background = new Background(new BackgroundFill(Color.BLACK, null, null));
		// Background buttonColour = new Background(new BackgroundFill(Color.AQUAMARINE, null, null));
		turn.setFont(Font.font("Arial", 30));
		// turn.setTextFill(Color.AQUAMARINE);
		
		GridPane gameBoard = new GridPane();
		gameBoard.setPadding(new Insets(10, 10, 10, 10));
		gameBoard.setHgap(10);
		gameBoard.setVgap(10);
		
		for (int i = 0; i < 9; i++) {
			Button button = new Button();
			button.setFont(Font.font("Arial", 30));
			button.setMinSize(100, 100);
			button.setMaxSize(100, 100);
			// button.setBackground(buttonColour);
			button.setOnMouseClicked((event) -> {
				if (button.getText().isEmpty() && !gameEnded) {
					button.setText(player);
					tookTurn = true;
				}
				if (playerWon()) {
					turn.setText("The end!");
					gameEnded = true;
				} else if (isDraw()) {
					gameEnded = true;
					turn.setText("It's a draw!");
				} else if (tookTurn) {
					if (player.equals("X")) {
						player = "O";
					} else {
						player = "X";
					}
					turn.setText("Turn: " + player);
					tookTurn = false;
				}
			});
			buttons.add(button);
		}

		int b = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				gameBoard.add(buttons.get(b), y , x);
				b++;
			}
		}
		// layout.setBackground(background);
		layout.setTop(turn);
		layout.setCenter(gameBoard);


		Scene game = new Scene(layout);
		window.setScene(game);
		window.show();
	}

	public boolean playerWon() {
		if (checkVert() || checkAcross() || checkDiagnol()) {
			return true;
		}
		return false;
	}

	public boolean checkVert() {
		for (int i = 0; i < 3; i++) {
			if (buttons.get(i).getText().equals(player) && buttons.get(i + 3).getText().equals(player)
			&& buttons.get(i + 6).getText().equals(player)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkAcross() {
		int row = 0;
		for (int i = 0; i < 3; i++) {
			if (buttons.get(row).getText().equals(player) && buttons.get(row + 1).getText().equals(player)
			&& buttons.get(row + 2).getText().equals(player)) {
				return true;
			}
			row += 3;
		}
		return false;
	}

	public boolean checkDiagnol() {
		if (buttons.get(0).getText().equals(player) && buttons.get(4).getText().equals(player)
			&& buttons.get(8).getText().equals(player)) {
				return true;
		} else if (buttons.get(2).getText().equals(player) && buttons.get(4).getText().equals(player)
			&& buttons.get(6).getText().equals(player)) {
				return true;
		}
		return false;
	}

	public boolean isDraw() {
		for (Button button : buttons) {
			if (button.getText().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		launch(TicTacToeApplication.class);
	}

}
