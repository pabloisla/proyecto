package Ordenador1;

public class Microprocesador {
    private String marca;
    private String modelo;
    private String socket;
    private int nucleos;
    private float velocidad;

    public Microprocesador(String marca, String modelo, String socket, int numeroNucleos, float velocidad) {
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.socket = socket;
        this.nucleos = numeroNucleos;
        this.velocidad = velocidad;
    }

    /**
     * @param placa
     * @return
     */
    public boolean compatible(PlacaBase placa) {

        return placa.getSocket().equals(socket);

    }

    @Override
    public String toString() {
        return "Microprocesador [marca=" + marca + ", modelo=" + modelo + ", socket=" + socket + ", numeroNucleos="
                + nucleos + ", velocidad=" + velocidad + "]";
    }
}
