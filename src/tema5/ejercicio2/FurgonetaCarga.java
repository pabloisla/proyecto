package tema5.ejercicio2;

public class FurgonetaCarga extends Vehiculo {

  //precio de cada kilo de peso m�ximo autorizado (PMA)
  private static final double INCREMENTO_POR_PMA = 0.5;
  
  //precio maximo autorizado
  private double pma;
  
  
  public FurgonetaCarga(String matricula, Gama gama, TipoCombustible combustible, double pma) throws InvalidValueException {
    super(matricula, gama, combustible);
    
    if(!FurgonetaCarga.isValidPMA(pma)) {
      throw new InvalidValueException("El Peso M�ximo Permitido debe ser positivo.");
    }
    
    this.pma = pma;
  }
  
  
  public double getPMA() {

    return this.pma;
  }
  
  
  @Override
  public double getPrecioBase() {
    //se calcula el precio base en funcion del Peso Maximo Autorizado
    return super.getPrecioBase() + (this.getPMA() * INCREMENTO_POR_PMA);
  }
  
  public static boolean isValidPMA(double pma) {

    return pma > 0;
  }

}
