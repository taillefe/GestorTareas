package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Tarea;

/**
 * 
 * @author Laura
 *  aquí definimos los métodos de 
 *	 cargarTareas desde el fichero de texto
 *   crearNuevaTarea y añadirla al ArrayList
 *	 listarTareas a partir de un ArrayList
 *	 borrarTareaPorPosicion del ArrayList
 *   modificarTareaPorPosicion del ArrayList
 *	 guardarTareas en el fichero de texto
 */
public class ProcesadorTareas {
	
		// se le pasa la dirección del fichero de texto y devuelve 
		// un ArrayList de Tarea con los datos del fichero cargados
		public static ArrayList<Tarea> cargarTareas(String dir) {
		
		// el programa leer fichero devuelve el contenido del 
		// fichero en un String sin procesar
		String cadenaTareas = GestionFicheros.leerFichero(dir);
	
		ArrayList<Tarea> tars = new ArrayList<Tarea>();
		String cadenaTarea = "";
		char datoCaracter;

		for (int i = 0; i < cadenaTareas.length(); i++) {
				datoCaracter = cadenaTareas.charAt(i);
				//marca de separacion de registro ";"
				if (datoCaracter == ';') {  
				  // nuevo registro	
					// añadimos el objeto Tarea al ArrayList
					añadirTarea(cadenaTarea,tars);
										
					// se inicializa la variable cadenaTarea
					cadenaTarea = "";  
				}else {
					cadenaTarea = cadenaTarea + datoCaracter;
				}
		}
		//como no lleva ; al final de la última tarea, 
		// cuando sale del for hay que procesar  el ultimo registro
		añadirTarea(cadenaTarea,tars);

		System.out.println("Cargadas "+ tars.size()+" tareas");
		
		return tars;
	}
	
	//añadimos el objeto Tarea a la lista
	// separando cada uno de sus atributos
	public static void añadirTarea(String s, ArrayList<Tarea> tars) {
		
		//cada atributo está separado por un "-"
		// se obtienen los datos de los atributos
		String [] cortarCadena = s.split("-"); 
		
		//constructor del objeto Tarea, añado los atributos
		Tarea tar = new Tarea(Integer.parseInt(cortarCadena[0]), cortarCadena[1]);
		tars.add(tar);
	}
	
	//se le pasa el valor de la nueva tarea y el ArrayList y 
	//devuelve el ArrayList con la tarea añadida
	public static void crearNuevaTarea(ArrayList<Tarea> tareas,Tarea t){
		tareas.add(t);
		System.out.println("Tarea "+ t.getNombre() +" añadida a la lista");
		
	}


	// se le pasa el ArrayList y devuelve la lista por pantalla
	public static void listarTareas(ArrayList<Tarea> tareas){
		
		System.out.println("\r     LISTA DE TAREAS");
		System.out.println("--------------------------------");
		Tarea t = new Tarea();
		for (int i=0; i<tareas.size(); i++) {
			int numTarea = i +1; 
			System.out.println("NUM: "+ numTarea +" "+ "  NOMBRE: "+tareas.get(i).getNombre());
		}
	
	}
	
	//se le pasa el dato de la posicion de la tarea que se quiere borrar y el ArrayList
	
	public static void borrarTareaPorPosicion(ArrayList<Tarea> tareas,int pos){
		
		boolean salir = false;
		System.out.println("Está seguro de que desea borrar la tarea : "+ tareas.get(pos).getNombre()
				+ " (S/N)" );
		while (!salir) {
			Scanner sn =new Scanner (System.in);
			String respuesta = sn.nextLine();
			
			if (respuesta.equals("s") || respuesta.equals("S")) {
				salir = true;
				tareas.remove(pos);
				System.out.println("\rTarea borrada");
			}else if  (respuesta.equals("n") || respuesta.equals("N")) {
				salir = true;
				System.out.println("\rLa Tarea no se ha borrado");
			}else {
				System.out.println("La respuesta debe ser S o N\r");
				salir = false;
				
			}	
		}
		

	}
	
	
	//se le pasa el dato de la posicion de la tarea que se quiere modificar, 
	// la tarea modificada  y el ArrayList
	
	public static void modificarTareaPorPosicion(ArrayList<Tarea> tareas,int pos,Tarea tar){
		tareas.set(pos, tar);
		System.out.println("\rTarea modificada");

	}
	
	// se le pasa el ArrayList con los datos a guardar y la dirección del fichero
	// donde guardarlos
	//la tarea que realiza es guardar los datos en el fichero
	public static void guardarTareas(ArrayList<Tarea> tareas, String path) {
		
		String cadena = "";
		//se recorre el ArrayList para obtener un String con los datos
		// separados por ";"
		for(Tarea t:tareas) {
			cadena = cadena + t.getId() + "-" + t.getNombre() + ";" ;
		}
		
		//antes de guardar los datos en el fichero hay que eliminar 
		//el ultimo caracter ";" escrito
		cadena = cadena.substring(0, cadena.length()-1);
		
		GestionFicheros.escribirFichero(cadena, path);
		System.out.println("\rFichero "+ path + " guardado");
	
	}
	
}






