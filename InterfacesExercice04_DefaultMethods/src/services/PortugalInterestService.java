package services;

public class PortugalInterestService implements InterestService{
	private double interestRate;
	
	public PortugalInterestService() {}

	public PortugalInterestService(double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
