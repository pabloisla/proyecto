package Ordenador1;

public class TarjetaGrafica {
    private String marca;
    private String modelo;
    private int nucleos;
    private int cantidadMemoria;
    private float velocidad;

    public TarjetaGrafica(String marca, String modelo, int nucleos, int cantidadMemoria, float velocidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.nucleos = nucleos;
        this.cantidadMemoria = cantidadMemoria;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "TarjetaGrafica{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", nucleos=" + nucleos +
                ", cantidadMemoria=" + cantidadMemoria +
                ", velocidad=" + velocidad +
                '}';
    }
}
