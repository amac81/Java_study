package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Person;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter Person data:\n");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Height: ");
		double height = sc.nextDouble();
		System.out.print("Weight: ");
		double weight = sc.nextDouble();
		System.out.print("Age: ");
		int age = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine(); //clean buffer
		String email = sc.nextLine();
		
		Person person1 = new Person(name, height, weight, age,email);
		 

		System.out.print("\nPerson Data:" + person1.toString()); // toString() can be omitted

		
		sc.close();		
	}

}
