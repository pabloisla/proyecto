package Problemas5;

import java.util.Scanner;

public class Ejj8 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Introduce una frase");

        String frase = s.nextLine();
        s.close();
        System.out.println("La frase incluye" + contadordepalabras(frase));
    }

    public static int contadordepalabras(String frase) {

        String[] palabras = frase.split(" ");
        int cont = 0;
        for (String palabra : palabras) {
            if (!palabra.equals("")) {
                cont++;
            }
        }
        return cont;
    }
}


