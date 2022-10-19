package Problemas3;

import java.util.Scanner;

public class Ejercicio9 {
	
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		int resultado = 0;
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("Tabla del " + i);
		
			for(int j = 1; j <=10; j++){
				resultado = i * j;
				System.out.println("El resultado de multiplicar" + j + " x " + i + " = " + resultado);
			}
		}	
	}
}
