package entities;

public class ImportedProduct extends Product {
	private Double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String productName, Double productPrice, Double customsFee) {
		super(productName, productPrice);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	
	public Double totalPrice(){
		return super.getPrice() + this.customsFee;		
	}
	
	
	@Override
	public String priceTag(){
		return super.getName() + ", " + totalPrice() + "€ (Customs fee: " + customsFee + " €)";
	}
	
	@Override
	public String toString() {
		return "ImportedProduct [customsFee=" + customsFee + "]";
	}
		
}
