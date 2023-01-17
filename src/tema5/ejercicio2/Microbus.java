package tema5.ejercicio2;

public class Microbus extends Vehiculo{

  private static final double PRECIO_POR_PLAZA = 5;
  
  //numero de plazas
  private int plazas;

  public Microbus(String matricula, Gama gama, TipoCombustible combustible, int numPlazas) throws InvalidValueException {
    super(matricula, gama, combustible);

    if(!Microbus.isValidPlazas(numPlazas)) {
      throw new InvalidValueException("El n�mero de plazas debe ser positivo.");
    } 
    
    this.plazas = numPlazas;   
  }
  
  
  public int getPlazas() {

    return this.plazas;
  }
  
  public static boolean isValidPlazas(int plazas) {

    return plazas > 0 && plazas < 21;
  }
  
  
  @Override
  public double getPrecioBase() {
    //se calcula el precio base en funcion del numero de plazas y el precio de cada una
    return super.getPrecioBase() + (this.getPlazas() * PRECIO_POR_PLAZA);
  }
}
