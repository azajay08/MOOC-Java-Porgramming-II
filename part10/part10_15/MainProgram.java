import java.io.InputStream;
import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {
		// you can create test code here. Call the methods that you'll implement
		// during the course of this exercise
		Scanner scan = new Scanner(System.in);
		Checker check = new Checker();
		System.out.print("Enter a string: ");
		String word = scan.nextLine();
		if (check.isDayOfWeek(word) == true) {
			System.out.println("The form is correct.");
		} else {
			System.out.println("The form is incorrect.");
		}
		System.out.print("Enter a string: ");
		word = scan.nextLine();
		if (check.allVowels(word) == true) {
			System.out.println("The form is correct.");
		} else {
			System.out.println("The form is incorrect.");
		}
		System.out.print("Enter a string: ");
		word = scan.nextLine();
		if (check.timeOfDay(word) == true) {
			System.out.println("The form is correct.");
		} else {
			System.out.println("The form is incorrect.");
		}
	}
}
