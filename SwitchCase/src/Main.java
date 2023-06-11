import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// variables
		int x;
		String dayOfWeek = null;

		System.out.printf("# WEEK DAY CHOOSE #%n%n");

		// ask for number entry, from keyboard
		System.out.printf("Enter a number%n");
		x = sc.nextInt();

		switch (x) {
		case 1: {
			dayOfWeek = "Monday";
			break;
		}
		case 2: {
			dayOfWeek = "Tuesday";
			break;
		}
		case 3: {
			dayOfWeek = "Wednesday";
			break;
		}
		case 4: {
			dayOfWeek = "Thursday";
			break;
		}
		case 5: {
			dayOfWeek = "Friday";
			break;
		}
		case 6: {
			dayOfWeek = "Saturday";
			break;
		}
		case 7: {
			dayOfWeek = "Sunday";
			break;
		}
		default:
			dayOfWeek = "invalid value";
			break;
		}

		System.out.printf("%nThe corresponding day of the week is: %s", dayOfWeek);

		sc.close();
	}

}
