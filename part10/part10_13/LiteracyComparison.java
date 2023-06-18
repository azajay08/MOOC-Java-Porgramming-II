
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {

	public static void main(String[] args) {
		// ArrayList<String> lines = new ArrayList<>();
		try {
			Files.lines(Paths.get("literacy.csv"))
				.map(row -> row.split(","))
				.filter(parts -> parts.length >= 6)
				.sorted((c1, c2) -> {
					return c1[5].compareTo(c2[5]);
				})
				.forEach(c -> System.out.println(c[3] + " ("
				+ c[4] + "), " + String.format(c[2].trim().split(" ")[0].trim()) + ", " + c[5]));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
