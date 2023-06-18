package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Person;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Person data:\n");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Height: ");
		double height = sc.nextDouble();
		System.out.print("Weight: ");
		double weight = sc.nextDouble();
		System.out.print("Age: ");
		int age = sc.nextInt();
		
		Person person1 = new Person(name, height, weight, age);

		System.out.print("\nPerson Data:" + person1.toString());

		System.out.println("\n\n######## SHOW DATA OF PERSON #########:\n");

		System.out.print("Name: " + person1.getName());
		System.out.print("\nAge: " + person1.getAge());

		System.out.println("\n\n######## CHANGE DATA OF PERSON #########:\n");

		System.out.println("Enter Person data to UPDATE:\n");
		System.out.print("Name: ");
		sc.nextLine(); // clear buffer
		name = sc.nextLine();
		person1.setName(name);

		person1.birthday();
		System.out.println("\nNew Age: " + person1.getAge());
		
		person1.increaseWeight(2.0);
		System.out.println("\nNew weight: " + person1.getWeight());
		

		person1.decreaseWeight(0.5);
		System.out.println("\nNew weight: " + person1.getWeight());		

		System.out.print("\nPerson Data:" + person1.toString());

		sc.close();
	}

}
