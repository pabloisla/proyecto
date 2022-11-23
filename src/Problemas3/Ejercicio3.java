package Problemas3;

import java.util.Scanner;

public class Ejercicio3 {
	public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int num;
        int i = 0;
        int numGuardado = 0;

        System.out.println("Introduce un número para saber cuantas cifras tienes : ");
        num = Integer.parseInt(sc.nextLine());
        numGuardado = num;
        while(num != 0){
                num = num/10;
                i++;
        }
        System.out.println("El número introducido " + numGuardado + " tiene : " + i + " cifras ");
	
    }
}
