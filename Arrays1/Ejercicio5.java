package Arrays1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio5 {

		public static Scanner sc = new 	Scanner(System.in);
	
		public static final int NUM_FINAL = 1000;
		
		public static int tamaño(int tamaño) {
			System.out.println("Introduce un numero :");
			tamaño =Integer.parseInt(sc.nextLine());
			sc.close();
			return tamaño;
		}
		public static void main(String[] args) {
			Random aleatorio; 
			aleatorio = new Random();
			
			int[] aleator = new int[tamaño(0)];
			
			for (int i = 0; i < aleator.length; i++) {
				
				aleator[i] = aleatorio.nextInt(NUM_FINAL);
		}
			System.out.printf("Los números aleatorios son :%s :" , Arrays.toString(aleator));
	}
}		
