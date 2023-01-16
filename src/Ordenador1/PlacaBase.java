package Ordenador1;

public class PlacaBase {
    private String marca;
    private String chipset;
    private String socket;

    public PlacaBase(String marca, String chipset, String socket) {
        this.marca = marca;
        this.chipset = chipset;
        this.socket = socket;
    }

    public String getSocket() {
        return socket;
    }

    @Override
    public String toString() {
        return "PlacaBase [marca=" + marca + ", socket=" + socket + ", chipset=" + chipset + "]";
    }
}
