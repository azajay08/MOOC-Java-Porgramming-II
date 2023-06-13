import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	private Map<String, Item> cart;

	public ShoppingCart() {
		this.cart = new HashMap<>();
	}

	public void add(String product, int price) {
		Item comparedItem = new Item(product, 1, price);
		for (Item item : this.cart.values()) {
			if (item.equals(comparedItem)) {
				item.increaseQuantity();
				return;
			}
		}
		this.cart.put(product, comparedItem);
	}

	public int price() {
		int price = 0;
		for (Item item : this.cart.values()) {
			price += item.price();
		}
		return price;
	}

	public void print() {
		for (Item item : this.cart.values()) {
			System.out.println(item.getProd() + ": " + item.getQty());
		}
	}
}
