package smiley;

import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class SmileyApplication extends Application {

	public void start(Stage window) {
		BorderPane paintingLayout = new BorderPane();
		Canvas paintingCanvas = new Canvas(400, 400);
		GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

		// set colour and draw shapes
		painter.setFill(Color.BLACK);
		painter.fillRect(100, 100, 40, 40); //left eye
		painter.fillRect(260, 100, 40, 40); //right eye
		painter.fillRect(60, 210, 40, 40); //left mouth
		painter.fillRect(300, 210, 40, 40); //right mouth
		painter.fillRect(100, 250, 200, 40); //bottom mouth

		paintingLayout.setCenter(paintingCanvas);

		Scene view = new Scene(paintingLayout);
		window.setScene(view);
		window.show();
	}
	public static void main(String[] args) {
		// System.out.println("Hello world!");
		launch(SmileyApplication.class);
	}

}
