package dictionary;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {
	
	private HashMap<String, String> dictionary;
	private File file;

	public SaveableDictionary() {
		this.dictionary = new HashMap<>();
	}

	public SaveableDictionary(String file) {
		this.dictionary = new HashMap<>();
		this.file = new File(file);
	}

	public boolean load() {
		try {
			Scanner fileReader = new Scanner(Paths.get(this.file.getName()));
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] word = line.split(":");
				this.dictionary.putIfAbsent(word[0], word[1]);
			}
			return true;

		} catch (Exception e) {
			System.out.println("File loading error: " + e.getMessage());
			return false;
		}
	}

	public boolean save() {
		try {
			PrintWriter writer = new PrintWriter(this.file.getName());
			for (String word : this.dictionary.keySet()) {
				String translation = this.dictionary.get(word);
				writer.println(word + ":" + translation);
			}
			writer.close();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void add(String words, String translation) {
		this.dictionary.putIfAbsent(words, translation);
	}

	public String translate(String word) {
		for (String translation : this.dictionary.keySet()) {
			if (this.dictionary.get(translation).equals(word)) {
				return translation;
			} else if (this.dictionary.get(word) != null) {
				return this.dictionary.get(word);
			}
		}
		return null;
	}

	public void delete(String word) {
		String entryToDelete = "";
		for (String translation : this.dictionary.keySet()) {
			if (this.dictionary.get(translation).equals(word)) {
				entryToDelete = translation;
			} else if (this.dictionary.get(word) != null) {
				entryToDelete = word;
			}
		}
		this.dictionary.remove(entryToDelete);
	}
}
