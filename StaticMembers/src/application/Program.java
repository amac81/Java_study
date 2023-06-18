package application;

import java.util.Locale;
import java.util.Scanner;

import util.Calculator;
import util.CurrencyConverter;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		System.out.println("CALCULATOR\n");
		
		System.out.print("Enter radius: ");
		double radius = sc.nextDouble();
		double c = Calculator.circumference(radius);
		double v = Calculator.volume(radius);
		
		System.out.printf("Circumference: %.2f%n", c);
		System.out.printf("Volume: %.2f%n", v);
		System.out.printf("PI value: %.2f%n", Calculator.PI);
		
		
		System.out.println("CURRENCY CONVERTER\n");
		System.out.print("What is the dollar price? ");
		double dollarPrice = sc.nextDouble();
		
		System.out.print("How many dollars will be bought? ");
		int quantityToBuy = sc.nextInt();
		
		double amountToPay = CurrencyConverter.dollarsToEuros(dollarPrice, quantityToBuy);
		
		System.out.printf("Amount to be paid in Euros (including 6 %% of taxes): %.2f €", amountToPay);
		
		
		
		
		

		sc.close();
	}

}
