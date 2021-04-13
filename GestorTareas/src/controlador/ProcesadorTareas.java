package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Tarea;

/**
 * 
 * @author Laura
 *  aquí definimos los métodos de 
 *	 cargarTareas desde el fichero de texto
 *   crearNuevaTarea y añadirla al ArrayList
 *	 listarTareas a partir de un ArrayList
 *	 borrarTareaPorPosicion del ArrayList
 *	 guardarTareas en el fichero de texto
 */
public class ProcesadorTareas {
	
	// se le pasa la dirección del fichero de texto y devuelve 
	// un ArrayList de Tarea con los datos del fichero cargados
	public static ArrayList<Tarea> cargarTareas(String dir) {
	
		ArrayList<Tarea> tar = new ArrayList<Tarea>();

		//  el fichero donde estan los datos
		File fichero = new File(dir);

		tar = GestionFicheros.leerFichero(dir);
		

		System.out.println("Cargadas "+ tar.size()+" tareas");
		
		return tar;
	}
	
	//se le pasa el valor de la nueva tarea y el ArrayList y 
	//devuelve el ArrayList con la tarea añadida
	public static ArrayList<Tarea> crearNuevaTarea(Tarea t){
		return null;
		
	}


	// se le pasa el ArrayList y devuelve la lista por pantalla
	public static void listarTareas(ArrayList<Tarea> tareas){
		
		Tarea t = new Tarea();
		for (int i=0; i<tareas.size(); i++) {
			int numTarea = i +1; 
			System.out.println(numTarea +" "+tareas.get(i).getNombre());
		}

	
		
	}
	
	//se le pasa el dato de la posicion de la tarea que se quiere borrar y el ArrayList
	// y devuelve el ArrayList modificado
	public static ArrayList<Tarea>  borrarTareaPorPosicion(ArrayList<Tarea> t,int posicion){
		return null;
	}
	
	// se le pasa el ArrayList con los datos a guardar y la dirección del fichero
	// donde guardarlos
	//la tarea que realiza es guardar los datos en el fichero
	public static void guardarTareas(ArrayList<Tarea> tareas, String path) {
		
		String cadena = "";
		//se recorre el ArrayList para obtener un String con los datos
		// separados por ";"
		for(Tarea t:tareas) {
			cadena = cadena + t.getNombre() + ";" ;
		}
		
		//antes de guardar los datos en el fichero hay que eliminar 
		//el ultimo caracter ";" escrito
		cadena = cadena.substring(0, cadena.length()-1);
		
		GestionFicheros.escribirFichero(cadena, path);
	
	}
	
}






