package application;

import java.util.Comparator;

import entities.Product;



public class MyComparator implements Comparator<Product>{

	@Override
	public int compare(Product p1, Product p2) {
		//order by name
		//return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		
		//order by price
		return p1.getPrice().compareTo(p2.getPrice());
	}

}
