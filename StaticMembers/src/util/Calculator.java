package util;

public class Calculator {
	public static final double PI = 3.14159;//constant static attribute
	
	public static double circumference(double radius) { //static 
		return 2.0 * PI * radius;
	}
	
	public static double volume(double radius) {
		return 4.0 * PI * radius * radius * radius / 3.0;
	}

}
