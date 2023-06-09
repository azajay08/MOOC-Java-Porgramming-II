public class Person {
	
	private String name;
	private String address;

	public Person(String name, String add) {
		this.name = name;
		this.address = add;
	}

	@Override
	public String toString() {
		return this.name + "\n  " + this.address;
	}
}
