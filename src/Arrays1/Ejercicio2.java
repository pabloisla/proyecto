package Arrays1;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		 try (Scanner sc = new Scanner(System.in)) {
			int[] numeros = new int[10];
			    int pos = 0, neg = 0; //contadores
			    int i;
			   
			    //Leemos los valores por teclado y los guardamos en el array                                              
			    System.out.println("Lectura de los elementos del array: ");
			    for (i = 0; i < numeros.length; i++) {
			        System.out.print("numeros[" + i + "]= ");
			        numeros[i] = sc.nextInt();
			    }
  
			    //se recorre el array para contar positivos y negativos 
			    for (i = 0; i < numeros.length; i++) {
			        if (numeros[i] > 0) {
			            pos++;
			        } else if (numeros[i] < 0) {
			            neg++;
			        }
			    }
  
			    //mostrar resultados
			    System.out.println("Positivos: " + pos);
		 		System.out.println("Negativos: " + neg);
		 }
	}
}
