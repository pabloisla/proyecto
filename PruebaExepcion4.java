package MiEntrada;

public class PruebaExepcion4 {
    public static void main(String[] args) {
        String mensaje1 = "Introduce un numero";
        String mensaje2 = "Introduce un numero positivo";
        String mensaje3 = "Introduce un numero entre 10 y 20";

        System.out.println(MiEntradaSalida.solicitarEntero(mensaje1));
        System.out.println(MiEntradaSalida.solicitarEnteroPositivo(mensaje2));
        System.out.println(MiEntradaSalida.solicitarEnteroEnRango(mensaje3, 10, 20));

    }

}