
public class MagicSquareEven {
	public static int[][] magicSquareSinglyEven(final int n) {
		if (n < 6 || (n - 2) % 4 != 0)
			throw new IllegalArgumentException("base must be a positive " + "multiple of 4 plus 2");

		int size = n * n;
		int halfN = n / 2;
		int subSquareSize = size / 4;

		int[][] subSquare = MagicSquareOdd.magicSquareOdd(halfN);
		int[] quadrantFactors = { 0, 2, 3, 1 };
		int[][] result = new int[n][n];

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int quadrant = (r / halfN) * 2 + (c / halfN);
				result[r][c] = subSquare[r % halfN][c % halfN];
				result[r][c] += quadrantFactors[quadrant] * subSquareSize;
			}
		}

		int nColsLeft = halfN / 2;
		int nColsRight = nColsLeft - 1;

		for (int r = 0; r < halfN; r++)
			for (int c = 0; c < n; c++) {
				if (c < nColsLeft || c >= n - nColsRight || (c == nColsLeft && r == nColsLeft)) {

					if (c == 0 && r == nColsLeft)
						continue;

					int tmp = result[r][c];
					result[r][c] = result[r + halfN][c];
					result[r + halfN][c] = tmp;
				}
			}

		return result;
	}
}
