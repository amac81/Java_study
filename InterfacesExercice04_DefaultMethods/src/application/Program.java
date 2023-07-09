package application;

import java.util.Locale;
import java.util.Scanner;

import services.InterestService;
import services.PortugalInterestService;


public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		
		System.out.print("Number of Months: ");
		int nMonths = sc.nextInt();
		
		InterestService interestService = new PortugalInterestService(5.0); //interest rate 5%
		
		double payment = interestService.payment(amount, nMonths);
		
		System.out.println("Payment after " + nMonths + " months = " + String.format("%.2f", payment));
		
		
		
		sc.close();
		
	
	}
}
