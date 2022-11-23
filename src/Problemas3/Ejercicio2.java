package Problemas3;

import java.util.Scanner;

public class Ejercicio2 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		 int base = 0;
         int exp = 0;
         int potencia = 1; // Inizializamos a 1, ya que si lo hicieramos con "0" siempre daria como resultado 0, por lo que seria un error.

         do {
             System.out.println("Introduce un número como base : "); // imprimimos por pantalla l que queremos y pedimos que nos ingresen los numeros
             base = Integer.parseInt(sc.nextLine());

             System.out.println("Introduce un número como exponente : ");
             exp = Integer.parseInt(sc.nextLine());
         }while(base < 0 || exp < 0);

         for(int i = 1; i <= exp; i++){ //Ponemos que i recorra hasta el exp (Exponente) que hemos introducido,
             potencia=potencia*base; //el bucle hara que cada vuelta que de se multiplique por el mismo hasta llegar al limite que sera el exponente
         }

         System.out.println("La potencia de " + base + " Elevado a " + exp + " da un total de : " + potencia);
         sc.close();
	}

}
