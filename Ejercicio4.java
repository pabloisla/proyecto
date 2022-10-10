package boletin2;

import java.util.Scanner;

public class Ejercicio4 {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numero=0;
		int suma=0;
		
		do {
			System.out.println("Introduce un número positivo solamente");
			numero = Integer.parseInt(teclado.nextLine());
			
			if (numero <=0)
				System.out.println("No puedes introducir un nýmero negativo");
		}while (numero <= 0);
		for (int i = 0; i <= numero; i++) {
			suma = suma + i;
		}
		System.out.println("La suma total de los numeros es " + suma);
	}

}
