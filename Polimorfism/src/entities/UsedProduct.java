package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

	private static DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate manafactureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String productName, Double productPrice, LocalDate manafactureDate) {
		super(productName, productPrice);
		this.manafactureDate = manafactureDate;
	}

	public LocalDate getManafactureDate() {
		return manafactureDate;
	}

	public void setManafactureDate(LocalDate manafactureDate) {
		this.manafactureDate = manafactureDate;
	}

	@Override
	public String priceTag() {
		return super.getName() + " (used), " + super.getPrice() + "€ (Manufactured on: "
				+ dateFormat1.format(manafactureDate).toString() + ")";
	}

	@Override
	public String toString() {
		return "UsedProduct [manafactureDate=" + manafactureDate + "]";
	}

}
