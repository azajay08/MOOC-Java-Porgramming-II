import static java.lang.Math.abs;

public class MagicSquareFactory {

	public MagicSquare createMagicSquare(int size) {

		MagicSquare square = new MagicSquare(size);
		int x = 0;
		int y = size / 2;
		int loopSize = (size * size);
		square.placeValue(y, x, 1);
		for (int i = 2; i <= loopSize; i++) {
			x--;
			y++;
			if (x < 0) {
				x = size - 1;
			}
			if (square.readValue(y % size, x) != 0) {
				y--;
				if (size - x < 2) {
					int remainder = size - x;
					x = 0 + remainder;
				} else {
					x += 2;
				}
			}
			square.placeValue(y % size, x, i);
		}

		// make another function that coverts to correct axis then can make a read value with those values

		// implement the creation of a magic square with the Siamese method algorithm here
		return square;
	}

}
