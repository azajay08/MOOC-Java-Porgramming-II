import java.util.HashMap;

public class Abbreviations {
	
	private HashMap<String, String> abList;

	public Abbreviations() {
		this.abList = new HashMap<>();
	}

	public void addAbbreviation(String abbreviation, String explanation) {
		this.abList.put(abbreviation, explanation);
	}

	public boolean hasAbbreviation(String abbreviation) {
		if (this.abList.containsKey(abbreviation)) {
			return true;
		}
		return false;
	}


	public String findExplanationFor(String abbreviation) {
		if (hasAbbreviation(abbreviation)) {
			return this.abList.get(abbreviation);
		}
		return null;
	}
}
