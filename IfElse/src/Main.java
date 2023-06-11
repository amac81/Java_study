import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		// variables
		int x;
		int y;
		Double v;

		System.out.printf("# POSITVE or NEGATIVE #%n");
		
		// ask for number entry, from keyboard
		System.out.printf("Enter a number%n");
		x = sc.nextInt();

		// test if integer number is negative or positive
		if (x >= 0) {
			System.out.printf("The number %d is POSITIVE%n%n", x);
		} else {
			System.out.printf("The number %d is NEGATIVE%n%n", x);
		}
		
		/* the previous example could be done using the java ternary operator
		 * the logical test would be done like this:
		 * 
		 * String result = (x>=0) ? "POSITIVE" : "NEGATIVE";	
		 * System.out.printf("The number %d is %s%n%n", x, result);
	    */


		System.out.printf("# EVEND or ODD #%n%n");

		System.out.printf("Enter a number %n");
		y = sc.nextInt();
		
		// test if integer number is odd or even
		if (y%2 == 0) {
			System.out.printf("The number %d is EVEN%n%n", y);
		} else {
			System.out.printf("The number %d is ODD%n%n", y);
		}

		System.out.printf("# MULTIPLE between or NOT #%n%n");

		
		System.out.printf("Enter first number%n");
		x = sc.nextInt();
		System.out.printf("Enter second number%n");
		y = sc.nextInt();
		
		// test if x / y == 0 OR y / x == 0, if so numbers are Multiple between them
		if ((x % y == 0)||(y % x == 0)) {
			System.out.printf("The number %d and %d are MULTIPLE%n%n", x, y);
		} else {
			System.out.printf("The number %d and %d are NOT MULTIPLE%n%n", x, y);
		}
		
		System.out.printf("# Number IN THE RANGE OF #%n");

		
		System.out.printf("Enter a number%n");
		v = sc.nextDouble();
		
		if ((v >= 0) && (v <= 25)) {
			System.out.printf("The number %f is in the range [0, 25]", v);
		} else if ((v > 25) && (v <= 50)) {
			System.out.printf("The number %f is in the range [26, 50]", v);
		} else if ((v > 50) && (v <= 75)) {
			System.out.printf("The number %f is in the range [51, 75]", v);
		} else if ((v > 75) && (v <= 100)) {
			System.out.printf("The number %f is in the range [76, 100]", v);
		}
		else {
			System.out.printf("The number %f is OUT OF RANGE [0, 100]", v);
		}
		
		sc.close();
	}

}
