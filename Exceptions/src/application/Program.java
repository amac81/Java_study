package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter bank account data");
			System.out.print("Number: ");
			int accountNumber = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine(); // clean buffer
			String holderName = sc.nextLine();

			System.out.print("Initial ballance: ");
			Double initialBallance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();

			System.out.println();

			Account account = new Account(accountNumber, holderName, initialBallance, withdrawLimit);

			System.out.print("Enter amount for withdraw: ");
			Double withdrawAmount = sc.nextDouble();

			account.withDraw(withdrawAmount);

			System.out.printf("New balance: %.2f", account.getBalance());

		} 
		catch (BusinessException e) 
		{
			System.out.println(e.getMessage());
		} 
		catch (RuntimeException e) 
		{
			System.out.println("Unexpected error !");
		}

		sc.close();
	}

}
