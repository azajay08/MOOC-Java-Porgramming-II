
import java.util.Objects;

public class LicensePlate {
	// don't modify existing parts of this class

	// these instance variables have been defined as final, meaning 
	// that once set, their value can't be changed
	private final String liNumber;
	private final String country;

	public LicensePlate(String country, String liNumber) {
		this.liNumber = liNumber;
		this.country = country;
	}

	@Override
	public String toString() {
		return country + " " + liNumber;
	}

	public int hashCode() {
		String plate = this.liNumber + this.country;
		return plate.hashCode();
	}

	public boolean equals(Object comparedObject) {
		if (this == comparedObject) {
			return true;
		}

		if (!(comparedObject instanceof LicensePlate)) {
			return false;
		}

		LicensePlate plate = (LicensePlate) comparedObject;

		if (this.liNumber == plate.liNumber &&
		this.country == plate.country) {
			return true;
		}

		return false;
	}

}
