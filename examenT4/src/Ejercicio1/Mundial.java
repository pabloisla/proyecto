package boletin2.examenT4.src.Ejercicio1;

import java.util.Scanner;

import Ejercicio1.Excepciones.MundialException;

public class Mundial {
	private final static int NUM_EQUIPOS = 4;
	private static Scanner sc = new Scanner(System.in);
	
	private String nombre;
	private Equipo[] equipos;
	private int numEquipos;
	
	public Mundial(String nombre) {
		super();
		this.nombre = nombre;
		this.equipos = new Equipo[NUM_EQUIPOS];
	}
	
	public void addEquipo(Equipo e) throws MundialException {
		if (numEquipos < NUM_EQUIPOS) {
			this.equipos[numEquipos++] = e;
		}
		else {
			throw new MundialException("No caben más equipos");
		}
	}
	
	public boolean eliminaEquipo(Equipo e) {
		boolean enc = false;
		
		for (int i = 0; i < numEquipos && !enc; i++) {
			if (e.equals(this.equipos[i])) {
				enc = true;
				this.equipos[i] = null;
			}
		}
		
		return enc;
	}
	
	public int getNumeroGolesMarcados() {
		int numGoles = 0;
		
		for (int i = 0; i < numEquipos; i++) {
			numGoles += this.equipos[i].getGolesMarcadosPorEquipo();
		}
		
		return numGoles;
	}
	
	public Equipo getEquipoGoleador() {
		Equipo equipoGoleador = null;
		int goles = -1;
		
		for (int i = 0; i < numEquipos; i++) {
			if(this.equipos[i].getGolesMarcadosPorEquipo() > goles) {
				goles = this.equipos[i].getGolesMarcadosPorEquipo();
				equipoGoleador = this.equipos[i];
			}
					
		}
		
		return equipoGoleador;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Jugador getPichichi() {
		Jugador pichichi = null;
		int goles = -1;
		
		for (int i = 0; i < numEquipos; i++) {
			if (this.equipos[i].getPichichi().getGolesMarcados() > goles) {
				pichichi = this.equipos[i].getPichichi();
				goles = this.equipos[i].getPichichi().getGolesMarcados();
			}
		}
		
		return pichichi;
	}
	
	public Equipo getEquipoPorNombre(String nombrePais) {
		Equipo e = null;
		boolean enc = false;
		
		for (int i = 0; i < numEquipos && !enc; i++) {
			if (this.equipos[i].getPais().equalsIgnoreCase(nombrePais)) {
				e = this.equipos[i];
				enc = true;
			}
		}
		
		return e;
	}
	
	public static String menu() {
		StringBuilder sb = new StringBuilder();
		sb.append("Elige una opción").append("\n");
		sb.append("1. Crear un nuevo equipo").append("\n");
		sb.append("2. Añadir un jugador a un equipo").append("\n");
		sb.append("3. Ver el número total de goles marcados por un equipo").append("\n");
		sb.append("4. Ver el número total de goles marcados por un jugador").append("\n");
		sb.append("5. Ver el equipo más goleador").append("\n");
		sb.append("6. Ver el pichichi del mundial").append("\n");
		sb.append("7. Salir").append("\n");
		
		return sb.toString();
		
	}
	
	public static void main(String[] args) {
		Mundial mundial = new Mundial("Mundial de chapas en casapuerta de Isla Cristina");
		System.out.println("Bienvenido al " + mundial.getNombre());
		
		boolean salir = false;
		
		while (!salir) {
			System.out.println(menu());
			System.out.print("Introduce una opción: ");
			int opcion = Integer.parseInt(sc.nextLine());
			
			switch(opcion) {
			case 1:
				try {
					mundial.addEquipo(crearEquipo());
				} catch (MundialException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.print("Introduce el nombre del país: ");
				String pais = sc.nextLine();
				Equipo e = mundial.getEquipoPorNombre(pais);
				if (e == null) {
					System.out.println("No se encuentra el país");
				}
				else {
					try {
						e.addJugador(crearJugador());
					} catch (MundialException e1) {
						System.out.println(e1.getMessage());
					}
				}
				break;
			case 3:
				System.out.print("Introduce el nombre del país: ");
				String pais_c3 = sc.nextLine();
				Equipo e_c3 = mundial.getEquipoPorNombre(pais_c3);
				if (e_c3 == null) {
					System.out.println("No se encuentra el país");
				}
				else {
					System.out.println(e_c3.getGolesMarcadosPorEquipo());
				}
				break;
			case 4:
				System.out.print("Introduce el nombre del país: ");
				String pais_c4 = sc.nextLine();
				Equipo e_c4 = mundial.getEquipoPorNombre(pais_c4);
				if (e_c4 == null) {
					System.out.println("No se encuentra el país");
				}
				else {
					System.out.print("Introduce el nombre del jugador: ");
					String nombre = sc.nextLine();
					Jugador j_c4 = e_c4.getJugadorPorNombre(nombre);
					if (j_c4 == null) {
						System.out.println("No se encuentra el jugador");
					}
					else {
						System.out.println(j_c4.getGolesMarcados());
					}
				}
				break;
			case 5:
				System.out.println(mundial.getEquipoGoleador());
				break;
			case 6:
				System.out.println(mundial.getPichichi());
				break;
			case 7: 
				salir = true;
				break;
			}
		}
		
	}

	private static Jugador crearJugador() {
		System.out.print("Introduce el nombre del jugador: ");
		String nombre = sc.nextLine();
		System.out.print("Introduce la edad: ");
		int edad = Integer.parseInt(sc.nextLine());
		
		return new Jugador(nombre, edad);
	}

	private static Equipo crearEquipo() {
		System.out.print("Introduce el nombre del país: ");
		String pais = sc.nextLine();
		System.out.print("Introduce el nombre del entrenador: ");
		String entrenador = sc.nextLine();
		
		return new Equipo(pais, entrenador);
	}
	
}










