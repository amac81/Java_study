package application;

import java.util.Set;
import java.util.TreeSet;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		Set<Product> set = new TreeSet<>();

		set.add(new Product("Tv", 300.0));
		set.add(new Product("Ipad", 1300.0));
		set.add(new Product("Smartphone", 850.0));
		set.add(new Product("BluRay player", 610.0));

		/*
		 * When using TreeSet, it is necessary that the elements (Objects) implement the
		 * Comparable interface
		 * 
		 * In this example the Product class has to implement the Comparable interface
		 * 
		 * when printing the Set of Products, it will be sorted according to the
		 * implementation of the compareTo method of the Product class. In this example
		 * the products will be shown in alphabetical order by name
		 * 
		 */

		for (Product product : set) {
			System.out.println(product);
		}

	}
}
