package entities;

public abstract class Contributor {
	private String name;
	private Double annualIncome;

	public Contributor() {

	}

	public Contributor(String name, Double annualIncome) {
		super();
		this.name = name;
		this.annualIncome = annualIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}
	
	public abstract Double totalTaxesToPay ();

	public abstract void printMyInfo();		
	
	public void printGeneralInfo() {
		System.out.println("Name: " + name);
		System.out.println("Annual income: " + annualIncome);
		System.out.printf("Total Taxes To Pay: %.2f%n", totalTaxesToPay(), " €");
	}

}
