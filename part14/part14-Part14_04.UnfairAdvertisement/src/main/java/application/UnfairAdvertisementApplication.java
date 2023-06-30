package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UnfairAdvertisementApplication extends Application {

	@Override
	public void start(Stage window) {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis(70, 80, 0.5);
		yAxis.setTickLabelsVisible(true);
		yAxis.setLabel("Internet Speed");

		BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

		barChart.setTitle("Internet speed comparison");
		barChart.setLegendVisible(false);

		XYChart.Series speeds = new XYChart.Series();
		speeds.getData().add(new XYChart.Data("NDA", 77.4));
		speeds.getData().add(new XYChart.Data("Fastie", 77.2));
		speeds.getData().add(new XYChart.Data("SuperNet", 77.1));
		speeds.getData().add(new XYChart.Data("Meganet", 77.1));

		xAxis.setTickLabelFont(Font.font("Arial", 10));
		yAxis.setTickLabelFont(Font.font("Arial", 10));

		barChart.getData().add(speeds);
		Scene view = new Scene(barChart, 400, 300);
		String cssFile = getClass().getResource("styles.css").toExternalForm();
		view.getStylesheets().add(cssFile);
		window.setScene(view);
		window.show();
	}

	public static void main(String[] args) {
		launch(UnfairAdvertisementApplication.class);
	}

}
