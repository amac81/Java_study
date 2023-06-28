/*
 * Desafio de exercicio Comunidade Dev completo - Discord
 * 
 * 28/06/23
 * Willder 
 * 
 * código não otimizado!!! é uma primeira versão
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("# CLIENTE #\n");
		System.out.print("Digite a quantidade de frutas a comprar:");
		int numeroFrutasPedidas = sc.nextInt();

		List<String> listaComprasPedido = new ArrayList<>();
		List<String> listaDeComprasFeitas = new ArrayList<>();

		// "consumir" a nova linha restante usando o método nextLine()
		// https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/
		sc.nextLine();

		for (int i = 0; i < numeroFrutasPedidas; i++) 
		{
			System.out.printf("Digite a fruta a comprar #%d: ", i + 1);
			String fruta = sc.nextLine();
			listaComprasPedido.add(fruta);
		}

		System.out.print("A sua lista de compras (pedido): ");
		mostraListaCompras(listaComprasPedido);
		
		System.out.println("\n\n# COMPRADOR #\n");
		System.out.print("Digite a quantidade de frutas que conseguiu comprar:");
		int numeroFrutasCompradas = sc.nextInt();
				
		sc.nextLine();
		
		for (int i = 0; i < numeroFrutasCompradas; i++) 
		{
			System.out.printf("Digite a fruta comprada #%d: ", i + 1);
			String fruta = sc.nextLine();
			listaDeComprasFeitas.add(fruta);
		}
		
		System.out.print("A lista de compras feitas com sucesso: ");
		mostraListaCompras(listaDeComprasFeitas);
		
		System.out.println("\n\n");
		
		double percentagemComprada = percentagemComprasFeitas(listaComprasPedido, listaDeComprasFeitas);
		double gorjeta = calcularGorjeta(percentagemComprada);
		
		System.out.print("Resposta: correspondência de " + percentagemComprada + "%, gorjeta de R$ " + gorjeta);
			
		sc.close();
	}
	
	public static void mostraListaCompras(List<String> listaCompras) {
		
		int tamanhoLista = listaCompras.size();

		System.out.print("[");

		for (int i = 0; i < tamanhoLista ; i++) 
		{
			System.out.print(listaCompras.get(i));
			if (i < tamanhoLista - 1)
				System.out.print(", ");
		}

		System.out.print("]");
	}
	
	public static int comparaListas(List<String> lista1, List<String> lista2) {

		int itemsIguais = 0;
		
		for (String item : lista1) 
		{
			if (lista2.contains(item)) 
			{
				itemsIguais++;
			}
		}
		
		return itemsIguais;
	}
	
	
	public static double percentagemComprasFeitas(List<String> listaComprasCliente, List<String> listaComprasFeitas)
	{
		int itemsIguais = comparaListas(listaComprasCliente, listaComprasFeitas);
		//necessário cast da variável contafrutas para double, para o cálculo correto da percentagem
		double percentagemFrutasIguais = (double) itemsIguais / listaComprasCliente.size() * 100;

		return percentagemFrutasIguais;
	}
	
	public static double calcularGorjeta (double percentagemFrutasIguais) {
		double gorjeta = 0.0;
		
		/* Gorjeta
		 * ...........:  0.0
		 * 50% .. 74% :  3.0
		 * 75% .. 89% :  5.0 
		 * 90% .. 100%: 10.0 
		 */
		
		if (percentagemFrutasIguais >= 50 && percentagemFrutasIguais <= 74) {
			gorjeta = 3.0;
		}
		else if(percentagemFrutasIguais >= 75 && percentagemFrutasIguais <= 89) {
			gorjeta = 5.0;
		} 
		else if (percentagemFrutasIguais >= 90 && percentagemFrutasIguais <= 100) {
			gorjeta = 10.0;
		}
		else {
			gorjeta = 0.0;
		}
		
		return gorjeta;
	}

}
