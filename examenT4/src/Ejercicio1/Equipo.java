package boletin2.examenT4.src.Ejercicio1;

import java.util.Arrays;

import boletin2.examenT4.src.Ejercicio1.Excepciones.MundialException;

public class Equipo {
	private final static int NUM_JUGADORES = 2;
	
	private final String pais;
	private String entrenador;
	private Jugador[] jugadores;
	private int numJugadores;
	
	public Equipo(String pais, String entrenador) {
		this.pais = pais;
		this.entrenador = entrenador;
		this.jugadores = new Jugador[NUM_JUGADORES];
		this.numJugadores = 0;
	}
	
	public void addJugador(Jugador j) throws MundialException {
		if (numJugadores < NUM_JUGADORES) {
			this.jugadores[numJugadores++] = j;
		}
		else {
			throw new MundialException("No caben más jugadores en el equipo");
		}
	}
	
	public boolean eliminaJugador(Jugador j) {
		boolean enc = false;
		int i = 0;
		
		while (i < NUM_JUGADORES && !enc) {
			if (j.equals(this.jugadores[i])) {
				enc = true;
				this.jugadores[i] = null;
			}
			
			i++;
		}
		
		return enc;
	}

	public String getPais() {
		return pais;
	}

	public String getEntrenador() {
		return entrenador;
	}

	public Jugador[] getJugadores() {
		return jugadores;
	}
	
	public int getGolesMarcadosPorEquipo () {
		int numGoles = 0;
		
		for (int i = 0; i < this.numJugadores; i++) {
			numGoles += this.jugadores[i].getGolesMarcados();
		}
		
		return numGoles;
	}
	
	public Jugador getPichichi() {
		Jugador pichichi = null;
		int goles = -1;
		
		for (int i = 0; i < this.numJugadores; i++) {
			if (this.jugadores[i].getGolesMarcados() > goles) {
				goles = this.jugadores[i].getGolesMarcados();
				pichichi = this.jugadores[i];
			}
		}
		
		return pichichi;
	}
	
	public Jugador getJugadorPorNombre(String nombre) {
		Jugador j = null;
		boolean enc = false;
		
		for (int i = 0; i < this.numJugadores && !enc; i++) {
			if (this.jugadores[i].getNombre().equalsIgnoreCase(nombre)) {
				j = this.jugadores[i];
				enc = true;
			}
		}
		
		return j;
	}

	@Override
	public String toString() {
		return "Equipo [pais=" + pais + ", entrenador=" + entrenador + ", jugadores=" + Arrays.toString(jugadores)
				+ ", numJugadores=" + numJugadores + "]";
	}
}
