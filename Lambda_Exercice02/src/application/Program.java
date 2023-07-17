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

import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US); 
		
		Scanner sc = new Scanner(System.in);

		String filePath;

		System.out.print("Enter file path: ");
		filePath = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			List<Product> products = new ArrayList<>();

			String fileLine = br.readLine();
			String[] fields;

			while (fileLine != null) {
				fields = fileLine.split(",");
				products.add(new Product(fields[0], Double.parseDouble(fields[1])));
				fileLine = br.readLine();
			}

			
			//file was read to products list
			
			//pipeline
			double avg = products.stream()
					.map(p -> p.getPrice())
					.reduce(0.0, (x, y) -> x + y) / products.size();
			
			System.out.println("Average price: " + String.format("%.2f", avg));
			
			Comparator<String>  =  (s1, s2) -> s2.toUpperCase().compareTo(s1.toUpperCase());
			
			//products with price lower than avg
			List<String> productNames = products.stream()
					.filter(p -> p.getPrice() < avg)
					 //new stream with names
					.map(p -> p.getName())
					//descending order (Z to A)
					.sorted(myStrComp)
					.collect(Collectors.toList());
			
			for(String s: productNames) {
				System.out.println(s);
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
