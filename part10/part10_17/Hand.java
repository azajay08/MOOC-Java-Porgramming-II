import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Hand implements Comparable<Hand> {
	
	private ArrayList<Card> hand;

	public Hand() {
		this.hand = new ArrayList<>();
	}

	public void add(Card card) {
		this.hand.add(card);
	}

	public void print() {
		Iterator<Card> iterator = this.hand.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void sort() {
		Comparator<Card> comparator = Comparator
			.comparing(Card::getValue)
			.thenComparing(Card::getSuit);
		Collections.sort(this.hand, comparator);
	}

	@Override
	public int compareTo(Hand handToCompare) {
		int handValue = 0;
		for (Card card : this.hand) {
			handValue += card.getValue();
		}
		int compareValue = 0;
		for (Card card : handToCompare.hand) {
			compareValue += card.getValue();
		}
		return handValue - compareValue;
	}

	public void sortBySuit() {
		Collections.sort(hand, new BySuitInValueOrder());
	}
}
