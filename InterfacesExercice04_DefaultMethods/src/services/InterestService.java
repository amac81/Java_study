package services;

import java.security.InvalidParameterException;

/*
 * With default methods, interfaces can provide reuse
 * 
 * In this example we have multiple inheritance.
 * 
 * In some cases, the diamond problem may occur, but if this happens, 
 * the compiler will alert you if there is a method with the same signature, it forces us to rewrite it
 * 
 * yet interfaces are very different from abstract classes. 
 * They lack features such as attributes and constructors.
 * 
 * */

public interface InterestService {
	double getInterestRate();

	default double payment(double amount, int nMonths) {
		// defensive programming
		if (nMonths < 1) {
			throw new InvalidParameterException("Invalid number of months, ");
		}

		return amount * Math.pow((1.0 + getInterestRate() / 100), nMonths);
	}
}
