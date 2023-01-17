package Problemas5;

public class Ej1 {
    public static void main(String[] args) {

        String cadena;
        cadena = "Hola que tal estas";
        char c = 'A';
        Ej1 miEjercicio;
        miEjercicio = new Ej1();
        System.out.printf("En la cadena %s, la letra %s se repite %d veces",
                cadena, c, miEjercicio.cuentaRepeticiones(cadena, c));

    }

    public int cuentaRepeticiones(String cadena, char c) {
        int contador = 0;

        // Pasamos todo a mayusculas para comparar sin importar la capitalidad
        cadena = cadena.toUpperCase();
        c = Character.toUpperCase(c);

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == c) {
                contador++;
            }
        }

        return contador;
    }
}