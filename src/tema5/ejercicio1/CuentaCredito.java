package tema5.ejercicio1;

public class CuentaCredito extends Cuenta {
  
  private static final double CREDITO_POR_DEFECTO = 100;
  private static final double CREDITO_MAXIMO = 300;
  
  private double credito;
  private double creditoConsumido;
  private int contadorReintegroNoRegistrado;
  private int contadorIngresoNoRegistrado;

  private double creditoInicialCuenta;
  
  public CuentaCredito(String titular) throws CuentaException {
    super(titular);
    this.setCredito(CREDITO_POR_DEFECTO);
    this.creditoConsumido = 0;
    this.contadorIngresoNoRegistrado = 0;
    this.contadorReintegroNoRegistrado = 0;
  }


  public CuentaCredito(double saldo, String titular) throws CuentaException {
    super(saldo, titular);
    this.setCredito(CREDITO_POR_DEFECTO);
    this.creditoConsumido = 0;
    this.contadorIngresoNoRegistrado = 0;
    this.contadorReintegroNoRegistrado = 0;
  }
  
  
  public CuentaCredito(double saldo, double credito, String titular) throws CuentaException {
    super(saldo, titular);
    this.setCredito(credito);
    this.creditoConsumido = 0;
    this.contadorIngresoNoRegistrado = 0;
    this.contadorReintegroNoRegistrado = 0;
  }

  
  public double getCredito() {

    return this.credito;
  }
  
  private void setCredito(double credito) throws CuentaException {
    if(credito < 0 || credito > CREDITO_MAXIMO) {
      throw new CuentaException("El valor " + credito + " no esta aceptado para el credito.");
    }
    
    this.credito = credito;
  }

  @Override
  public void realizarReintegro(double cantidadRetirada) throws CuentaException {
    
    if(cantidadRetirada <= 0) {
      throw new CuentaException("Solo se pueden retirar cantidades positivas.");
    }
    if(cantidadRetirada > (super.getSaldo() + (this.getCredito() - this.creditoConsumido))) {
      throw new CuentaException("Saldo insuficiente.");
    }
    
    double retiro = 0;
    
    //si el saldo del padre es mayor que la Cantidad retirada
    if(super.getSaldo() >= cantidadRetirada) {
      //entonces lo puede retirar el padre sin problemas
      retiro = cantidadRetirada;
    }
    /* si el saldo del padre es menor que el saldo, entonces hay que comprobar si tiene credito suficiente
     * es decir: el saldo del padre es mayor o igual que el monto a retirar menos el credito restante
     */
    else { 
      //se retira una cantidad igual al saldo, para que quede a cero
      retiro = super.getSaldo();
      //se calcula el credito consumido con la operacion
      this.creditoConsumido += cantidadRetirada - super.getSaldo();
    }
    
    /*
     * se realiza el retiro en la clase padre, pero se filtra el valor del 0 para no lanzar excepcion en el padre...
     */
    if(retiro != 0) {
      super.realizarReintegro(retiro);
    }
    else {
      /*
       * Al filtrar el cero no se esta llamando al metodo del padre, y por tanto no se esta incrementando el numero de
       * reintegros, asi que hace falta llevar un conteo adicional en la clase hija (esta) de los reintegros no registrados
       * en la clase padre.
       */
      this.contadorReintegroNoRegistrado++;
    }
  }
  
  
  @Override
  public int getContadorReintegros() {

    return super.getContadorReintegros() + this.contadorReintegroNoRegistrado;
  }
  
  
  @Override
  public void realizarIngreso(double ingreso) throws CuentaException {

    /*if(credito == creditoInicialCuenta) {
      super.realizarIngreso(ingreso);
    }else {
      if(ingreso >= (creditoInicialCuenta - credito)){
        double dineroIngresarEnCredito = creditoInicialCuenta - credito;
        double dineroIngresarSaldo = ingreso - dineroIngresarEnCredito;
        credito += dineroIngresarEnCredito;
        super.ingreso (dineroIngresaEnCredito);

      }
    }
  */

    if(ingreso <= 0) {
      throw new CuentaException("Solo pueden ingresarse cantidades positivas.");
    }
    
    if (this.creditoConsumido > 0) {
      if (this.creditoConsumido - ingreso >= 0) {
    	// Ingreso menos del credito que debo
    	this.creditoConsumido -= ingreso; // this.creditoConsumido - ingreso
    	this.contadorIngresoNoRegistrado++;
      }
      else {
    	super.realizarIngreso(ingreso - this.creditoConsumido);
    	this.creditoConsumido = 0;
      }
    }
    else {
      // No he consumido credito alguno, recargo solo el saldo
      super.realizarIngreso(ingreso);
    }
    
  }
  @Override
  public int getContadorIngresos() {

    return super.getContadorIngresos() + this.contadorIngresoNoRegistrado;
  }

  /**
   * El saldo del padre menos el credito consumido hasta el momento
   */
  @Override
  public double getSaldo() {

    return super.getSaldo() - this.creditoConsumido;
  }

  
  //TODO: quitar saldo padre
  @Override
  public String toString() {
    return String.format("Titular: %s.%nSaldo padre: %.2f%nSaldo: %.2f%nCredito total: %.2f%n"
        + "Credito consumido: %.2f%nReintegros realizados: %d%n", this.getTitular(),
        super.getSaldo(), this.getSaldo(), this.getCredito(), this.creditoConsumido, this.getContadorReintegros());
  }
}
