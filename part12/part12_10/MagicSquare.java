
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

	private int[][] square;

	// ready constructor
	public MagicSquare(int size) {
		if (size < 2) {
			size = 2;
		}

		this.square = new int[size][size];
	}

	// implement these three methods
	public ArrayList<Integer> sumsOfRows() {
		ArrayList<Integer> sums = new ArrayList<>();
		for (int x = 0; x < this.square.length; x++) {
			int sum = 0;
			for (int y = 0; y < this.square[x].length; y++) {
				sum += this.square[x][y];
			}
			sums.add(sum);
		}
		return sums;
	}

	public ArrayList<Integer> sumsOfColumns() {
		ArrayList<Integer> sums = new ArrayList<>();
		for (int x = 0; x < square.length; x++) {
			int sum = 0;
			for (int y = 0; y < square.length; y++) {
				sum += square[y][x];
			}
			sums.add(sum);
		}
		return sums;
	}

	public ArrayList<Integer> sumsOfDiagonals() {
		ArrayList<Integer> sums = new ArrayList<>();
		int sum = 0;
		int sum2 = 0;
		for (int x = 0; x < square.length; x++) {
			for (int y = 0; y < square.length; y++) {
				if (x == y) {
					sum += square[x][y];
				}

				if ((x + y) == (square.length - 1)) {
					sum2 += square[x][y];
				}
			}
		}
		sums.add(sum);
		sums.add(sum2);
		return sums;
	}

	// ready-made helper methods -- don't touch these
	public boolean isMagicSquare() {
		return sumsAreSame() && allNumbersDifferent();
	}

	public ArrayList<Integer> giveAllNumbers() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int row = 0; row < square.length; row++) {
			for (int col = 0; col < square[row].length; col++) {
				numbers.add(square[row][col]);
			}
		}

		return numbers;
	}

	public boolean allNumbersDifferent() {
		ArrayList<Integer> numbers = giveAllNumbers();

		Collections.sort(numbers);
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i - 1) == numbers.get(i)) {
				return false;
			}
		}

		return true;
	}

	public boolean sumsAreSame() {
		ArrayList<Integer> sums = new ArrayList<>();
		sums.addAll(sumsOfRows());
		sums.addAll(sumsOfColumns());
		sums.addAll(sumsOfDiagonals());

		if (sums.size() < 3) {
			return false;
		}

		for (int i = 1; i < sums.size(); i++) {
			if (sums.get(i - 1) != sums.get(i)) {
				return false;
			}
		}

		return true;
	}

	public int readValue(int x, int y) {
		if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
			return - 1;
		}

		return this.square[y][x];
	}

	public void placeValue(int x, int y, int value) {
		if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
			return;
		}

		this.square[y][x] = value;
	}

	public int getWidth() {
		return this.square.length;
	}

	public int getHeight() {
		return this.square.length;
	}

	@Override
	public String toString() {
		StringBuilder sums = new StringBuilder();
		for (int row = 0; row < square.length; row++) {
			for (int col = 0; col < square[row].length; col++) {
				sums.append(square[row][col]).append("\t");
			}

			sums.append("\n");
		}

		return sums.toString();
	}
}
