package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
	
	private boolean on;

	public TemperatureSensor() {
		this.on = false;
	}

	public boolean isOn() {
		return this.on;
	}

	public void setOn() {
		this.on = true;
	}

	public void setOff() {
		this.on = false;
	}

	public int read() {
		if (this.isOn()) {
			return new Random().nextInt(61) - 30;
		} else {
			throw new IllegalStateException("Illegal state!");
		}
	}
}
