package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		
		List <Product> products = new ArrayList<> ();
		
		products.add(new Product("TV", 143.10));
		products.add(new Product("Notebook", 4125.82));
		products.add(new Product("Ipad", 1724.02));
		products.add(new Product("Tablet", 890.32));
		
		//with lambda expression (anonimous function)
		Comparator<Product> comp = (p1, p2) -> {
			return p1.getPrice().compareTo(p2.getPrice());
		};
		
		products.sort(comp);
		
		
		for(Product p: products) {
			System.out.println(p);
		}



		
	}

}
