package entities;

public class Individual extends TaxPayer {
	private Double healthExpenses;

	public Individual() {

	}

	public Individual(String name, Double annualIncome, Double healthExpenses) {
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

	
}

