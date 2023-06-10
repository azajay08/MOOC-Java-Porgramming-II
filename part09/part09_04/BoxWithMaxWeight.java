import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
	
	private ArrayList<Item> itemsInBox;
	private int capacity;

	public BoxWithMaxWeight(int capacity) {
		this.capacity = capacity;
		this.itemsInBox = new ArrayList<>();
	}

	public void add(Item item) {
		if (item.getWeight() <= this.capacity) {
			this.itemsInBox.add(item);
			this.capacity -= item.getWeight();
		}
	}

	public boolean isInBox(Item item) {
		for (Item itemIn : this.itemsInBox) {
			if (itemIn.equals(item)) {
				return true;
			}
		}
		return false;
	}
	
}
