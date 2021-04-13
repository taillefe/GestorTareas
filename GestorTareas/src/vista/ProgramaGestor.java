package vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import controlador.ProcesadorTareas;



public class ProgramaGestor {

	public static void main(String[] args) {
		//Ruta del fichero
		String rutaFichero=".//Fichero//data.txt";
		
		ArrayList<String> tareas = new ArrayList<String>();
		
		tareas = ProcesadorTareas.cargarTareas(rutaFichero);
		
	}
	
	

}
