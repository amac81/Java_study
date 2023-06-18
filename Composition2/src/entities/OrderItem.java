package entities;

public class OrderItem {
	private int quantity;
	private Double discount;
	private Product product;

	public OrderItem() {
	}

	public OrderItem(int quantity, Double discount, Product product) {
		super();
		this.quantity = quantity;
		this.discount = discount;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal() {
		return quantity * product.getPrice() - discount;
	}

	@Override
	public String toString() {
		return "OrderItem [quantity=" + quantity + ", discount=" + discount + ", price=" + product.getPrice()
				+ ", name=" + product.getName() + "]";
	}

}
