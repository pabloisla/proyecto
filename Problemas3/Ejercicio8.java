package Problemas3;

import java.util.Scanner;

public class Ejercicio8 {
	
	public static Scanner sc = new Scanner(System.in);
	
	private static Scanner teclado;
	
	public static void main(String[] args) {
		
		int a;
		int b;
		int c;
		int raizCuadrada;
		
		System.out.println("Dime un valor de a");
		a = Integer.parseInt(teclado.nextLine());
		System.out.println("Dime un valor de b");
		b = Integer.parseInt(teclado.nextLine());
		System.out.println("Dime un valor de c");
		c = Integer.parseInt(teclado.nextLine());
		
		raizCuadrada= (b*b) - 4*a*c;
		
		if(raizCuadrada>0){
			System.out.println("Solo tiene dos soluciones");
		}
		else if (raizCuadrada == 0){
			System.out.println("Solo tiene una solición");
		}
		else {
		System.out.println("Esta ecuacion no es de segundo grado.");
		}
		teclado.close();
		}
	}

