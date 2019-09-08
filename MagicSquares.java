import java.util.Scanner;

public class MagicSquares {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mat[][];
		if (n % 2 != 0) {
			mat = MagicSquareOdd.magicSquareOdd(n);
		} else {
			boolean divisibleByFour = n % 4 == 0;
			if (divisibleByFour) {
				mat = MagicSquareDoublyEven.doublyEven(n);
			} else {
				mat = MagicSquareEven.magicSquareSinglyEven(n);
			}
		}
		for (int[] row : mat) {
			for (int x : row)
				System.out.printf("%2s ", x);
			System.out.println();
		}
		System.out.printf("\nMagic constant: %d ", (n * n + 1) * n / 2);
	}
}
