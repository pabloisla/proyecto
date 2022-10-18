package boletin2;

import java.util.Scanner;

public class Ejercicio8 {
	
	private static Scanner teclado = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		int num = 0;
		int numMen = 0;
		char respuesta;
		numMen = num;
		
		System.out.println("Introduce un número");
		num = Integer.parseInt(teclado.nextLine());
		
		do {
			do {
			System.out.println("¿Desea introducir más números? (S/N)");
			respuesta =  teclado.nextLine().charAt(0);
			
		} while (!(respuesta == 'S' || respuesta == 's' || respuesta == 'N' || respuesta == 'n')); {
		
		if (respuesta == 'S' || respuesta == 's') {
			System.out.println("Introduce un número");
			num = Integer.parseInt(teclado.nextLine());
			
			if (num < numMen) {
				numMen = num;
					}
			}
		}while (respuesta == 'N' || respuesta == 'n');{	
			}
		}
	}
}
			
