import java.util.ArrayList;
import java.util.Collections;

public class ChangeHistory {
	
	private ArrayList<Double> list;

	public ChangeHistory() {
		this.list = new ArrayList<>();
	}

	public void add(double status) {
		this.list.add(status);
	}

	public void clear() {
		this.list.clear();
	}

	@Override
	public String toString() {
		return this.list.toString();
	}

	public double maxValue() {
		double max = 0;
		for (Double num : this.list) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}

	public double minValue() {
		if (this.list.isEmpty()) {
			return 0.0;
		}

		return  1.0 * Collections.min(this.list);
	}

	public double average() {
		double avg = 0;

		for (Double num : this.list) {
			avg += num;
		}

		return avg / this.list.size();
	}
}
