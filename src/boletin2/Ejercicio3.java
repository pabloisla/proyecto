package boletin2;

import java.util.Scanner;

public class Ejercicio3 {
	
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		int contador = 0;
		int numeroIntroducido = 0;
		
		
		do {
			
			System.out.println("¿Cuantos números vas a introducir");
			contador = Integer.parseInt(teclado.nextLine());
			
			if (contador <= 0) {
				System.out.println("No puedes introducir 0 o valores negativos");
			}
			
		} while (contador <= 0);
		
		for (int i = 0; i < contador; i++) {
			
			System.out.println("Introduzca su " + i + " numero: ");
			numeroIntroducido = Integer.parseInt(teclado.nextLine());
			
			if (numeroIntroducido % 2 == 0) {
				System.out.println("El número es par");
			}else {
				System.out.println("El número es impar");
			}
		}
		
	}

}
