package pt.bitclinic.javaspring01.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.bitclinic.javaspring01.entities.Department;
import pt.bitclinic.javaspring01.entities.Product;

@RestController
public class ProductController {
	
	@GetMapping("/")
	public String home() {

		return "Home page";
	}

	@GetMapping("/products")
	public List <Product> getObjects() 
	{
		Department d1 = new Department(1L,"Tech");
		Department d2 = new Department(2L, "Pet");
		
		Product p1 = new Product(1L, "Mcbook pro", 2200.0, d1);
		Product p2 = new Product(2L, "Pc Gamer", 5000.0, d1);
		Product p3 = new Product(3L, "Pet House", 330.0, d2);
		
		List <Product> products = new ArrayList <> ();
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		

		return products;

	}

}
