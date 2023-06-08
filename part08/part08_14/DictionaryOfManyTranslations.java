import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

	private HashMap<String, ArrayList<String>> dictiMap;

	public DictionaryOfManyTranslations() {
		this.dictiMap = new HashMap<>();
	}

	public void add(String word, String translation) {
		this.dictiMap.putIfAbsent(word, new ArrayList<>());
		this.dictiMap.get(word).add(translation);
	}

	public ArrayList<String> translate(String word) {
		ArrayList<String> newList = this.dictiMap.get(word);
		if (this.dictiMap.get(word) == null) {
			return new ArrayList<>();
		}
		return newList;
	}

	public void remove(String word) {
		this.dictiMap.remove(word);
	}
}
