
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

public class TA07Ejercicio1App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaración de variables
		Hashtable<String, Double> Alumnos=new Hashtable<String, Double>();
		
		pedirAlumnos(Alumnos);

	}
	
	public static void pedirAlumnos(Hashtable<String, Double> Alumnos) {
		boolean ContinuarPidiendoAlumnos = true;
		String NombreAlumno;
		String PedirAlumnos;
		
		while (ContinuarPidiendoAlumnos == true) { 
			//Mostramos una ventana para introducir el nombre del alumno
			NombreAlumno = JOptionPane.showInputDialog("Introdiuce el nombre de un alumno");
			
			pedirNotas(NombreAlumno, Alumnos);
			
			//Mostramos una ventana para preguntar si el usuario desea entrar mas alumnos
			PedirAlumnos = JOptionPane.showInputDialog("¿Desea entrar mas alumnos? [ SI | NO ]");
			PedirAlumnos = PedirAlumnos.toUpperCase();
	 		if (PedirAlumnos.equals("SI")) {
	 			ContinuarPidiendoAlumnos = true;
	 		} else {
	 			ContinuarPidiendoAlumnos = false;
	 			mostrarListadoAlumnos(Alumnos);
	 		}
		}
	}
	
	public static void pedirNotas(String NombreAlumno, Hashtable<String, Double> Alumnos) {
		boolean ContinuarPidiendoNotas = true;
		String TextoNota;
		double Nota;
		double NotaMedia = 0;
		String PedirNotas;
		
		//Mostramos una ventana para introducir el una nota
		for (int i=1; ContinuarPidiendoNotas == true; i++) {
			TextoNota = JOptionPane.showInputDialog("Escribe una nota");
	 		Nota = Double.parseDouble(TextoNota);
	 		
	 		NotaMedia += Nota;
	 		
	 		//Mostramos una ventana para preguntar si el usuario desea entrar mas notas
	 		PedirNotas = JOptionPane.showInputDialog("¿Desea entrar mas notas? [ SI | NO ]");
	 		PedirNotas = PedirNotas.toUpperCase();
	 		
	 		if (PedirNotas.equals("SI")) {
	 			ContinuarPidiendoNotas = true;
	 		} else {
	 			ContinuarPidiendoNotas = false;
	 			NotaMedia = NotaMedia / i;
	 			Alumnos.put(NombreAlumno, NotaMedia);
	 		}
		}
	}
	
	public static void mostrarListadoAlumnos(Hashtable<String, Double> Alumnos){
		Enumeration <String> Nombres = Alumnos.keys();
		Enumeration<Double> Medias = Alumnos.elements();
			
		System.out.println("Lista de alumnos");
		System.out.println("");
		while (Nombres.hasMoreElements()) {
			System.out.println("Nombre: " + Nombres.nextElement());
			System.out.println("Nota media: " + Medias.nextElement());
			System.out.println("");
		}
	}
}


