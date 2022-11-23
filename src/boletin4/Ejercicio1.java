package boletin4;

import java.util.Scanner;

public class Ejercicio1 {
	
	public static void main(String[] args) {

		int numero, invertido = 0, resto;
		
			try (Scanner s = new Scanner( System.in )) {
				
				System.out.println( "Introduce un número: " );
				
				numero = s.nextInt();
			}
			
			while(numero != 0) {
	    	resto = numero % 10;
	    	invertido = invertido * 10 + resto;
	    	numero = numero / 10;
	    }
		
	    System.out.println( "Número invertido: " + invertido );
	    
	}
}
