package entities.services;

public interface PaymentService {
	public double interests(double amount, int months);
	public double payRate(double amount);
}
