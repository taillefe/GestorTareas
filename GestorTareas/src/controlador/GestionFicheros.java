package controlador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Tarea;

public class GestionFicheros {
	
	
	//Metodo que lee un fichero cuyo path se pasa por parámetro
	// y devuelve un ArrayList de objetos Tarea
	//podría devolver un String y procesarlo en el método ProcesarTareas
	public static ArrayList<Tarea> leerFichero(String path) {
		
		FileReader fr;
		int dato;
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		//constructor del objeto tarea
		Tarea t = new Tarea();
		
		try {
					
			fr = new FileReader(path);
			char datoCaracter;
			String cadena ="";
					
			while  ((dato = fr.read())!=-1)
			{
				datoCaracter =((char)dato);
				
			//	System.out.print ( datoCaracter);
				
				//marca de separacion de registro ";", o marca de fin de fichero -1
				if (datoCaracter == ';') {  
				  // nuevo registro	
				//	System.out.println ("\nEsta es la cadena : "+ cadena);
					
					// añadimos el objeto Tarea al ArrayList
					
					t = new Tarea(cadena);
					tareas.add(t);
					
					// se inicializa la variable cadena
					cadena = "";  
				}
				else {
					cadena = cadena + datoCaracter;
				}
			}
			//si sale por marca fin de fichero -1 hay que leer el ultimo registro
			
			// añadimos el objeto Tarea al ArrayList
			t = new Tarea(cadena);
			tareas.add(t);
						
			fr.close();
		}catch (FileNotFoundException ex) {
			System.out.printf("\n Ha ocurrido un error. No se ha encontrado el fichero:\n%s", ex.getMessage());
			
		}catch (IOException ex) {
			System.out.printf("\n Ha ocurrido una exceptción indeterminada:\n%s", ex.getMessage());
			
		}
		return tareas;
	
	} // leerfichero
	
	
	public static void escribirFichero(String cadena, String dir, String arch) {
		FileWriter fw;
		try {
			String path=dir + arch;
			fw= new FileWriter(path);
			fw.write (cadena);
			fw.flush();
			fw.close();
		}catch (FileNotFoundException ex) {
			System.out.printf("\n Ha ocurrido un error. No se ha encontrado el fichero:\n%s", ex.getMessage());
			
		}catch (IOException ex) {
			System.out.printf("\n Ha ocurrido una exceptción indeterminada:\n%s", ex.getMessage());
			
		}
	}// escribirfichero

}
