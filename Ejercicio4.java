package Problemas3;

import java.util.Scanner;

public class Ejercicio4 {
	
	public static Scanner sc = new Scanner(System.in);
	private static final int NUM_INICIAL = 1;
	private static final int NUM_FINAL= 100;
	private static final int NUM_INTENTOS= 5;
	
	public static void main(String[] args) {
		
		    int randomNum = (int) (Math.random() * NUM_FINAL + NUM_INICIAL); //Nos da un numero aleatorio.
	        int num = 0; //
	        int numIntentos = NUM_INTENTOS; //Asignamos una variable 


	        System.out.println("En este juego vamos a jugar a acertar un número aleatorio, tienes 5 intento para acertarlo recuerda que tienes 5 intentos solamente ");
	        System.out.println(randomNum);

			do {
	            numIntentos--;

	            do {
	                System.out.print(" Introduce el número correcto para ganar : ");
	                num = Integer.parseInt(sc.nextLine());
	            }while(num<0);

	            if (num == randomNum) {
	                System.out.println("Woooow, has acertado el número, has ganado. ");

	            } else if (num < randomNum) {
	                System.out.println(" Error, el número que has introducido es mas pequeño ");
	            } else {
	                System.out.println(" Error, el número que has introducido es mas grande ");
	            }

	        } while ( num != randomNum && numIntentos <= 0 );
	        
	        if (numIntentos == 0){
	            System.out.println("Lo sentimos, has perdido");
	        }
	       sc.close();
	    }

	}
