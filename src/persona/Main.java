package persona;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		Persona1 persona = new Persona1("Pablo", LocalDate.of(2000, 8, 2), 29619966, (float) 1.7, 70, 'M');
		System.out.println(persona);
		System.out.println("Tu masa corporal es : " + persona.getIMC());
	}
}