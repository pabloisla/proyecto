package Problemas5;

import java.util.Scanner;

public class Ej3 {

    public static void main(String[] args) {
        String frase;

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la frase:");
        frase = sc.nextLine();
        sc.close();

        System.out.printf("La frase %s %s", frase, esPalindromo(frase) ? "es un palindromo" : "no es un palindromo");
    }

    public static boolean esPalindromo(String frase) {
        StringBuilder str = new StringBuilder(frase);
        boolean esPalindromo = false;

        //Vamos a borrar los espacios
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.deleteCharAt(i);
                i = i - 1;
            }
        }

        if (str.toString().equals(str.reverse().toString())) { // Recorre todos los caracteres de la cadena
            esPalindromo = true;
        }

        return esPalindromo;
    }

}