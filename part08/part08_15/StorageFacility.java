import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
	
	private HashMap<String, ArrayList<String>> box;

	public StorageFacility() {
		this.box = new HashMap<>();
	}

	public void add(String unit, String item) {
		this.box.putIfAbsent(unit, new ArrayList<>());
		this.box.get(unit).add(item);
	}

	public ArrayList<String> contents(String storageUnit) {
		ArrayList<String> newList = this.box.get(storageUnit);
		if (this.box.get(storageUnit) == null) {
			return new ArrayList<>();
		}
		return newList;
	}

	public void remove(String storageUnit, String item) {
		this.box.get(storageUnit).remove(item);

		if (this.box.get(storageUnit).isEmpty()) {
			this.box.remove(storageUnit);
		}
	}

	public ArrayList<String> storageUnits() {
		ArrayList<String> unitList = new ArrayList<>();

		for (String unit : this.box.keySet()) {
			if (this.box.get(unit).isEmpty()) {
				continue;
			}
			unitList.add(unit);
		}
		return unitList;
	}
}
