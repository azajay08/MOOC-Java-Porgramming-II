public class Container {
	private int liquidAmount;

	public Container() {
		this.liquidAmount = 0;
	}

	public int contains() {
		return this.liquidAmount;
	}

	public void add(int amount) {
		if (amount > 0) {
			this.liquidAmount = this.liquidAmount + amount > 100 ? 100 : this.liquidAmount + amount;
		}
	}

	public void remove(int amount) {
		this.liquidAmount = this.liquidAmount - amount < 0 ? 0 : this.liquidAmount - amount;
	}

	public void move(int amount, Container container) {
		if (amount > 0) {
			if (amount >= container.contains()) {
				this.add(container.contains());
				container.remove(container.contains());
			} else {
				this.add(amount);
				container.remove(amount);
			}
		}
	}

	public String toString() {
		return this.liquidAmount + "/100";
	}
}
