package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Product data:\n");
		System.out.print("Name: ");
		String productName = sc.nextLine();
		System.out.print("Price: ");
		double productPrice = sc.nextDouble();
		/*
		 * using the constructor forces the programmer to initialize the object's
		 * attributes.
		 * 
		 * For example, in the case of the Product class, it makes no sense to have an
		 * object of type Product (an instance) with no name / no price)
		 */
		Product product = new Product(productName, productPrice);

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
