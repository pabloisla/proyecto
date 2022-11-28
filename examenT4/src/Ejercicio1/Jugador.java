package boletin2.examenT4.src.Ejercicio1;

import java.util.Objects;

public class Jugador {
	private String nombre;
	private int edad, golesMarcados;
	
	public Jugador(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.golesMarcados = 0;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public int getGolesMarcados() {
		return golesMarcados;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Jugador other = (Jugador) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", edad=" + edad + ", golesMarcados=" + golesMarcados + "]";
	}

	public void addGol() {
		this.golesMarcados++;
	}
	
}
