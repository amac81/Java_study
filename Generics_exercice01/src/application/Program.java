package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.services.CalculationService;
import entities.Product;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String filePath = "/tmp/in.txt";

		List<Product> products = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String fileLine = br.readLine();
		
			while (fileLine != null) {
				String[] fields = fileLine.split(",");
				products.add(new Product(fields[0], Double.parseDouble(fields[1])));
				fileLine = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("Most expensive:\n");
		System.out.print(CalculationService.max(products));
		
		sc.close();
	}

}
