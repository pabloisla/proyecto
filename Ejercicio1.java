package boletin1;

import java.util.Scanner;

public class Ejercicio1 {

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		float porcentaje;
		
		System.out.println("Introduce tu edad");
		int edad = Integer.parseInt(teclado.nextLine());
		 char estado;
		 do {
			 System.out.println("Introduce tu estado civil (C, S, V, D");
			 estado = teclado.nextLine().toUpperCase().charAt(0)
		while(estado != 'C' && estado != 'S' && estado != 'V' && estado != 'D')0
		
		if (edad > 50) {
		 porcentaje = 8.5f;
		}
		else if (edad < 35) {
			switch (estado) {
			case 'D':
			case 'S':
				porcentaje =12f;
				break;
			default:
			case 'V':
			case 'C':
				porcentaje = 11.3f;
				break;
			}
		}
			else {
				porcentaje = 10.5f;
			}
			
			 System.out.printtf("El porcentaje a aplicar es %f", porcentaje);

}
}