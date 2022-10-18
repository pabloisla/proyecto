package boletin1;

import java.util.Scanner;

public class Ejercicio9 {
		
	private static Scanner teclado = new Scanner(System.in);	
	public static void main(String[] args) {
		
		double result = 0;
		System.out.println("Introduce el precio del producto");
		int precio = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce el tipo de producto");
		char tipo=teclado.nextLine().charAt(0);
		
		if (tipo == 'A'|| tipo == 'B' || tipo == 'C' ) {
			if(tipo == 'A') {
				result = precio - (precio * 0.12);
				System.out.println("Se le aplica un 7% de descuento");
				System.out.printf("El rpoducto final es de %f ", result);
			}
			else if(tipo == 'C' || precio < 500) {
				result = precio - (precio * 0.07);
				System.out.println("Se le aplica un 12% de descuento");
				System.out.printf("El rpoducto final es de %f", result);
			}
			else {
				result = precio - (precio * 0.09);
				System.out.println("Se le aplica un 9% de descuento");
				System.out.printf("El rpoducto final es de %f", result);
			}
		}
		else {
			System.out.println("Error");
		}
	}

}
