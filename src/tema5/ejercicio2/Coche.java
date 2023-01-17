package tema5.ejercicio2;


public class Coche extends Vehiculo {

  private static final double INCREMENTO_GASOLINA = 3.5;
  private static final double INCREMENTO_DIESEL = 2d;
  
  
  protected Coche(String matricula, Gama gama, TipoCombustible combustible) throws InvalidValueException {
    super(matricula, gama, combustible);
  }

  
  /**
   * Devuelve el precio de alquiler por dia
   */
  @Override
  public double getPrecioBase() {
  //cuanto aumenta el precio base del coche en base a su tipo de consumo
    double incremento;
    
    switch(this.getTipoCombustibleUsado()) {
      case GASOLINA: 
        incremento = INCREMENTO_GASOLINA;
        break;
      case DIESEL:   
        incremento = INCREMENTO_DIESEL;
        break;
      default:       
        incremento = 0;
    }
    
    return super.getPrecioBase() + incremento;
  }

  
}
