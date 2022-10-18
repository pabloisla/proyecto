package Problemas3;

import java.util.Scanner;

public class Ejercicio5 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num;
		
		System.out.println("Introduce un numero");
		num = Integer.parseInt(teclado.nextLine());
		
		teclado.close();
		
		boolean var = false;//no se para hasta que no se haya encontrado un divisor
		
		for (int i = 2; i <= num/2 && var == false ; i++) {//se le añade para cuando busque el primo pare cuando se encuentre
			if (num % i == 0) {
				var = true;
		}	
	}
	if (var == true) {
		System.out.println("El número No es primo");
	}else {
		System.out.println("Eñ número es primo");
		}
	}
}
