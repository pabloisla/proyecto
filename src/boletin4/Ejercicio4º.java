package boletin4;

import java.util.Scanner;

public class Ejercicio4º {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int hora;
		int hora2;
		int min;
		int min2;
		int seg;
		int seg2;
		int segFin;
		int minFin;
		int horaFin;
		
		System.out.println("Introduce la hora base:");
		hora = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce los minutos base:");
		min = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce los segundos base:");
		seg = Integer.parseInt(teclado.nextLine());
		System.out.println("¿Cuantas horas quieres sumar?");
		hora2 = Integer.parseInt(teclado.nextLine());
		System.out.println("¿Cuantas minutos quieres sumar?");
		min2 = Integer.parseInt(teclado.nextLine());
		System.out.println("¿Cuantos segundos quieres sumar?");
		seg2 = Integer.parseInt(teclado.nextLine());
		
		
		
		segFin = seg + seg2;
		
		if (segFin > 59) {
			min2 = min2 + segFin / 60;
			segFin = segFin % 60;
		}
		minFin = min + min2;
		
		if (minFin > 59) {
			hora2 = hora2 + minFin / 60;
			minFin = minFin % 60;
			
		}
		horaFin = hora + hora2;
		
		if (horaFin >= 24) {
			horaFin = horaFin % 24;
			hora2 = hora2 / 24;
		}
		
		System.out.printf("La suma es %d:%d:d% " , horaFin, minFin, segFin);
		
			if (hora2>0) {
				System.out.printf("(+%d dias" , hora2);
		}
	}
}
