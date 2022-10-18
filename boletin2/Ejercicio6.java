package boletin2;

import java.util.Scanner;

public class Ejercicio6 {
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int num = 0;
		int contador = 0;
		
		
		do {
			System.out.println("Introduce un numero (negativo para terminar)");
			num = Integer.parseInt(teclado.nextLine());
			contador++;
			
		}while (num >= 0);
		System.out.println("Has introducido " + (contador - 1) + " numero positivos");
	}

}