import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Matrix dimension (M): ");
		int m = sc.nextInt();
		System.out.print("Matrix dimension (N): ");
		int n = sc.nextInt();

		int[][] matrix = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}

		System.out.println("-----------------------------\n");

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
				if (j < m - 1)
					System.out.print("|");
			}
			if (i < n - 1)
				System.out.println();
		}

		System.out.println();

		System.out.print("\nValue to find in the matrix: ");
		int v = sc.nextInt();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == v) {
					// value found in the matrix
					System.out.printf("%nValue %d found at position [%d][%d] in matrix%n%n", v, i, j);

					if (j + 1 < n)// Bound protection
						System.out.printf("RIGHT: %d%n", matrix[i][j + 1]);

					if (j - 1 >= 0)// Bound protection
						System.out.printf("LEFT: %d%n", matrix[i][j - 1]);
					if (i - 1 >= 0)// Bound protection
						System.out.printf("TOP: %d%n", matrix[i - 1][j]);

					if (i + 1 < m)// Bound protection
						System.out.printf("DOWN: %d%n", matrix[i + 1][j]);
				}
			}
		}

		sc.close();
	}
}
