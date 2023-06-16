import java.util.ArrayList;
import java.util.List;

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
		
		list.remove(1); //remove list element in position 1 of the list
		
		/*remove element (s) in the list starting with 'J'
		 * here we use a lambda expression as predicate (x -> x.charAt(0) == 'J'); retorna V ou F
		*/
		list.removeIf(x -> x.charAt(0) == 'J'); 

		System.out.println("---------------------------------------");
		
		for (String str : list) {
			System.out.println(str);
		}

	}
}
