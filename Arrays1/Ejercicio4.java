package Arrays1;

public class Ejercicio4 {
	public static final int NUM_INICIAL = 0;
	public static final int NUM_FINAL = 100;
	public static final int CANT_NUM = 6000;
	public static void main(String[] args) {
		
		//Variables
		int[] numeros;
		numeros = new int [CANT_NUM];
		int suma = 0;
		int[] terminaciones;
		terminaciones = new int [10]; 
		
		
		//Codigo
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] =(int)(Math.random()*(NUM_FINAL - NUM_INICIAL + 1) + NUM_INICIAL);
		}
		for (int j = 0; j < numeros.length; j++) {
			int numero = numeros[j];
			suma = suma + numero;
			terminaciones[numero%10]++;
		}
		double media = (double)suma / numeros.length;
		System.out.println("La media de los numeros es " + media);
		for (int k = 0; k < terminaciones.length; k++) {
			System.out.printf("Numeros que terminan en %d : %d. Esto equivale a un: %.2f \n", k, terminaciones[k], ((double) terminaciones[k]/numeros.length) * 100);
		}
		
	}

}
