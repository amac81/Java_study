package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;


public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("\nEnter Worker Data");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		System.out.println();
		System.out.print("How many contracts to this worker? ");
		System.out.println();
		
		Department department = new Department(departmentName);
		Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, department);
		
		int numberOfContracts = sc.nextInt();
		sc.nextLine(); //buffer clean
		
		//data formatter (dd/MM/yyyy)
		DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for(int i = 0; i < numberOfContracts; i++) {
			System.out.printf("Contract #%d Data%n", i + 1);
			
			System.out.print("Date (dd/MM/yyyy): ");
			String dateString = sc.nextLine();
			LocalDate contractDate = LocalDate.parse(dateString, dateFormat1);
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			
			worker.addContract(contract);
			sc.nextLine(); //buffer clean
			System.out.println();
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/yyyy): ");
		String monthYearStr = sc.nextLine();
		
		int month = Integer.parseInt(monthYearStr.substring(0, 2));
		int year = Integer.parseInt(monthYearStr.substring(3));
		
		System.out.println();
		System.out.printf("Worker Name: %s%n", worker.getName());
		System.out.printf("Department: %s%n", worker.getDepartment());
		System.out.printf("Income for (%d/%d) = %.2f%n", month, year, worker.income(year, month));
		
		sc.close();		
	}

}
