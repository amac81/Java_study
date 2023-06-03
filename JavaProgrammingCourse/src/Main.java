import java.util.Locale;
import java.util.Scanner;

public class Main {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Locale.setDefault(Locale.ROOT);
		//Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		//variables
		String nome;
		int idade = 0;
		Double altura = 0.0;
		Double peso = 0.0;
		char sexo;
		
		//ask for data input from keyboard
		System.out.println("Qual o nome ?");
		nome = sc.next(); 
		
		System.out.println("Qual o seu sexo ?");
		sexo = sc.next().charAt(0); 
		
		System.out.println("Qual a idade ?");
		idade = sc.nextInt(); 
		
		System.out.println("Qual a sua altura ?");
		altura = sc.nextDouble(); 
		
		System.out.println("Qual o seu peso ?");
		peso = sc.nextDouble(); 
		
		//data print at screen
		System.out.println("\nOs dados introduzidos foram:");
		System.out.println("Nome: " + nome);
		System.out.println("Idade: " + idade);
		System.out.printf("Altura: %.2f%n", altura);
		System.out.printf("Peso: %.2f%n", peso);
		System.out.println("Sexo: " + sexo);
		
	}
	
	

}
