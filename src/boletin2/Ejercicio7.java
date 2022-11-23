package boletin2;

import java.util.Scanner;

public class Ejercicio7 {
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
	
		int numA, numB = 0;
		int contador = 0;
		
		
		do {
			System.out.println("Introduce dos numeros");
			numA = Integer.parseInt(teclado.nextLine());
			numB = Integer.parseInt(teclado.nextLine());
			contador++;
			if (numA < 0)
				numA = -numA;
		
		
		}while (numA >= 0);
		System.out.println("Has introducido " + (contador - 1) + " numero positivos");
		
	}
	}

