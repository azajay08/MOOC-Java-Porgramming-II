import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Employees {
	
	private ArrayList<Person> people;

	public Employees() {
		this.people = new ArrayList<>();
	}

	public void add(Person personToAdd) {
		this.people.add(personToAdd);
	}

	public void add(List<Person> peopleToAdd) {
		Iterator<Person> iterator = peopleToAdd.iterator();
		while (iterator.hasNext()) {
			Person next = iterator.next();
			this.people.add(next);
		}
	}	

	public void print() {
		Iterator<Person> iterator = this.people.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void print(Education education) {
		Iterator<Person> iterator = this.people.iterator();
		while (iterator.hasNext()) {
			Person next = iterator.next();
			if (next.getEducation() == education) {
				System.out.println(next);
			}
		}
	}

	public void fire(Education education) {
		Iterator<Person> iterator = this.people.iterator();
		while (iterator.hasNext()) {
			Person next = iterator.next();
			if (next.getEducation() == education) {
				iterator.remove();
			}
		}
	}
}
