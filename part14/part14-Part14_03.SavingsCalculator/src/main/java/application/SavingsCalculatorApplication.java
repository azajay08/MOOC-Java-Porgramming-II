package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

	public void start(Stage stage) {

		// layout pane
		BorderPane layout = new BorderPane();
		
		// SAVINGS
		BorderPane savingsPane = new BorderPane();
		Slider savingsSlider = new Slider(25, 250, 25);
		savingsSlider.setSnapToTicks(true);
		savingsSlider.setBlockIncrement(25);
		savingsSlider.setShowTickLabels(true);
		savingsSlider.setShowTickMarks(true);;
		
		Label savingsLabel = new Label();
		savingsLabel.setText("" + savingsSlider.getValue());
		
		savingsPane.setLeft(new Label("Monthly savings"));
		savingsPane.setCenter(savingsSlider);
		savingsPane.setRight(savingsLabel);
		savingsPane.setPadding(new Insets(10));

		// INTEREST
		BorderPane interestPane = new BorderPane();
		
		Slider interestSlider = new Slider(0, 10, 0);
		interestSlider.setMinorTickCount(10);
		interestSlider.setShowTickMarks(true);
		interestSlider.setShowTickLabels(true);


		Label interestLabel = new Label();
		interestLabel.setText("" + interestSlider.getValue());

		interestPane.setLeft(new Label("Yearly interest rate"));
		interestPane.setCenter(interestSlider);
		interestPane.setRight(interestLabel);
		interestPane.setPadding(new Insets(10));
		
		// Label savingsLabel = new Label();
		VBox sliderBox = new VBox();
		sliderBox.getChildren().addAll(savingsPane, interestPane);
		layout.setTop(sliderBox);
		
		NumberAxis yAxis = new NumberAxis();
		NumberAxis xAxis = new NumberAxis(0, 30, 1);

		xAxis.setTickLabelFont(Font.font("Arial", 10));
		yAxis.setTickLabelFont(Font.font("Arial", 10));

		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setAnimated(false);
		lineChart.setLegendVisible(false);
		lineChart.setTitle("Savings calulator");
		layout.setCenter(lineChart);

		XYChart.Series savingsSeries = new XYChart.Series();
		XYChart.Series interestSeries = new XYChart.Series();

		lineChart.getData().add(savingsSeries);
		lineChart.getData().add(interestSeries);


		savingsSlider.valueProperty().addListener((observable, oldvalue, newvalue) -> {
			int savings = newvalue.intValue();
			savingsLabel.setText("" + savings);

			applyChart(savingsSlider.getValue(), interestSlider.getValue(), savingsSeries, interestSeries);
		});

		interestSlider.valueProperty().addListener((observable, oldvalue, newvalue) -> {
			interestLabel.setText("" + newvalue);

			applyChart(savingsSlider.getValue(), interestSlider.getValue(), savingsSeries, interestSeries);
		});

		Scene view = new Scene(layout, 680, 480);
		String cssFile = getClass().getResource("styles.css").toExternalForm();
		view.getStylesheets().add(cssFile);
		stage.setScene(view);
		stage.show();

	}

	private void applyChart(double savings, double interest, XYChart.Series savingsSeries, XYChart.Series interestSeries) {
		double savingsResult = 0.0;
		double interestResult = 0.0;

		savingsSeries.getData().clear();
		interestSeries.getData().clear();

		savingsSeries.getData().add(new XYChart.Data(0, 0));
		interestSeries.getData().add(new XYChart.Data(0, 0));

		for (int i = 0; i < 30; i++) {
			savingsSeries.getData().add(new XYChart.Data(i, savingsResult));
			interestSeries.getData().add(new XYChart.Data(i, interestResult));

			savingsResult += savings * 12;
			interestResult = (interestResult + savings * 12) * (1.0 + interest / 100.0);
		}
	};

	public static void main(String[] args) {
		launch(SavingsCalculatorApplication.class);
		// System.out.println("Hello world!");
	}

}
