package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Contributor;
import entities.NaturalPerson;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("\nHow many Contributors to add? ");
		int numberOfContributors = sc.nextInt();
		sc.nextLine(); // buffer clean
		System.out.println();

		// Contributor List
		List<Contributor> contributors = new ArrayList<>();

		for (int i = 0; i < numberOfContributors; i++) {
			System.out.printf("Enter #%d Contributor data%n", i + 1);
			System.out.print("Contributor Type (n, c)?: ");
			char contributorType = sc.next().charAt(0);
			sc.nextLine(); // buffer clean

			System.out.print("Name: ");
			String contributorName = sc.nextLine();
			System.out.print("Annual income: ");
			Double annualIncome = sc.nextDouble();
			sc.nextLine(); // buffer clean

			Contributor contributor = null;
			switch (contributorType) {
			case 'n': {
				System.out.print("Health Expenses: ");
				Double healthExpenses = sc.nextDouble();

				contributor = new NaturalPerson(contributorName, annualIncome, healthExpenses);
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
		System.out.println("CONTRIBUTORS:");
		System.out.println();
		Double totalCollectedTaxes = 0.0;

		for (Contributor c : contributors) {
			c.printMyInfo();
			totalCollectedTaxes += c.totalTaxesToPay();
			System.out.println();
		}
		

		System.out.printf("Total Collected Taxes: %.2f", totalCollectedTaxes);		

		sc.close();
	}

}
