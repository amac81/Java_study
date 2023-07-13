package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Program {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		int nOfStudents = 0;
		
		
		// choose HashSet because it is fast and in this problem we don't need order
		Set<Integer> setCourseAStudents = new HashSet<>();
		Set<Integer> setCourseBStudents = new HashSet<>();
		Set<Integer> setCourseCStudents = new HashSet<>();
		
		System.out.print("How many students for Course A: ");
		nOfStudents = sc.nextInt();
		
		
		for(int i = 0; i< nOfStudents; i++) {
			setCourseAStudents.add(sc.nextInt());
		}
		
	
		System.out.print("How many students for Course B: ");
		nOfStudents = sc.nextInt();
		
		
		for(int i = 0; i< nOfStudents; i++) {
			setCourseBStudents.add(sc.nextInt());
		}
	
		System.out.print("How many students for Course C: ");
		nOfStudents = sc.nextInt();
		
		
		for(int i = 0; i< nOfStudents; i++) {
			setCourseCStudents.add(sc.nextInt());
		}
	
		
		Set <Integer> setAllStudents = new HashSet <> (setCourseAStudents);
		

		//Union
		setAllStudents.addAll(setCourseBStudents);
		setAllStudents.addAll(setCourseCStudents);
		
		
		sc.close();

		
		System.out.print("Total unique students: " + setAllStudents.size());
	}
}
