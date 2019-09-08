
public class MagicSquareOdd {
	public static int[][] magicSquareOdd(final int n) {
		if (n < 3 || n % 2 == 0)
			throw new IllegalArgumentException("base must be odd and > 2");

		int value = 0;
		int gridSize = n * n;
		int c = n / 2, r = 0;

		int[][] result = new int[n][n];

		while (++value <= gridSize) {
			result[r][c] = value;
			if (r == 0) {
				if (c == n - 1) {
					r++;
				} else {
					r = n - 1;
					c++;
				}
			} else if (c == n - 1) {
				r--;
				c = 0;
			} else if (result[r - 1][c + 1] == 0) {
				r--;
				c++;
			} else {
				r++;
			}
		}
		return result;
	}
}
