package boletin1;

import java.util.Scanner;

public class Ejercicio10 {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
	char operador;
	int num1 = 0;
	int num2 = 0;
	
	do {
	System.out.println("Introduce operador(+,-,/,*) ");
	operador = teclado.nextLine().charAt(0);
	
	if (operador == '-' || operador == '+' || operador == '/' || operador == '*') {
		System.out.println("Introduce el primer número:");
		num1 = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce el segundo número:");
		num2 = Integer.parseInt(teclado.nextLine());
	} else {
		System.out.println("El caracter es incorrecto");
		}
	} while (operador != '-' && operador != '+' && operador != '/' && operador != '*');
	teclado.close();
	
	int resultado;
	switch (operador) {
	case '+': {
		resultado = num1 + num2;
		System.out.printf("El resultado de sumar d% y d% es:", num1,num2,resultado);
		break;
	}
	case '*': {
		resultado = num1 * num2;
		System.out.printf("El resultado de multiplicar d% y d% es:", num1,num2,resultado);
		break;		
	}
	case '-': {
		resultado = num1 - num2;
		System.out.printf("El resultado de restar d% y d% es:", num1,num2,resultado);
		break;
	}
	case '/': {
		resultado = num1 / num2;
		System.out.printf("El resultado de dividir d% y d% es:", num1,num2,resultado);
		break;
	}
	default:
		System.out.println("Error");
		}
	}
}
