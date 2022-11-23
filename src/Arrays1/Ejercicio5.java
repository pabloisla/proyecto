package Arrays1;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio5 {
	public static final int NUM_INICIAL = 0;
	public static final int NUM_FINAL = 10;
	public static final int NUM_ENCON = 2;
	public static void main(String[] args) {
		
	//Variables
	Random aleatorio;
	aleatorio = new Random();
	
	int[] numeros;
	numeros = new int [10];
	
	//Codigo
	for (int i = 0; i < numeros.length; i++) {
	numeros[i] =aleatorio.nextInt(NUM_FINAL);
	}
	
	// %d numeros enteros
	// %f numeros con decimales
	// %s para cadenas de texto
	
	System.out.printf("Los numeros aleatorios son : %s", Arrays.toString(numeros));
	
		boolean encontrado = false;
		
		for (int i = 0; i < numeros.length && encontrado == false; i++) {
			if (numeros[i]== NUM_ENCON) {
				encontrado = true;
			}
		}
		if(encontrado == true)
		System.out.printf("El elemento %d: ha sido encontrado en el array : ", NUM_ENCON);
		
		else {
			
		System.out.printf("El elemento %d: ha sido encontrado en el array : ", NUM_ENCON);
		}
	}
}