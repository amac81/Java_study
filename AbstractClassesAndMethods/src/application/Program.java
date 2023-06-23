package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.TaxPayer;
import entities.Individual;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("\nHow many Tax Payers to add? ");
		int numberOfTaxPayers = sc.nextInt();
		sc.nextLine(); // buffer clean
		System.out.println();

		// Contributor List
		List<TaxPayer> contributors = new ArrayList<>();

		for (int i = 0; i < numberOfTaxPayers; i++) {
			System.out.printf("Enter #%d Tax Payer data%n", i + 1);
			System.out.print("Tax Payer Type (i, c)?: ");
			char contributorType = sc.next().charAt(0);
			sc.nextLine(); // buffer clean

			System.out.print("Name: ");
			String contributorName = sc.nextLine();
			System.out.print("Annual income: ");
			Double annualIncome = sc.nextDouble();
			sc.nextLine(); // buffer clean

			TaxPayer contributor = null;
			switch (contributorType) {
			case 'i': {
				System.out.print("Health Expenses: ");
				Double healthExpenses = sc.nextDouble();

				contributor = new Individual(contributorName, annualIncome, healthExpenses);
				break;
			}
			case 'c': {
				System.out.print("Number of workers: ");
				int numberOfWorkers = sc.nextInt();

				contributor = new Company(contributorName, annualIncome, numberOfWorkers);
				break;
			}

			default:
				break;
			}

			contributors.add(contributor);
		}

		System.out.println();
		System.out.println("TAXES PAIED:");
		System.out.println();
		Double totalCollectedTaxes = 0.0;

		for (TaxPayer c : contributors) {
			System.out.printf(c.getName(), " :", c.totalTaxesToPay(), " €");
			totalCollectedTaxes += c.totalTaxesToPay();
			System.out.println();
		}
		
		System.out.println();
		System.out.printf("Total Collected Taxes: %.2f", totalCollectedTaxes);		

		sc.close();
	}

}
