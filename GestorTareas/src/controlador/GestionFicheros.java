package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Tarea;
/**
 * 
 * @author Laura
 * clase GestionFicheros se encarga de la lectura y escritura
 * en ficheros de cadenas de caracteres
 * comprobar si existe el fichero y si no existe crearlo
 */
public class GestionFicheros {
	
	
	//comprobar que el fichero exite, y si no crearlo vacio
	public static void crearFichero(String path) throws IOException {
		File f1 = new File (path);
		if (!f1.exists()) {
			if (!f1.createNewFile())
			{
				System.out.println ("No se ha podido crear el fichro " + path);
			}
		}
		else {
			System.out.println("El fichero " + path + " ya extiste");
		}
	}//crearFichero
	
	//lee un fichero cuyo path se pasa por parámetro
	// y devuelve un String 
	public static String leerFichero(String path) {
		
		FileReader fr;
		int dato;
		char datoCaracter;
		String cadena ="";
			
		try {
					
			fr = new FileReader(path);
			// comprobamos que el fichero existe, si no existe lo 
			// creamos vacío 
			
					
			while  ((dato = fr.read())!=-1)
			{
				datoCaracter =((char)dato);
				
				cadena = cadena + datoCaracter;
			
			}
			
			fr.close();
		}catch (FileNotFoundException ex) {
			System.out.printf("\n Ha ocurrido un error. No se ha encontrado el fichero:\n%s", ex.getMessage());
			
		}catch (IOException ex) {
			System.out.printf("\n Ha ocurrido una exceptción indeterminada:\n%s", ex.getMessage());
			
		}
		return cadena;
	
	} // leerfichero
	
	//escribe un String en un fichero del que se le pasa la dirección
	public static void escribirFichero(String cadena, String path) {
		FileWriter fw;
		try {
			
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
