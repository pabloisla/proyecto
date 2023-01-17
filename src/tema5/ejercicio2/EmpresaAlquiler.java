package tema5.ejercicio2;

import java.util.Scanner;

import tema5.ejercicio2.Vehiculo.TipoCombustible;

public class EmpresaAlquiler {

    public static final int MAX_VEHICULOS = 200;
    private static Scanner sc;

    private Vehiculo[] vehiculos;

    public EmpresaAlquiler() {
        vehiculos = new Vehiculo[MAX_VEHICULOS];

        if (sc == null) {
            sc = new Scanner(System.in);
        }
    }

    public boolean altaVehiculo() throws InvalidValueException {
        // Representa el vehiculo que sera dado de alta
        Vehiculo v = null;

        String tipoVehiculo = "";
        boolean respuestaCorrecta = false;

        while (!respuestaCorrecta) {
            System.out.println("¿Que vehiculo quieres introducir: Coche, Microbus o Furgoneta?");
            tipoVehiculo = EmpresaAlquiler.sc.nextLine().toLowerCase();

            switch (tipoVehiculo) {
                case "coche", "microbus", "furgoneta" -> respuestaCorrecta = true;
            }
        }

        respuestaCorrecta = false;
        String matricula = "";
        while (!respuestaCorrecta) {
            System.out.print("�Qu� matr�cula tendr�?: ");
            matricula = EmpresaAlquiler.sc.nextLine().toUpperCase();
            if (matricula.length() > 0) {
                respuestaCorrecta = true;
            }
        }

        respuestaCorrecta = false;
        Vehiculo.Gama gama = null;
        while (!respuestaCorrecta) {
            System.out.print("¿Que tipo de gama quiere?: ");
            for (Vehiculo.Gama valor : Vehiculo.Gama.values()) {
                System.out.print(valor + ", ");
            }
            String tipoGama = EmpresaAlquiler.sc.nextLine().toUpperCase();

            try {
                gama = Vehiculo.Gama.valueOf(tipoGama);
                respuestaCorrecta = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Introduce un valor correcto");
            }
        }


        Vehiculo.TipoCombustible combustible = null;
        respuestaCorrecta = false;
        while (!respuestaCorrecta) {
            System.out.print("¿Que tipo de combustible quiere?: ");
            for (Vehiculo.TipoCombustible valor : Vehiculo.TipoCombustible.values()) {
                System.out.print(valor + ", ");
            }

//			Vehiculo.TipoCombustible[] combustibles = Vehiculo.TipoCombustible.values();
//			for (int i = 0; i < combustibles.length; i++) {
//				Vehiculo.TipoCombustible valor = combustibles[i];
//				System.out.print(valor + ", ");
//			}


            String tipoCombustible = EmpresaAlquiler.sc.nextLine().toUpperCase();

            try {
                combustible = Vehiculo.TipoCombustible.valueOf(tipoCombustible);
                respuestaCorrecta = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Introduce un valor correcto");
            }
        }

        /*
         * Voy a coger los datos espec�ficos de cada veh�culo
         */
        switch (tipoVehiculo) {
            case "coche" ->
                // Asigno el nuevo coche a v
                    v = new Coche(matricula, gama, combustible);
            case "microbus" -> {
                int asientos = 0;
                respuestaCorrecta = false;
                while (!respuestaCorrecta) {
                    System.out.print("�Cu�ntos asientos va a tener?: ");

                    try {
                        asientos = Integer.parseInt(sc.nextLine());
                        if (Microbus.isValidPlazas(asientos)) {
                            respuestaCorrecta = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Introduce un valor correcto");
                    }
                }
                // Asignamos el microb�s a v
                v = new Microbus(matricula, gama, combustible, asientos);
            }
            case "furgoneta" -> {
                double pma = 0;
                respuestaCorrecta = false;
                while (!respuestaCorrecta) {
                    System.out.print("�Qu� PMA tendr�?: ");

                    try {
                        pma = Double.parseDouble(sc.nextLine());
                        if (FurgonetaCarga.isValidPMA(pma)) {
                            respuestaCorrecta = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Introduce un valor correcto");
                    }
                }
                v = new FurgonetaCarga(matricula, gama, combustible, pma);
            }
        }

        return this.addVehiculo(v);

    }

    private boolean addVehiculo(Vehiculo v) {
        boolean enc = false;
        int i = 0;

        while (i < this.vehiculos.length && !enc) {
            if (this.vehiculos[i] == null) {
                enc = true;
                this.vehiculos[i] = v;
            }
            i++;
        }

        return enc;
    }


    public static void main(String[] args) {

        if (sc != null) { // sc instanceof Scanner
            EmpresaAlquiler.sc.close();
        }
    }

}
