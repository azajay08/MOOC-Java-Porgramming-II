package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

	private HashMap<String, HashMap<Integer, Double>> parties;

	public PartiesApplication () {
		this.parties = new HashMap<>();
	}

	public void getPartyData(String filename) {
		ArrayList<Integer> years = new ArrayList<>();
		try (Scanner scanner = new Scanner(Paths.get(filename))) {
			String row = scanner.nextLine();
			String[] parts = row.split("\t");
			for (int i = 1; i < parts.length; i++) { // skip first
				years.add(Integer.parseInt(parts[i]));
			}

			while (scanner.hasNext()) {
				String next = scanner.nextLine();
				parts = next.split("\t");
				String party = parts[0];
				HashMap<Integer, Double> map = new HashMap<>();
				for (int i = 1; i < parts.length; i++) {
					if (!parts[i].equals("-")) {
						map.put(years.get(i - 1), Double.valueOf(parts[i]));
					}
				}
				this.parties.put(party, map);
			}

		} catch(Exception e) {
			System.err.println("Error: " + e.toString());
		}
	}

	public void start(Stage stage) {
		NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
		NumberAxis yAxis = new NumberAxis(0, 30, 5);

		xAxis.setTickLabelFont(Font.font("Arial", 10));
		yAxis.setTickLabelFont(Font.font("Arial", 10));

		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("Relative support of the parties");

		getPartyData("partiesdata.tsv");
		this.parties.keySet().stream().forEach(party -> {
			// a different data set for every party
			XYChart.Series data = new XYChart.Series();
			data.setName(party);

			// add the party's support numbers to the data set
			this.parties.get(party).entrySet().stream().forEach(pair -> {
				data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
			});

			// and add the data set to the chart
			lineChart.getData().add(data);
		});

		Scene view = new Scene(lineChart, 680, 480);
		String cssFile = getClass().getResource("styles.css").toExternalForm();
		view.getStylesheets().add(cssFile);
		stage.setScene(view);
		stage.show();
	}
	public static void main(String[] args) {
		launch(PartiesApplication.class);
	}

}
