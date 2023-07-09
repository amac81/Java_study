package services;

public class SpainlInterestService implements InterestService{
	private double interestRate;
	
	public SpainlInterestService() {}

	public SpainlInterestService(double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
