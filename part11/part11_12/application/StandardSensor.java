package application;

public class StandardSensor implements Sensor{
	
	private int val;

	public StandardSensor(int val) {
		this.val = val;
	}

	public boolean isOn() {
		return true;
	}

	public void setOn() {

	}

	public void setOff() {

	}

	public int read() {
		if (isOn()) {
			return this.val;
		} else {
			throw new IllegalStateException("Illegal state!");
		}
	}
}
