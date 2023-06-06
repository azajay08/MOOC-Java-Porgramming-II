import java.util.Scanner;

public class UserInterface {
	
	private TodoList list;
	private Scanner scan;

	public UserInterface(TodoList list, Scanner scan) {
		this.scan = scan;
		this.list = list;
	}

	public void start() {
		while (true) {
			System.out.print("Command: ");
			String command = this.scan.nextLine();

			if (command.equals("stop")) {
				break;
			} else if (command.equals("add")) {
				System.out.print("To add: ");
				this.list.add(this.scan.nextLine());
			} else if (command.equals("list")) {
				this.list.print();
			} else if (command.equals("remove")) {
				System.out.print("Which one is removed? ");
				this.list.remove(Integer.valueOf(this.scan.nextLine()));
			}
		}
	}
}
