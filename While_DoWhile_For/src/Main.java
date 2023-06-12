import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// variables
		int x = 0;
		Double a = 0.0;
		Double b = 0.0;
		Double sum = 0.0;
		char c = 0;

		/*
		 * while(): use when you do not previously know the number of repetitions; if
		 * condition result = true: enter while and repeat if condition result = false:
		 * do not execute and exit while
		 */

		// example while(): ask for a password input

		while (x != 1234) {
			System.out.println("Enter password");
			x = sc.nextInt();
		}

		System.out.printf("Access granted%n");

		/*
		 * do {} while(): the code inside is executed at least once, since the condition
		 * is checked at the end if test result = true: repeat if test result = false:
		 * don't repeat
		 */

		// do {} while(): repeat the sum of two values until the user responds that he
		// does not want to repeat (c == 'n')
		do {
			System.out.println("Enter first number");
			a = sc.nextDouble();
			System.out.println("Enter second number");
			b = sc.nextDouble();

			System.out.printf("The SUM of number %f with number %f is: %f%n%n", a, b, a + b);

			System.out.println("Do you want to repeat ? (n to exit)");
			c = sc.next().charAt(0);
		} while (c != 'n');
		
		
		/*
		 * for(begin; condition; increment) {}: use when we previously know the number of repetitions 
		 * if condition result = true: execute code inside {} and repeat 
		 * if condition result = false: exit/does not enter {}
		 */
		
		//example: repeat the sum of values, entered by user, the N times the user decided before. At the end it shows the sum on the screen
		
		System.out.println("Repeat how many times?");
		x = sc.nextInt();
		
		for(int i=0; i<x; i++) {
			System.out.println("Enter a number");
			a = sc.nextDouble();
			sum = sum + a;
		}
		
		System.out.printf("The SUM is %f", sum);

		sc.close();
	}

}
