
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<String> numbers = new ArrayList<>();
		System.out.println("Input numbers, type \"end\" to stop.");
		while (true) {
			String input = scanner.nextLine();
			if (input.equals("end")) {
				break;
			}
			numbers.add(input);
		}
		double avg = 0;
		System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
		String choice = scanner.nextLine();
		if (choice.equals("n")) {
			avg = numbers.stream()
				.mapToInt(s -> Integer.valueOf(s))
				.filter(num -> num < 0)
				.average()
				.getAsDouble();
			System.out.println("Average of the negative numbers: " + avg);
		} else {
			avg = numbers.stream()
				.mapToInt(s -> Integer.valueOf(s))
				.filter(num -> num > 0)
				.average()
				.getAsDouble();
			System.out.println("Average of the positive numbers: " + avg);
		}
	}
}
