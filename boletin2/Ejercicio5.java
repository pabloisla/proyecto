package boletin2;

import java.util.Scanner;

public class Ejercicio5 {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		int num;
		int i;
		int suma=0;
		
		do {
			System.out.println("Introduce un numero positivo");
			num = Integer.parseInt(teclado.nextLine());
			if (num<=0)
				System.out.println("No puedes introducir un numero negativo");
			
		}while (num<=0);
		for (i=0; i<= num; i++) {
			suma = suma + i;
		}
		System.out.printf("El resultado es %d, suma");
	}

}
