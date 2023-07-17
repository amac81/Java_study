package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US); 
		
		Scanner sc = new Scanner(System.in);

		String filePath;

		System.out.print("Enter full file path: ");
		filePath = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			List<Employee> employees = new ArrayList<>();

			String fileLine = br.readLine();
			String[] fields;

			while (fileLine != null) {
				fields = fileLine.split(",");
				employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				fileLine = br.readLine();
			}

			System.out.print("Enter salary: ");
			Double salary = sc.nextDouble();
			
			//file was read to employees list
			
			
			//pipeline: emails of employees whose salary is more than...			
			List<String> employeesEmails = employees.stream()
					.filter(e -> e.getsalary() > salary)
					 //new stream with emails
					.map(e -> e.getEmail())
					.sorted()
					//convert Stream to List
					.collect(Collectors.toList()); 
			
			//pipeline: sum of salary of people whose name starts with 'M'			
			Double sum = employees.stream()
					.filter(e -> e.getName().charAt(0) == 'M')
					.map(e -> e.getsalary())
					.reduce(0.0, (x,y) -> x + y);
			
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
			employeesEmails.forEach(System.out::println); 
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));


		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
