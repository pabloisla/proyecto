package boletin4;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		 int N, aux, inverso = 0, cifra;
		 
	        try (Scanner sc = new Scanner(System.in)) {
				do {
				    System.out.print("Introduce un número igual o mayor 10: ");                                                 
				    N = sc.nextInt();
				    
			} while (N < 10);
	        
	        //le damos la vuelta al número
	        aux = N;
	        while (aux != 0){
	            cifra = aux % 10;
	            inverso = inverso * 10 + cifra;
	            aux = aux / 10;
	        }
	    
	        if(N == inverso){
	            System.out.println("Es capicua");
	        }else{
	            System.out.println("No es capicua");
	        }
	    }
	}
}
