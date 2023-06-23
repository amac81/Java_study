package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("\nHow many products to add? ");
		int numberOfProducts = sc.nextInt();
		sc.nextLine(); // buffer clean
		System.out.println();

		// Product List
		List<Product> products = new ArrayList<>();

		for (int i = 0; i < numberOfProducts; i++) {
			System.out.printf("Enter #%d Product data%n", i + 1);
			System.out.print("Common, used or imported (c, u, i)?: ");
			char productType = sc.next().charAt(0);
			sc.nextLine(); // buffer clean

			System.out.print("Product Name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			sc.nextLine(); // buffer clean
			
			Product product = null;
			switch (productType) {
			case 'c': {
				product = new Product(productName, productPrice);
				break;
			}
			case 'u': {
				System.out.print("Manufactured Date:");
				LocalDate manufactureDate = LocalDate.from(dateFormat1.parse(sc.nextLine()));
				product = new UsedProduct(productName, productPrice, manufactureDate);
				break;
			}
			case 'i': {
				System.out.print("Customs fee:");
				Double customsFee = sc.nextDouble();				
				product = new ImportedProduct(productName, productPrice, customsFee);
				break;
			}
			default:
				break;

			}

			products.add(product);
		}
		
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for(Product p: products) {
			System.out.println(p.priceTag());
		}

		sc.close();
	}

}
