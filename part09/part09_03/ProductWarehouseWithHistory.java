public class ProductWarehouseWithHistory extends ProductWarehouse{
	
	private ChangeHistory hisList = new ChangeHistory();

	public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
		super(productName, capacity);
		super.addToWarehouse(initialBalance);
		this.hisList.add(initialBalance);
	}

	public String history() {
		return this.hisList.toString();
	}

	public void addToWarehouse(double amount) {
		double result = 0;
		
		result = super.getBalance() + amount;
		this.hisList.add(result);	
		super.addToWarehouse(amount);
	}

	public double takeFromWarehouse(double amount) {
		double result = 0;
		
		result = super.getBalance() - amount;
		this.hisList.add(result);

		return super.takeFromWarehouse(amount);
	}

	public void printAnalysis() {
		System.out.println("Product: " + this.getName());
		System.out.println("History: " + this.hisList.toString());
		System.out.println("Largest amount of product: " + this.hisList.maxValue());
		System.out.println("Smallest amount of product:" + this.hisList.minValue());
		System.out.println("Average: " + this.hisList.average());
	}
}
