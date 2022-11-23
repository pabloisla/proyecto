package Problemas3;

import java.util.Scanner;

public class Ejercicio1 {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int num = 0;
		int num1;
		int num2;
		int num3;
		int primero;
		int segundo;
		int tercero;

		System.out.println("Introduce el primer numero");
		num1 = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce el segundo numero");
		num2 = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce el tercer numero");
		num3 = Integer.parseInt(teclado.nextLine());

		if (num1 > num2 && num1 > num3) {
			primero = num1;
			if (num2 > num3) {
				segundo = num2;
				tercero = num3;
			} else {
				segundo = num3;
				tercero = num2;
			}

		} else if (num2 > num1 && num2 > num3) {
			primero = num2;
			if (num1 > num3) {
				segundo = num1;
			} else {
				segundo = num3;
			}
		} else {
			primero = num3;
		}

	}
}
