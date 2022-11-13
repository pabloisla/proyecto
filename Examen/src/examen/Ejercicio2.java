package examen;

public class Ejercicio2 {

	public static void main(String[] args) {

		// Declaración de variables
		int[][] jardin = { { 1, 0, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 0, 5, 0 },
				{ 0, 2, 0, 5, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0 }, { 3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4 },
				{ 0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 3, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 3 },
				{ 4, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0, 5, 0, 0, 0 }, { 1, 2, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, { 3, 0, 0, 0, 0, 0, 2, 1, 4, 0, 0, 0, 1, 0, 0 },
				{ 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0 }, { 0, 0, 5, 1, 0, 0, 0, 5, 0, 3, 0, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 2, 4, 0 }, { 0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 0, 0, 1, 3, 0 },
				{ 0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 0, 0, 1 }, { 1, 3, 4, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 4, 2 } };

		boolean aguaColindante = false;
		boolean malaHierbaColindante = false;
		boolean gusanoColindante = false;
		//boolean abejaCerca = false;

		// Declaracion de constantes.
		final int FLOR = 1;
		final int AGUA = 2;
		final int MALAHIERBA = 3;
		final int GUSANO = 4;
		//final int abeja = 5;

		for (int i = 0; i < jardin.length; i++) {
			for (int j = 0; j < jardin[0].length; j++) {
				aguaColindante = false;
				malaHierbaColindante = false;
				gusanoColindante = false;
				//abejaCerca = false;

				// Con esto compruebo si hay AGUA colindante a una FLOR
				if (jardin[i][j] == FLOR) {
					if (j != jardin[0].length - 1) {
						if (jardin[i][j + 1] == AGUA) {
							aguaColindante = true;
						}
					}
					if (j != 0) {
						if (jardin[i][j - 1] == AGUA) {
							aguaColindante = true;
						}
					}
					if (i != jardin[0].length - 1) {
						if (jardin[i + 1][j] == AGUA) {
							aguaColindante = true;
						}
					}
					if (i != 0) {
						if (jardin[i - 1][j] == AGUA) {
							aguaColindante = true;
						}
					}
					// Este if controla la esquina inferior derecha de la matriz
					if (i != jardin.length - 1 && j != jardin[0].length - 1) {
						if (jardin[i + 1][j + 1] == AGUA) {
							aguaColindante = true;
						}
					}
					// Este if controla la esquina inferior izquierda de la matriz
					if (i != jardin.length - 1 && j != 0) {
						if (jardin[i + 1][j - 1] == AGUA) {
							aguaColindante = true;
						}
					}
					// Este if controla la esquina superior derecha de la matriz
					if (i != 0 && j != jardin[0].length - 1) {
						if (jardin[i - 1][j + 1] == AGUA) {
							aguaColindante = true;
						}
					}
					// Este if controla la esquina superior izquierda de la matriz
					if (i != 0 && j != 0) {
						if (jardin[i - 1][j - 1] == AGUA) {
							aguaColindante = true;
						}
					}

					// Con esto compuebro si hay una mala hierba colindante a una FLOR;
					if (jardin[i][j] == FLOR) {
						
						
						if (j != jardin[0].length - 1) {
							if (jardin[i][j + 1] == MALAHIERBA) {
								malaHierbaColindante = true;
							}
						}
						if (j != 0) {
							if (jardin[i][j - 1] == MALAHIERBA) {
								malaHierbaColindante = true;
							}
						}
						if (i != jardin[0].length - 1) {
							if (jardin[i + 1][j] == MALAHIERBA) {
								malaHierbaColindante = true;
							}
						}
						if (i != 0) {
							if (jardin[i - 1][j] == MALAHIERBA) {
								malaHierbaColindante = true;
							}
						}
						// Este if controla la esquina inferior derecha de la matriz
						if (i != jardin.length - 1 && j != jardin[0].length - 1) {
							if (jardin[i + 1][j + 1] == MALAHIERBA) {
								malaHierbaColindante = true;
							}
						}
						// Este if controla la esquina inferior izquierda de la matriz
						if (i != jardin.length - 1 && j != 0) {
							if (jardin[i + 1][j - 1] == MALAHIERBA) {
								malaHierbaColindante = true;
							}
						}
						// Este if controla la esquina superior derecha de la matriz
						if (i != 0 && j != jardin[0].length - 1) {
							if (jardin[i - 1][j + 1] == MALAHIERBA) {
								malaHierbaColindante = true;
							}
						}
						// Este if controla la esquina superior izquierda de la matriz
						if (i != 0 && j != 0) {
							if (jardin[i - 1][j - 1] == MALAHIERBA) {
								malaHierbaColindante = true;
							}
						}
					}

					if (jardin[i][j] == FLOR) {
						if (j != jardin[0].length - 1) {
							if (jardin[i][j + 1] == GUSANO) {
								gusanoColindante = true;
							}
						}
						if (j != 0) {
							if (jardin[i][j - 1] == GUSANO) {
								gusanoColindante = true;
							}
						}
						if (i != jardin[0].length - 1) {
							if (jardin[i + 1][j] == GUSANO) {
								gusanoColindante = true;
							}
						}
						if (i != 0) {
							if (jardin[i - 1][j] == GUSANO) {
								gusanoColindante = true;
							}
						}
						// Este if controla la esquina inferior derecha de la matriz
						if (i != jardin.length - 1 && j != jardin[0].length - 1) {
							if (jardin[i + 1][j + 1] == GUSANO) {
								gusanoColindante = true;
							}
						}
						// Este if controla la esquina inferior izquierda de la matriz
						if (i != jardin.length - 1 && j != 0) {
							if (jardin[i + 1][j - 1] == GUSANO) {
								gusanoColindante = true;
							}
						}
						// Este if controla la esquina superior derecha de la matriz
						if (i != 0 && j != jardin[0].length - 1) {
							if (jardin[i - 1][j + 1] == GUSANO) {
								gusanoColindante = true;
							}
						}
						// Este if controla la esquina superior izquierda de la matriz
						if (i != 0 && j != 0) {
							if (jardin[i - 1][j - 1] == GUSANO) {
								gusanoColindante = true;
							}
						}
					}
					
					
					
					// Si es una flor, no tiene una mala hierba colindante y tiene 
					if (jardin[i][j] == FLOR && malaHierbaColindante == false && aguaColindante == true) {
						System.out.println("La FLOR en la posición " + i + "," + j + " florecerá");
					}
					if (jardin[i][j] == FLOR && malaHierbaColindante == true && gusanoColindante == true && aguaColindante == true) {
						System.out.println("La FLOR en la posición " + i + "," + j + " florecerá");
					}
				}
			}

		}
	}
}
