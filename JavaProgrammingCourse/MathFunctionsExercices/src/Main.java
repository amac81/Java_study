import java.lang.Math;

public class Main {

	public static void main(String[] args) {

		// variables
		Double x = 10.0;
		int b = 5;
		int p = 2;
		Double a = -33.0;
		Double pi;

		// data print at screen
		System.out.println("\nMATH FUNCTIONS EXAMPLES\n");

		// Square root
		System.out.printf("\nThe SQRT of %.2f is %.2f%n", x, Math.sqrt(x));

		// power
		System.out.printf("\nThe value of the base %d raised to a power of %d is %.2f%n", b, p, Math.pow(b, p));

		// Absolute value
		System.out.printf("\nThe ABSOLUTE value of %.2f is %.2f%n", a, Math.abs(a));

		// PI value
		pi = Math.PI;
		System.out.printf("\nThe value of PI is %.15f%n", pi);

		// Rounded value of PI to the nearest integer.
		System.out.printf("\nThe rounded value of PI, (with Math.round), is %d%n", Math.round(pi));
		
		
		// Rounded UP value of PI to the nearest integer.
		System.out.printf("The rounded value of PI, (with Math.ceil), is %f%n", Math.ceil(pi));

		// Rounded DOWN value of PI to the nearest integer.
		System.out.printf("The rounded value of PI, (with Math.floor), is %f%n", Math.floor(pi));
	
	}

}
