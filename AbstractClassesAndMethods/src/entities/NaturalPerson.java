package entities;

public class NaturalPerson extends Contributor {
	private Double healthExpenses;

	public NaturalPerson() {

	}

	public NaturalPerson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public Double totalTaxesToPay() {

		// check annual income
		Double annualIncome = super.getAnnualIncome();
		Double annualIncomeTaxes = (annualIncome < 20000.0) ? annualIncome * 0.15 : annualIncome * 0.25;

		// check if check if contributor has health expenses to deduct in the
		// calculation
		Double deductibleHealthExpenses = (healthExpenses > 0) ? healthExpenses * 0.5 : 0.0;

		return annualIncomeTaxes - deductibleHealthExpenses;
	}

	@Override
	public void printMyInfo() {
		System.out.println("# NATURAL PERSON #");
		super.printGeneralInfo();
		System.out.println("Health expenses: " + this.healthExpenses);
	}

}

