package boletin2;

import java.util.Scanner;

public class Ejercicio9 {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int num;
		int acum = 0;
		do {
			System.out.println("Introduzca un número");
			num = Integer.parseInt(teclado.nextLine());
		}while (num <= 0);
		for (int i = 1 ; i <= num/2; i++) {
			if (num % i == 0) {
				acum=acum+i; //acum += i;
			}
		}
		if (num==acum) {
			System.out.println("El número es perfecto");
		} else {
			System.out.println("El número no es perfecto");
		}
		teclado.close();
	}
}
