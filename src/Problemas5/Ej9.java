package Problemas5;

import java.util.Scanner;

public class Ej9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase");

        String frase = sc.nextLine().toLowerCase();
        sc.close();


        int suma = sumaNumeros(frase);

        System.out.println("La suma de los numeros es " + suma);
    }

    public static int sumaNumeros(String frase) {
        int suma = 0;
        StringBuilder digito = new StringBuilder();
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (Character.isDigit(c)) {
                digito.append(c);
            } else {
                if (digito.length() > 0) {
                    // Convertimos el numero en int
                    suma += Integer.parseInt(digito.toString());
                    digito.delete(0, digito.length());
                }
            }
        }

        if (digito.length() > 0) {
            // Convertimos el numero en int
            suma += Integer.parseInt(digito.toString());

        }

        return suma;
    }

}
