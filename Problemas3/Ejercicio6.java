package Problemas3;

import java.util.Scanner;

public class Ejercicio6 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int numAlum;
		int notas;
		int acuma=0;
		int acums=0;
		System.out.println("Introduce el número de alumnos");
		numAlum = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <=numAlum; i++) {
			System.out.println("Introduce la nota que tienen" + i + "alumno");
			notas = Integer.parseInt(sc.nextLine());
			
			if (notas >= 5) {
				acuma++;
			}else {
				acums++;
			}
		}
			float pora = Math.round(acuma * 100f / numAlum);
			float pors = Math.round(acums * 100f / numAlum);
			
			System.out.println("Hay " + acuma + "aprovados");
			System.out.println("Porcentaje de aprovados es del " + pora + "%");
			System.out.println("Porcentaje de suspensos es del " + pors + "%");
			System.out.println("Hay " + acums + "suspensos");
			
		}
	}
