package entities.services;

public class PaypalService implements PaymentService {

	@Override
	public double interests(double amount, int months) {
		// 1% interest rate	
		return amount * 0.01 * months;
	}

	@Override
	public double payRate(double amount) {
		// 2% taxes
		return amount * 0.02;
	}

}
