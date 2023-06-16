import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Mary");
		list.add("Bob");
		list.add("Joe");
		list.add("Alex");
		list.add("John");
		list.add("Bianca");

		list.add(3, "Arnaldo"); // insert the string in position 3 of the list
		System.out.println("List size = " + list.size());

		for (String str : list) {
			System.out.println(str);
		}

		list.remove(1); // remove list element in position 1 of the list

		/*
		 * remove element (s) in the list starting with 'J' here we use a lambda
		 * operations as predicate (x -> x.charAt(0) == 'J'); retorna V ou F
		 */
		list.removeIf(x -> x.charAt(0) == 'J');

		System.out.println("---------------------------------------");

		for (String str : list) {
			System.out.println(str);
		}

		System.out.println("---------------------------------------");

		System.out.println("Index of Mary: " + list.indexOf("Mary"));
		System.out.println("Index of Bob: " + list.indexOf("Bob")); // Bob doesn't exists, so it will return -1

		/*
		 * how to keep in the list only the elements whose name starts with 'A' !!? I
		 * want to filter the list so that only the elements starting with 'A' are kept
		 * 
		 * We have to: 
		 * - create a new list; 
		 * - convert the original list to stream; 
		 * - filter with lambda operations; 
		 * - convert to list again;
		 *
		 * from Java version 8: solution adopted to maintain compatibility between List
		 * (old type) and allow the use of Lambda operations
		 */

		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

		System.out.println("---------------------------------------");

		for (String str : result) {
			System.out.println(str);
		}

		System.out.println("---------------------------------------");

		// find a element starting with 'A' and after starting with 'J'
		// returns null if not found

		String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
		System.out.println(name);

		name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
		System.out.println(name);

	}
}
