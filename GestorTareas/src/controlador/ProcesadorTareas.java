package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcesadorTareas {
	
	// aquí definimos los métodos de 
	// cargarTareas desde el fichero de texto
	// listarTareas a partir de un ArrayList
	// crearTarea y añadirla al ArrayList
	// borrarTarea del ArrayList
	// guardarTarea en el fichero de texto
	
	public static ArrayList<String> cargarTareas(String dir) {
		
		// Creamos un ArrayList de Strings
		System.out.println("Creamos un ArrayList de String");
		
		
		ArrayList<String> tar = new ArrayList<String>();

		//  el fichero donde estan los datos
		File fichero = new File(dir);
		

		try {
			// Leemos el contenido del fichero
			System.out.println("Leemos el contenido del fichero\n");
						
			FileReader fr;
			
			int dato;
			
			fr = new FileReader(dir);
			char datoCaracter;
			String cadena ="";
			
			while  ((dato = fr.read())!=-1)
			{
				datoCaracter =((char)dato);
				
				System.out.print ( datoCaracter);
				
				//marca de separacion de registro ";", o marca de fin de fichero -1
				if (datoCaracter == ';') {  
				  // nuevo registro	
					System.out.println ("\nEsta es la cadena : "+ cadena);
					
					// añadimos el objeto parcela al ArrayList
					tar.add(cadena);
					
					// se inicializa la variable cadena
					cadena = "";  
				}
				else {
					cadena = cadena + datoCaracter;
				}
			}
			//si sale por marca fin de fichero -1 hay que leer el ultimo registro
			
			System.out.println ("\nEsta es la ultima cadena : "+ cadena);
			
			
			// añadimos la tarea al ArrayList
			tar.add(cadena);
			
			
			fr.close();

		} catch (FileNotFoundException ex) {
			System.out.printf("HA ocurrido un error. No se ha encontrado fichero: %s ",ex.getMessage());
			
		} catch (IOException ex){
			System.out.printf("Ha ocurrido una excepcion indeterminada: %s", ex.getMessage());
			
			}
		

		System.out.println("Cargadas "+ tar.size()+" tareas");
		
		return tar;
	}

	
	

}
