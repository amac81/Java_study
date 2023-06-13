package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		Product product = new Product();

		System.out.println("Enter Product data:\n");
		System.out.print("Name: ");
		product.name = sc.nextLine();
		System.out.print("Price: ");
		product.price = sc.nextDouble();
		System.out.print("Quantity in stock: ");
		product.quantity = sc.nextInt();

		System.out.print("\nProduct Data:" + product.toString()); // toString() can be omitted

		System.out.println("\n");
		System.out.print("Enter the number of products to be added to stock: ");
		int quantity = sc.nextInt();
		product.AddProducts(quantity);
		System.out.print("Updated Data:" + product.toString()); // toString() can be omitted

		System.out.println("\n");

		System.out.print("Enter the number of products to be removed from stock: ");
		quantity = sc.nextInt();
		product.RemoveProducts(quantity);
		System.out.print("Updated Data:" + product.toString()); // toString() can be omitted

		sc.close();
	}

}
