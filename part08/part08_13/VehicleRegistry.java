import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

	private HashMap<LicensePlate, String> regMap;

	public VehicleRegistry() {
		this.regMap = new HashMap<>();
	}

	public boolean add(LicensePlate licensePlate, String owner) {
		for (LicensePlate plate : this.regMap.keySet()) {
			if (plate.equals(licensePlate)) {
				return false;
			}
		}
		this.regMap.put(licensePlate, owner);
		return true;
	}

	public String get(LicensePlate licensePlate) {
		if (this.regMap.containsKey(licensePlate)) {
			return this.regMap.get(licensePlate);
		}
		return null;
	}

	public boolean remove(LicensePlate licensePlate) {
		if (this.regMap.containsKey(licensePlate)) {
			this.regMap.remove(licensePlate);
			return true;
		}
		return false;
	}

	public void printLicensePlates() {
		for (LicensePlate plate : this.regMap.keySet()) {
			System.out.println(plate);
		}
	}

	public void printOwners() {
		ArrayList<String> owners = new ArrayList<>();


		for (String name : this.regMap.values()) {
			if (!owners.contains(name)) {
				owners.add(name);
			}
		}
		for (String name : owners) {
			System.out.println(name);
		}
	}
}
