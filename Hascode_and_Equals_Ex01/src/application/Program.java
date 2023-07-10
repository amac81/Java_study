package application;

import java.util.Locale;

import entities.Client;


public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
	
		Client c1 = new Client("Jonh", "jonh01@gmail.com");
		Client c2 = new Client("Anna", "anna@gmail.com");
		Client c3 = new Client("Jonh", "jonh01@gmail.com");
		
		String s1 = "Hello";
		String s2 = "Hello";
		
		String s3 = new String("Hello");
		String s4 = new String("Hello boy");
		
		
		System.out.printf("c1.hashCode(): %d%n",  c1.hashCode());
		System.out.printf("c2.hashCode(): %d%n",  c2.hashCode());
		System.out.printf("c3.hashCode(): %d%n",  c3.hashCode());
		System.out.println();		
		System.out.printf("c1 == c2: %b%n",  c1 == c2);
		
		//excluding the String type, which has special handling, the == compares memory references
		//c1 and c2 have the same content but have different memory locations
		System.out.printf("c1 == c3: %b%n",  c1 == c3);
		
		System.out.println();
		System.out.printf("c1.equals(c2): %b%n",  c1.equals(c2));
		System.out.printf("c1.equals(c3): %b%n",  c1.equals(c3));
		System.out.println();		
		
		//special treatment for literals
		System.out.printf("s1 == s2: %b%n",  s1 == s2);
		
		System.out.printf("s3 == s4: %b%n",  s3 == s4);
		System.out.println();
		System.out.printf("s1.equals(s2): %b%n",  s1.equals(s2));
		System.out.printf("s1.equals(s4): %b%n",  s1.equals(s4));
		
	
	}
}
