package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		
		List <Integer> myInts = Arrays.asList(1, 3, 5, 4);
		List <Double> myDoubles = Arrays.asList(3.14, 1.30, 1.5, 2.4);
		List <Object> myObjs = new ArrayList <Object>();
		
		copy(myInts, myObjs);
		print(myObjs);	
		copy(myDoubles, myObjs);
		
		print(myObjs);	
		
	}
	
	/* Wildcard delimited list
	 * 
	 * COVARIANCE get/put principle:
	 * 
	 * It is POSSIBLE to ADD elements
	 * It is NOT POSSIBLE to GET elements from the list
	 * 
	 * */
	public static void copy(List <? extends Number> source, List <? super Number> destiny) 
	{
		for(Number number: source) {
			destiny.add(number);
		}
	}
	
	/* Wildcard delimited list
	 * 
	 * CONTRAVARIANCE get/put principle :
	 * 
	 * It is NOT POSSIBLE to ADD elements
	 * It is POSSIBLE to GET elements from the list
	 * 
	 * */
	public static void print(List <?> list) 
	{
		for(Object obj: list) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}
	


}
