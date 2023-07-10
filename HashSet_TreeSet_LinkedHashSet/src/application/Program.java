package application;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*  https://docs.oracle.com/javase/10/docs/api/java/util/Set.html
 * 
 *  Set(T) represents a set of elements (similar to algebra)
 *  
 *  no repeat elements
 *  elements have no determinable position
 *  access, insertion and removal of elements are fast 
 *  offers efficient set operations: intersection, union, difference
 * 
 *  Main implementations and their differences:
 *  
 *   HashSet - faster, O(1) hash table operations; unordered
 *   TreeSet - slower, O(log(n)) operations on red-black tree; sorted by the object's compareTo (or comparator)
 *   LinkedHashSet - intermediate speed; elements in the order they are inserted
 * 
 * */

public class Program {
	public static void main(String[] args) {
		
		System.out.println("####################### HashSet #######################");
		System.out.println("Don't keep order\n");
			
		Set <String> mySet1 = new HashSet<>();
		String [] products = {"Color tv","Car radio","Notebook","Apple Ipad","Tablet"};
		
		addToSet(mySet1, products);
		
		System.out.printf("set.contains(\"Apple Ipad\"): %b%n", mySet1.contains("Apple Ipad"));
		System.out.printf("set.contains(\"iphone\"): %b%n", mySet1.contains("iphone") );
		System.out.println();
		
		System.out.println(mySet1);
		
		System.out.println("\n-------------------------------------------------------");
		
		System.out.println("####################### TreeSet #######################");
		System.out.println("Keeps order\n");
		
		Set <String> mySet2 = new TreeSet<>();
		
		
		addToSet(mySet2, products);
		
		System.out.println();
		
		System.out.println(mySet2);
		
		System.out.println("\n-------------------------------------------------------");
		
		
		System.out.println("####################### LinkedHashSet #######################");
		System.out.println("Keeps order\n");
		
		Set <String> mySet3 = new LinkedHashSet<>();

		addToSet(mySet3, products);
		
		mySet3.remove("Ipad");
		mySet3.removeIf(x -> x.length() <= 6);
		mySet3.removeIf(x -> x.charAt(0) == 'A');
		
		System.out.println();
		
		System.out.println(mySet3);
		
		System.out.println("\n-------------------------------------------------------");
		
		
		System.out.println("####################### Intersection, Union, Difference #######################");
		
		Set <Integer> mySetA = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
		Set <Integer> mySetB = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));

		System.out.println("mySetA: " + mySetA);
		System.out.println("mySetB: " + mySetB);
		
		
		Set <Integer> mySetC = new TreeSet <> (mySetA);
		//Union
		mySetC.addAll(mySetB);
		System.out.println("\nUNION mySetA and mySetB: " + mySetC);
		
		
		Set <Integer> mySetD = new TreeSet <> (mySetA);
		//Intersection
		mySetD.retainAll(mySetB);
		System.out.println("Intersection mySetA and mySetB: " + mySetD);

		Set <Integer> mySetE = new TreeSet <> (mySetA);
		//Difference
		mySetE.removeAll(mySetB);
		System.out.println("Difference mySetA and mySetB: " + mySetE);
		
		
		System.out.println("\n------------------------------------------------------------------------------");
		
	
	}
	
		
	private static void addToSet(Set <String> mySet, String [] myStrings) {
		if (mySet == null) {
			throw new InvalidParameterException("Set is null");
		}
		if (myStrings == null) {
			throw new InvalidParameterException("no Strings to add to Set");
		}
		
		int size = myStrings.length;
		
		for(int i = 0; i < size; i++) {
			mySet.add(myStrings[i]);
		}
		
	}
	
}
