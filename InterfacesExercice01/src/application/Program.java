package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import entities.services.ContractService;
import entities.services.PaypalPayment;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dataFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter contract data:\n");
		System.out.print("Number: ");
		int contractNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Date: ");
		LocalDate date =  LocalDate.parse(sc.nextLine(), dataFormat1);
		System.out.print("Total Value: ");
		double contactTotalValue = sc.nextDouble();
		
		System.out.print("Number of months of contract fractionation: ");
		int monthNumber = sc.nextInt();
		
		Contract contract = new Contract(contractNumber, date, contactTotalValue);
		ContractService contractService = new ContractService(contract, monthNumber, new PaypalPayment());
		
		System.out.println();
		
		System.out.println("INSTALLMENTS:");
		
		
		for(Installment i: contractService.getInstallments()) {
			System.out.println(i);
		}
		
		
		sc.close();
	}

}
