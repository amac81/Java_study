package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner (System.in);
		
		//Variables
		Double xArea = 0.0;
		Double yArea = 0.0;
		
		Triangle x, y;
		x = new Triangle();
		y = new Triangle();
		
		System.out.println("Enter the measures of Triangle X:");
		x.a = sc.nextDouble();
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		
		System.out.println("Enter the measures of Triangle Y:");
		y.a = sc.nextDouble();
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		xArea = x.area();
		System.out.printf("Area of Triangle X = %.4f%n", xArea);
		yArea = y.area();
		System.out.printf("Area of Triangle Y = %.4f%n", yArea);

		System.out.print("\nTriangle with the largest area: ");

		if(xArea > yArea) {
			System.out.println("X");	
		} 
		else
		{
			System.out.println("Y");
		}

		
		sc.close();		
	}

}
