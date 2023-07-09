package application;

import java.util.ArrayList;
import java.util.List;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class Program {
	public static void main(String[] args) {
		
		Rectangle rectangle1 = new Rectangle(12.0, 10.0);
		Rectangle rectangle2 = new Rectangle(2.0, 3.0);
	
		
		Circle circle1 = new Circle(3.0);
		Circle circle2 = new Circle(1.2);
		
		
		List <Shape> shapes = new ArrayList <> ();
		
		shapes.add(rectangle1);
		shapes.add(rectangle2);
		shapes.add(circle1);
		shapes.add(circle2);
		
		List <Circle> circles = new ArrayList <> ();
		
		circles.add(circle1);
		circles.add(circle2);
		
		System.out.println("Total area = " + String.format("%.3f", totalArea(shapes)));
		
		System.out.println("Circles total area = " + String.format("%.3f", totalArea(circles)));
		
		
	}
	
	//method that returns the sum of the area of a list of shapes
	public static Double totalArea (List <? extends Shape> list) {
		/* Note: it is not possible to insert elements in the list
		* when using wildcard delimited list
		* list.add(new Circle(2.0)); 
		* list.add(new Rectangle(2.0, 3.0)); 
		*/
		
		Double sum = 0.0;
		
		for(Shape  s: list) {
			sum += s.area();
		}
		
		return sum;
	}


}
