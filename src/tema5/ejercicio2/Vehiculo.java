package tema5.ejercicio2;

public class Vehiculo {
  public static enum Gama {
    
    //posibles valores para las distintas gamas
    BAJA(30), MEDIA(40), ALTA(50);
    
    //precio asignado a cada gama
    private double precio;
    
    //constructor
    private Gama(double precio) {

      this.precio = precio;
    }
    
    //devuelve el precio asignado a cada gama
    public double getPrecio() {

      return this.precio;
    }
  }

  public static enum TipoCombustible { 
	  GASOLINA, DIESEL 
  }
  
  //gama del veh�culo
  private final Gama gama;
  //combustible usado por el veh�culo
  private final TipoCombustible combustibleUsado;
  //matricula del vehiculo
  private String matricula;
  
  
  /**
   * Constructor para vehiculo
   *
   */
  public Vehiculo(String matricula, Gama gama, TipoCombustible combustible) throws InvalidValueException {
    //lanza excepcion si la matricula en null, vacia o solo tiene espacios en blanco
    if(matricula == null || matricula.isEmpty() || matricula.isBlank()) {
      throw new InvalidValueException("Matricula invalida.");
    }
    //lanza excepcion si gama o combustible son null
    if(gama == null || combustible == null) {
      throw new InvalidValueException(gama == null ? "Gama es null." : "Tipo de combustible es null.");
    }
    
    this.matricula = matricula;
    this.gama = gama;
    this.combustibleUsado = combustible;
  }
  
  
  public Gama getGama() {

    return this.gama;
  }
  
  public TipoCombustible getTipoCombustibleUsado() {

    return this.combustibleUsado;
  }
  
  public double getPrecioBase() {
    //extrae el precio base en funcion del tipo de gama al que pertenece
    return this.gama.getPrecio();
  }
  
  public String getMatricula() {

    return this.matricula;
  }
  
  
  public double getPrecio(int dias) throws InvalidValueException {
    if(dias <= 0) {
      throw new InvalidValueException("Se debe alquilar por al menos un dia.");
    }
    
    return this.getPrecioBase() * dias;
  }
}
