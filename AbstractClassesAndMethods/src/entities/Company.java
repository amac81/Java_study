package entities;

public class Company extends Contributor {
	private int numberOfWorkers;

	public Company() {

	}

	public Company(String name, Double annualIncome, int numberOfWorkers) {
		super(name, annualIncome);
		this.numberOfWorkers = numberOfWorkers;
	}

	public int getNumberOfWorkers() {
		return numberOfWorkers;
	}

	public void setNumberOfWorkers(int numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}

	@Override
	public Double totalTaxesToPay() {
		// check annual income
		Double annualIncome = super.getAnnualIncome();

		Double annualIncomeTaxes = (numberOfWorkers > 10) ? annualIncome * 0.14 : annualIncome * 0.16;

		return annualIncomeTaxes;
	}

	@Override
	public void printMyInfo() {
		System.out.println("# COMPANY #");
		super.printGeneralInfo();
		System.out.println("Number of workers: " + numberOfWorkers);
	}

}