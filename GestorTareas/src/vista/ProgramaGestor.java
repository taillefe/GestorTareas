package vista;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import controlador.ProcesadorTareas;
import modelo.Tarea;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ProgramaGestor {

	public static void main(String[] args) {
		//Ruta del fichero
		String rutaFichero=".//Fichero//data.txt";
		
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		
		tareas = ProcesadorTareas.cargarTareas(rutaFichero);
	 
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //opcion del usuario
 
        while (!salir) {
        	System.out.println("\rGestor de Tareas\r");
 
            System.out.println("1. Crear Nueva Tarea");
            System.out.println("2. Listar Tareas");
            System.out.println("3. Borrar Tarea por posición");
            System.out.println("4. Guardar Tareas en el fichero");
            System.out.println("5. Salir");
 
            try {
 
             //   System.out.println("Escoge una opción");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                    	//solicitamos nueva tarea por pantalla
                    	Tarea t = new Tarea();
                    	//se añade al final del ArrayList tareas
                    	tareas = ProcesadorTareas.crearNuevaTarea(t);
                         break;
                    case 2:
                       ProcesadorTareas.listarTareas(tareas);
                        break;
                    case 3:
                        // solicitamos posicion de la tarea que se quiere borrar
                    	int p = 0;
                    	tareas = ProcesadorTareas.borrarTareaPorPosicion(tareas, p);
                        break;
                    case 4:
                        // guarda las tareas del ArrayList en el fichero
                    	ProcesadorTareas.guardarTareas(tareas, rutaFichero);;
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
 

}
