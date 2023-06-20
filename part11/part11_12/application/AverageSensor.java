package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

	private ArrayList<Sensor> sensors;
	private ArrayList<Integer> readings;

	public AverageSensor() {
		this.sensors = new ArrayList<>();
		this.readings = new ArrayList<>();
	}

	public boolean isOn() {
		for (Sensor sensor : this.sensors) {
			if (!sensor.isOn()) {
				return false;
			}
		}
		return true;
	}

	public void setOn() {
		for (Sensor sensor : this.sensors) {
			sensor.setOn();
		}
	}

	public void setOff() {
		for (Sensor sensor : this.sensors) {
			sensor.setOff();
		}
	}

	public int read() {
		if (!this.isOn() || this.sensors.isEmpty()) {
			throw new IllegalStateException("Sensors switched off or do not exist");
		}
		int avg = this.sensors.stream().mapToInt(i -> i.read()).sum() / this.sensors.size();
		this.readings.add(avg);
		return avg;
			
	}

	public void addSensor(Sensor toAdd) {
		this.sensors.add(toAdd);
	}

	public List<Integer> readings() {
		return this.readings;
	}
}
