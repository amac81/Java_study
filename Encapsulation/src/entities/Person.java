package entities; //Class package

/*
 * https://www.w3schools.com/java/java_encapsulation.asp
 * Java Encapsulation
 * The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. 
 * To achieve this, you must:
 * -> declare class variables/attributes as private
 * -> provide public get and set methods to access and update the value of a private variable
 * 
 * 
 * There are three types of encapsulation: 
 * -> Member variable encapsulation; 
 * -> Function encapsulation;
 * -> Class encapsulation, 
 * 
 * each of which has its own significance with respect to member variables of a class, functions, APIs when it comes to the implementation of any specific application possessing encapsulation.
*/

public class Person {
	private String name;
	private Double height;
	private Double weight;
	private int age;

	public Person() {
	}

	public Person(String name, Double height, Double weight, int age) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}

	public int getAge() {
		return age;
	}

	public int birthday() {
		return age ++;
	}

	public double increaseWeight(double weightDif) {
		return weight += weightDif;
	}
	
	public double decreaseWeight(double weightDif) {
		return weight -= weightDif;
	}
	
	
	public String toString() {
		return "[name=" + name + ", height=" + height + ", weight=" + weight + ", age=" + age + "]";
	}

}
