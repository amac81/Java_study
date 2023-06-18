package entities;

public class Product {
	public String name;
	public double price;
	public int quantity;
	
	
	//Class Product Constructors
	//Constructor Overloading in Java

	public Product() {}	

	public Product(String name, double price) {
		this.name = name;
		this.price = price;		
		//this.quantity = 0; or quantity = 0; optional
	}
	
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

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
