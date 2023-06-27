package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application{

	public void start(Stage stage) {
		// create the x and y axes that the chart is going to use
		NumberAxis xAxis= new NumberAxis(2006, 2018, 1);
		NumberAxis yAxis = new NumberAxis(0, 100, 5);

		// set the titles for the axes
		xAxis.setLabel("Year");
		yAxis.setLabel("Ranking");

		xAxis.setTickLabelFont(Font.font("Arial", 10));
		yAxis.setTickLabelFont(Font.font("Arial", 10));

		// create the line chart. The values of the chart are given as numbers
		// and it uses the axes we created earlier
		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("University of Helsinki, Shanghai ranking");
		// hides the legend
		lineChart.setLegendVisible(false);

		// create the data set that is going to be added to the line chart
		XYChart.Series sRankSeries = new XYChart.Series();
		sRankSeries.setName("Shanghai");
		sRankSeries.getData().add(new XYChart.Data(2007, 73));
		sRankSeries.getData().add(new XYChart.Data(2008, 68));
		sRankSeries.getData().add(new XYChart.Data(2009, 72));
		sRankSeries.getData().add(new XYChart.Data(2010, 72));
		sRankSeries.getData().add(new XYChart.Data(2011, 74));
		sRankSeries.getData().add(new XYChart.Data(2012, 73));
		sRankSeries.getData().add(new XYChart.Data(2013, 76));
		sRankSeries.getData().add(new XYChart.Data(2014, 73));
		sRankSeries.getData().add(new XYChart.Data(2015, 67));
		sRankSeries.getData().add(new XYChart.Data(2016, 56));
		sRankSeries.getData().add(new XYChart.Data(2017, 56));

		lineChart.getData().add(sRankSeries);
		
		// display the line chart
		Scene view = new Scene(lineChart, 680, 480);
		String cssFile = getClass().getResource("styles.css").toExternalForm();
		view.getStylesheets().add(cssFile);
		stage.setScene(view);
		stage.show();
	}
	public static void main(String[] args) {
		launch(ShanghaiApplication.class);
	}

}


