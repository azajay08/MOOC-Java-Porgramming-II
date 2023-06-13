import java.util.Objects;

public class Item {
	
	private String product;
	private int qty;
	private int unitPrice;

	public Item(String product, int qty, int unitPrice) {
		this.product = product;
		this.qty = qty;
		this.unitPrice = unitPrice;
	}

	public int price() {
		return getQty() * this.unitPrice;
	}

	public void increaseQuantity() {
		this.qty++;
	}

	public String toString() {
		return this.product + ": " + this.qty;
	}

	public String getProd() {
		return this.product;
	}

	public int getQty() {
		return this.qty;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Item)) {
			return false;
		}

		Item newObj = (Item) obj;

		if (newObj.product.equals(getProd())) {
			return true;
		}
		return false;
	}
}
