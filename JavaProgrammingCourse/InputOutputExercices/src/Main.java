import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		// variables
		String name;
		int age = 0;
		Double height = 0.0;
		Double weight = 0.0;
		char gender;

		// ask for data input from keyboard
		System.out.println("What's your name ?");
		name = sc.next();

		System.out.println("What's your gender ?");
		gender = sc.next().charAt(0);

		System.out.println("What's your age ?");
		age = sc.nextInt();

		System.out.println("What's your height ?");
		height = sc.nextDouble();

		System.out.println("What's your weight ?");
		weight = sc.nextDouble();

		// data print at screen
		System.out.println("\nThe data you entered:");
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.printf("Height: %.2f%n", height);
		System.out.printf("Weight: %.2f%n", weight);
		System.out.println("Gender: " + gender); 
		
		sc.nextLine(); // to clean buffer; otherwise last enter from sc.nextDouble() will be "consumed" by nextLine;
		
		//read text to line break
		String s1, s2, s3;
		
		System.out.println("write text 1 (enter at the end) ?");
		s1 = sc.nextLine();
		System.out.println("write text 2 (enter at the end) ?");
		s2 = sc.nextLine();
		System.out.println("write text 3 (enter at the end) ?");
		s3 = sc.nextLine();
		
		// data print at screen
		System.out.println("\nThe data you entered:");
		System.out.println("S1: " + s1);
		System.out.println("S2: " + s2);
		System.out.println("S3: " + s3);
		
		sc.close();
	}

}
