public class Teacher extends Person {
	
	private int salary;

	public Teacher(String name, String add, int salary){
		super(name, add);
		this.salary = salary;
	}

	public String toString() {
		return super.toString() + "\n  salary " + this.salary + " euro/month";
	}
}
