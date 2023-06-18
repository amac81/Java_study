package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dateFormat2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		System.out.println("\nEnter Client Data");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (dd/MM/yyyy): ");
		LocalDate clientBirhDate = LocalDate.parse(sc.nextLine(), dateFormat1);

		System.out.println("\nEnter Order Data");
		System.out.print("Status: ");
		String orderStatus = sc.nextLine();

		System.out.print("\nHow many items to this order? ");
		int numberOfItems = sc.nextInt();
		sc.nextLine(); // buffer clean
		System.out.println();

		Client client = new Client(clientName, clientEmail, clientBirhDate);
		Order order = new Order(OrderStatus.valueOf(orderStatus), client);

		for (int i = 0; i < numberOfItems; i++) {
			System.out.printf("Enter #%d item data%n", i + 1);
			System.out.print("Product Name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			System.out.print("Product discount: ");
			Double productDiscount = sc.nextDouble();
			System.out.println();

			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(productQuantity, productDiscount, product);
			order.addItem(item);
			sc.nextLine(); // buffer clean
		}

		System.out.println();

		StringBuilder orderSummary = new StringBuilder();

		orderSummary.append("ORDER SUMMARY:\n");
		orderSummary.append("Order moment: " + dateFormat2.format(order.getMoment()) + "\n");
		orderSummary.append("Order status: " + order.getStatus());
		orderSummary.append("\nCLIENT: " + order.getClient().getName());
		orderSummary.append(" (" + dateFormat1.format(order.getClient().getBirthDate()) + ") - " + order.getClient().getEmail());
		orderSummary.append("\nORDER ITEMS:\n");

		for (OrderItem oi : order.getItems()) {
			Product p = oi.getProduct();
			orderSummary.append(p.getName() 
					+ "| Price: $" + p.getPrice() 
					+ "| Discount: $" + oi.getDiscount()
					+ "| Quantity: " + oi.getQuantity() 
					+ "| SubTotal: $" + oi.subTotal() + "\n");
		}

		orderSummary.append("\nTotal price: $" + order.total() + "\n");

		System.out.print(orderSummary);
		sc.close();
	}

}
