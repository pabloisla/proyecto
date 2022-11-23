package Cuenta;

import java.util.Scanner;

public class Cuenta {
	
	private double saldo;
	private int numIngresos;
	private int numReintegros;
	
	public double getSaldo() {
		return saldo;
	}
	public double cuenta(double saldo) {
		this.saldo = saldo;
		this.numIngresos = 0;
		this.numReintegros = 0;
	}
	public double reintegro(double retirarDinero) {
		if(this.saldo <= retirarDinero) {
			System.out.println("No se puede sacar la cantidad indicada");
			
		}
		else {
			saldo = saldo - retirarDinero;
			numIngresos++;
			
		}
	}
	public void ingresar(double cantidadIngresar) {
		if(cantidadIngresar > 0);
			saldo = saldo + cantidadIngresar;
			numReingresos++;
	}
	else {
		System.out.println("Cantidad insuficiente");
	}

	public String consulta() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return "saldo: "+ saldo + ". ingresos:" + numIngresos + ". retirar: "+ numReintegros;
		

	}

}
