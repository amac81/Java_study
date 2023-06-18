package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static DateTimeFormatter dateFormat2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(OrderStatus status, Client client) {
		super();
		this.moment = LocalDateTime.now();
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	

	public List<OrderItem> getItems() {
		return items;
	}

	public Double total() {
		Double sum = 0.0;

		for (OrderItem oi : items) {
			sum += oi.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder orderSummary = new StringBuilder();

		orderSummary.append("ORDER SUMMARY:\n");
		orderSummary.append("Order moment: " + dateFormat2.format(moment) + "\n");
		orderSummary.append("Order status: " + status);
		orderSummary.append("\nCLIENT: " + client.getName());
		orderSummary.append(" (" + dateFormat1.format(client.getBirthDate()) + ") - " + client.getEmail());
		orderSummary.append("\nORDER ITEMS:\n");

		for (OrderItem oi : items) {
			Product p = oi.getProduct();
			orderSummary.append(p.getName() 
					+ "| Price: $" + p.getPrice() 
					+ "| Discount: $" + oi.getDiscount()
					+ "| Quantity: " + oi.getQuantity() 
					+ "| SubTotal: $" + oi.subTotal() + "\n");
		}

		return orderSummary.append("\nTotal price: $" + total() + "\n").toString();
	}

}
