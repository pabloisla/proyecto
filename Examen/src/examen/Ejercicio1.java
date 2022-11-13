package examen;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		//Declaración de variables
		String[] estados = {"Alabama", "Alaska", "Arizona", "Arkansas", "California",
				"Carolina del Norte", "Carolina del Sur", "Colorado",
				"Connecticut", "Dakota del Norte", "Dakota del Sur", "Delaware",
				"Distrito de Columbia", "Florida", "Georgia", "Hawái", "Idaho",
				"Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Luisiana",
				"Maine", "Maryland", "Massachusetts", "Míchigan", "Minnesota",
				"Mississippi", "Misuri", "Montana", "Nebraska", "Nevada", "Nueva Jersey", "Nueva York", "Nuevo Hampshire", "Nuevo México", "Ohio",
				"Oklahoma", "Oregón", "Pensilvania", "Rhode Island", "Tennessee",
				"Texas", "Utah", "Vermont", "Virginia", "Virginia Occidental",
				"Washington", "Wisconsin", "Wyoming"};

		
		int[] electorales = {9, 3, 11, 6, 55, 15, 9, 9, 7, 3, 3, 3, 3, 29, 16, 4, 4,
				20, 11, 6, 6, 8, 8, 4, 10, 11, 16, 10, 6, 10, 3, 5, 6, 14, 29, 4,
				5, 18, 7, 7, 20, 4, 11, 38, 6, 3, 13, 5, 12, 10, 3};
		
		int[] votosDemocratas = {729547, 116454, 1161167, 380494,
				8753788, 1338870, 897572, 235603, 282830, 4504975, 1877963, 266891,
				189765, 3090729, 1033126, 653669, 427005, 628854, 780154, 715326,
				1677928, 1995196, 2268839, 1367716, 485131, 1071068, 177709,
				568988, 539260, 348526, 2148278, 385234, 4556124, 2189316, 93758,
				2394164, 420375, 1002106, 2926441, 252525, 855373, 117458, 870695,
				3877868, 310676, 178573, 1981473, 1742718, 188794, 1382536, 55973};
		
		int[] votosRepublicanos = {1318255, 163387, 1252401, 684872,
				4483810, 1202484, 673215, 185127, 12723, 4617886, 2089104, 128847,
				409055, 2146015, 1557286, 800983, 671018, 1202971, 1178638, 671154,
				943169, 1090893, 2279543, 1322951, 700714, 1594511, 279240, 991922,
				512058, 345790, 1601933, 319667, 2819534, 2362631, 216794, 2841005,
				949136, 782403, 2970733, 180543, 1155389, 227721, 1522925, 4685047,
				515231, 95369, 1769443, 1221747, 489371, 1405284, 174419};
		
		int contadorElectoresRepublicanos = 0;
		int contadorElectoresDemocratas = 0;
		int mayorElectoralDemocrata = 0;
		int mayorElectoralRepublicano = 0;
		int totalVotosDemocratas = 0;
		int totalVotosRepublicanos = 0;
		int numeroEstadosRepublicanos = 0;
		int numeroEstadosDemocratas = 0;
		boolean electoralDemocrata = false;
		boolean electoralRepublicano = false;
		String estadoDeterminanteRepublicano = "";
		String estadoDeterminanteDemocrata = "";
		for (int i = 0; i < estados.length; i++) {
			
			// Cada vez que se ejecute el bucle ponemos estas variables a false
			electoralDemocrata = false;
			electoralRepublicano = false;
			
			// Con esto contamos el total de votos de cada partido
			totalVotosDemocratas += votosDemocratas[i];
			totalVotosRepublicanos += votosRepublicanos[i];
			
			// Si el voto democrata es mayor que el voto republicano sumamos los electorales a dicho partido y viceversa
			if (votosDemocratas[i] > votosRepublicanos[i]) {
				contadorElectoresDemocratas += electorales[i];
				electoralDemocrata = true;
				numeroEstadosDemocratas += 1;
			}
			else {
				contadorElectoresRepublicanos += electorales[i];
				electoralRepublicano = true;
				numeroEstadosRepublicanos += 1;
			}
			
			// Si el voto de un estado lo ha ganado un partido y el electoral actual es mayor que la variable mayorElectoralDemocrata
			if (electorales[i] > mayorElectoralDemocrata && electoralDemocrata == true) {
				mayorElectoralDemocrata = electorales[i];
				estadoDeterminanteDemocrata = estados[i];
			}
			
			if (electorales[i] > mayorElectoralRepublicano && electoralRepublicano == true) {
				mayorElectoralRepublicano = electorales[i];
				estadoDeterminanteRepublicano = estados[i];
			}
			
		}
		
		// Con este if indicamos si han ganado los republicanos o los demócratas
		if (contadorElectoresRepublicanos > contadorElectoresDemocratas) {
			System.out.println("Las elecciones la han ganado los Republicanos");
		}
		else {
			System.out.println("Las elecciones la han ganado los Democratas");
		}
		
		// Imprimimos por pantalla el número total de electores de cada partido
		System.out.printf("El número total de electores del partido Republicano es: %d \n", contadorElectoresRepublicanos);
		System.out.printf("El número total de electores del partido Democrata es: %d \n", contadorElectoresDemocratas);
		
		// Con este if vemos cual de los 2 partidos tiene más votos
		if (totalVotosDemocratas > totalVotosRepublicanos) {
			System.out.printf("El número mayor de votos se lo ha llevado el partido Demócrata con %d votos \n", totalVotosDemocratas);
		}
		else {
			System.out.printf("El número mayor de votos se lo ha llevado el partido Republicano con %d votos \n", totalVotosRepublicanos);
		}
		
		// Imprimimos el número de estados que apoyan a ambos partidos
		System.out.printf("El número de estados que apoyan al partido Republicano es: %d \n", numeroEstadosRepublicanos);
		System.out.printf("El número de estados que apoyan al partido Demócratas es: %d \n", numeroEstadosDemocratas);
		
		// Imprimimos el estado que más electores aporta a cada partido
		System.out.printf("El estado que más aporta al partido Republicano es: %s \n", estadoDeterminanteRepublicano);
		System.out.printf("El estado que más aporta al partido Democrata es: %s", estadoDeterminanteDemocrata);
		
		
	}

}
