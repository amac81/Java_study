package entities;

public class Product {
	public String name;
	public double price;
	public int quantity;

	public double TotalValueInStock() {
		return price * quantity;
	}

	public void AddProducts(int quantity) {
		this.quantity += quantity; // this: reserved word; self-reference to the object
	}

	public void RemoveProducts(int quantity) {
		this.quantity -= quantity; // this: reserved word; self-reference to the object
	}

	public String toString() {
		return name + ", " + String.format("%.2f", price) + " €, " + quantity + " unit(s), Total: "
				+ String.format("%.2f", TotalValueInStock()) + " €";
	}

}
