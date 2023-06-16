import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Matrix dimension (n): ");

		int n = sc.nextInt();

		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				matrix[i][j] = i ;
			}
		
		System.out.println("-----------------------------\n");
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
				if(j < n-1)
					System.out.print("|");
			}
			if(i < n-1)
				System.out.println();

		}

		sc.close();
	}
}
