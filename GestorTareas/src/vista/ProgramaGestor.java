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
		
		//se cargan las tareas en el ArrayList
		tareas = ProcesadorTareas.cargarTareas(rutaFichero);
		
		//se hace un listado de las tareas cargadas
		ProcesadorTareas.listarTareas(tareas);
		
		//menu de la aplicaci�n con las opciones
		boolean salir = false;
	   
		
		
        Scanner sn = new Scanner(System.in);
       
        while (!salir) {
        	 int opcion = menu(); //opcion del usuario
        	
 
 
                switch (opcion) {
                    case 1:
                    	//solicita nueva tarea por pantalla
                    	 entradaCrearNuevaTarea(tareas);
                         break;
                    case 2:
                       ProcesadorTareas.listarTareas(tareas);
                        break;
                    case 3:
                        // solicita posicion de la tarea que se quiere borrar
                    	entradaBorrarTareaPorPosicion(tareas);
                    	break;
                    case 4:
                        // guarda las tareas del ArrayList en el fichero
                    	ProcesadorTareas.guardarTareas(tareas, rutaFichero);;
                        break;
                    case 5: //salir
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo n�meros entre 1 y 5");
                }
            
        }
 
    }
	
	
	public static int menu() {
	
		int opcion = 0;
	 	Scanner sn = new Scanner(System.in);
	   
	   
	    System.out.println("\r===============================");
		System.out.println("       GESTOR DE TAREAS");
		 System.out.println("===============================");
	 
	            System.out.println	("1. Crear Nueva Tarea");
	    System.out.println	("2. Listar Tareas");
	    System.out.println	("3. Borrar Tarea por posici�n");
	    System.out.println	("4. Guardar Tareas en el fichero");
	    System.out.println	("5. Salir");
	    System.out.println("===============================\r");
	    try {
	    	 
	        //System.out.println("Escoge una opci�n");
	          opcion = sn.nextInt();
	          
	    } catch (InputMismatchException e) {
	        System.out.println("Debes insertar un n�mero");
	        sn.next();
	    }
		
	    return opcion;
	}
	
	public static void entradaBorrarTareaPorPosicion(ArrayList<Tarea> ltareas) {
		  // solicitamos posicion de la tarea que se quiere borrar
    	int p = 0;
    	boolean posExiste = false;
    	// el numero debe ser v�lido, debe estar entre 0 y
    	// tareas.size()-1
    	Scanner sp =new Scanner (System.in);
    	while (!posExiste) {
    		System.out.println("\rPosici�n a borrar: \r");
    		p = sp.nextInt();
    		if (p >0 && p <= ltareas.size()) {
    			posExiste = true;
    			ProcesadorTareas.borrarTareaPorPosicion(ltareas,p-1);
    		}else
    			posExiste = false;
    		
    	}
	}
 
	public static void entradaCrearNuevaTarea(ArrayList<Tarea> ltareas) {
		 // solicitamos entrada por pantalla de la nueva tarea
		// se admite cualquier tipo de caracter
  	  	Scanner st =new Scanner (System.in);
  	  	
  		System.out.println("\rNueva Tarea: \r");
  		
  					
  		Tarea t = new Tarea(st.nextLine());
        //se a�ade al final del ArrayList tareas
        ProcesadorTareas.crearNuevaTarea(ltareas,t);
  			
  		
	}
}
