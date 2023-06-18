package util;


public class CurrencyConverter {
		
	public static double dollarsToEuros(double dollarPrice, int quantity) { //static 
		
		return (quantity * dollarPrice) + (quantity * dollarPrice) * 0.06; //6% taxes
	}

}
