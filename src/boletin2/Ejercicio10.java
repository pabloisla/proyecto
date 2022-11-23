package boletin2;

import java.util.Scanner;

public class Ejercicio10 {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int num;
		int fact = 1;
		
		do {
			System.out.println("Introduzca un número mayor o igual que 0:");
			num = Integer.parseInt(teclado.nextLine());
		}while (num < 0);
		for (int i = 2; i <= num; i++) {
			fact = fact * i;
		}
		System.out.println("El factorial de este número es" + fact);
	}
}