package entities; //Class package

public class Triangle/* class name */ {
	// class attributes
	public double a;
	public double b;
	public double c;

	// public prefix indicates that the class attributes / methods can be used in
	// other files

	public double area() {
		double p = (a + b + c) / 2.0;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
}
