
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// You can test the class here
		HashMap newMap = new HashMap<>();

		newMap.add("hello", 1);
		newMap.add(3, "world");
		newMap.add("!", 43);

		System.out.println(newMap.get("hello"));
		System.out.println(newMap.get(3));
	}

}
