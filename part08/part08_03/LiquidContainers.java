
import java.util.Scanner;

public class LiquidContainers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstContainer = 0;
		int secondContainer = 0;

		while (true) {
			System.out.print("> ");
			System.out.println("First: " + firstContainer + "/100");
			System.out.println("Second: " + secondContainer + "/100");
			String input = scan.nextLine();
			if (input.equals("quit")) {
				break;
			}
			String[] parts = input.split(" ");
			String command = parts[0];
			int amount = Integer.valueOf(parts[1]);
			if (command.equals("add")) {
				if (amount > 0) {
					firstContainer = firstContainer + amount > 100 ? 100 : firstContainer + amount;
				}
			} else if (command.equals("move")) {
				if (amount > 0) {
					if (amount >= firstContainer) {
						secondContainer = secondContainer + firstContainer > 100 ? 100 : secondContainer + firstContainer;
						firstContainer = 0;
					} else {
						secondContainer = secondContainer + amount > 100 ? 100 : secondContainer + amount;
						firstContainer -= amount;
					}
				}
			} else if (command.equals("remove")) {
				secondContainer = secondContainer - amount < 0 ? 0 : secondContainer - amount;
			}
		}
	}

}
