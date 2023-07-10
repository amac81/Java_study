package application;

import java.util.HashSet;
import java.util.Set;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		Set<Product> set = new HashSet<>();

		set.add(new Product("Tv", 300.0));
		set.add(new Product("Ipad", 1300.0));
		set.add(new Product("Smartphone", 850.0));
		set.add(new Product("BluRay player", 610.0));

		Product p = new Product("Smartphone", 850.0);

		/* if the object does not have the hashCode and equals methods implemented, Set
		/* uses the pointer reference to compare the two objects.
		 * 
		 * Before we have implemented the hashCode and equals methods in the Product class 
		 * the result of "set.contains(p)" would be false
		 */
	
		System.out.println(set.contains(p));

	}
}
