package Ordenador1;

public class DiscoDuro {
    private String marca;
    private String tipo;
    private int capacidad;

    public DiscoDuro(String marca, String tipo, int capacidad) {
        this.marca = marca;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "DiscoDuro [marca=" + marca + ", tipo=" + tipo + ", capacidad=" + capacidad + "]";
    }
}
