/*
 * https://www.geeksforgeeks.org/access-and-non-access-modifiers-in-java/
 * 
 * Access and non access modifiers in JAVA
				
								+---------+---------+-----------+--------+
								| default | private | protected | public |
+-------------------------------+---------+---------+-----------+--------+
|same class				        |   yes   |   yes   |    yes    |  yes   |
+-------------------------------+---------+---------+-----------+--------+
|same package subclass 	        |   yes   |    no   |    yes    |  yes   |
+-------------------------------+---------+---------+-----------+--------+
|same package non-subclass      |   yes   |    no   |    yes    |  yes   |
+-------------------------------+---------+---------+-----------+--------+
|different package subclass     |    no   |    no   |    yes    |  yes   |
+-------------------------------+---------+---------+-----------+--------+
|different package non-subclass |    no   |    no   |     no    |  yes   |
+-------------------------------+---------+---------+-----------+--------+
 * 
 * 
 */

package application;

import java.util.Locale;
import java.util.Scanner;

import entities.AccountHolder;
import entities.BankAccount;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.println("######## ACCOUNT HOLDER DATA #########:\n");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Age: ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Vat Identifier Number: ");
		String vatIdentifierNumber = sc.nextLine();

		System.out.print("Address: ");
		String address = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Phone Number: ");
		String phoneNumber = sc.nextLine();
		
		AccountHolder accountHolder = new AccountHolder(name, age, vatIdentifierNumber, address, email, phoneNumber);
		System.out.print("\n" + accountHolder.toString());
		
		System.out.println("\n\n######## ACCOUNT DATA #########:\n\n");
		
		System.out.print("Account Number: ");
		int accountNumber = sc.nextInt();
		
		
		System.out.println("Initial Deposit (s/n)?");
		char initialDeposit = sc.next().charAt(0);
		
		double amount = 0.0;
		
		if(initialDeposit == 's') {
			System.out.print("Amount: ");
			amount = sc.nextDouble();	
		}
		
				
		BankAccount bankAccount = new BankAccount(accountNumber, amount,  accountHolder);
		System.out.print("\n" + bankAccount.toString());
		
		System.out.println("\n\n######## DEPOSIT #########:\n");
		
		System.out.print("\nAmount to deposit:");
		amount = sc.nextDouble();
		bankAccount.deposit(amount);
		System.out.println("Balance: " + bankAccount.getBalance());
		
		System.out.println("\n######## WITHDRAW #########:\n");
		
		System.out.print("\nAmount to withdraw:");
		amount = sc.nextDouble();
		bankAccount.withdraw(amount, 5.0); //5.0 of bank commission
		System.out.println("Balance: " + bankAccount.getBalance());
		
		sc.close();
	}

}
