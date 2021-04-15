package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controlador.GestionFicheros;
import controlador.ProcesadorTareas;
import modelo.Tarea;

public class VistaTareas  {
	
	
	public static void MostrarMenu(ArrayList<Tarea> tareas) {
		

		int posModificar; 
		int posBorrar;
		
		
		//menu de la aplicación con las opciones
		boolean salir = false;
		int opcion = 0;
	 	Scanner sn = new Scanner(System.in);
	
		opcionesMenu();
		  //opcion del usuario
	    while (!salir) {
	    	
	    	
	    	try {
	       	 
	            //System.out.println("Escoge una opción");
	              opcion = sn.nextInt();
	              
	        } catch (InputMismatchException e) {
	            System.out.println("Debes insertar un número");
	            sn.next();
	        }
     	    		
	            switch (opcion) {
	                case 1:
	                	//solicita nueva tarea por pantalla
	                	System.out.println("\rIntroduce Nueva Tarea: \r");
	                	Tarea tarCrear = entradaTarea();
	                	//se añade al final del ArrayList tareas
	                    ProcesadorTareas.crearNuevaTarea(tareas,tarCrear);
	                    break;
	                case 2:
	                   ProcesadorTareas.listarTareas(tareas);
	                    break;
	                case 3:
	                    // solicita posicion de la tarea que se quiere borrar
	                	// devuelve la posicion de la tarea en el ArrayList
	                	System.out.println("\rIndica num de Tarea a Borrar ");
	                	posBorrar = solicitarPosicion(tareas);
	                	ProcesadorTareas.borrarTareaPorPosicion(tareas,posBorrar);
	                	break;
	                case 4:
	                    // solicita posicion de la tarea que se quiere modificar
	                	System.out.println("\rIndica num de Tarea a Modificar ");
	                	posModificar = solicitarPosicion(tareas);
	                	//solicita entrada del nuevo texto para esa tarea
	                	int pos = posModificar + 1;
	                	System.out.println("\rModifica Tarea num: "+pos);
	                	Tarea tarModificar = entradaTarea();
	                	ProcesadorTareas.modificarTareaPorPosicion(tareas,posModificar,tarModificar);
	                    break;
	                case 5:
	                    // guarda las tareas del ArrayList en el fichero
	                	ProcesadorTareas.guardarTareas(tareas, GestionFicheros.RUTA_FICHERO);
	                	
	                    break;
	                case 6: //salir
	                    salir = true;
	                    break;
	                case 0:
	                	opcionesMenu();
	                	break;
	                default:
	                    System.out.println("Solo números entre 0 y 6");
	            }
	    }
        
    }




public static void opcionesMenu() {

	
   
   
    System.out.println("\r===============================");
	System.out.println("       GESTOR DE TAREAS");
	System.out.println("===============================");
    System.out.println	("1. Crear Nueva Tarea");
    System.out.println	("2. Listar Tareas");
    System.out.println	("3. Borrar Tarea por posición");
    System.out.println	("4. Modificar Tarea por posición");
    System.out.println	("5. Guardar Tareas en el fichero");
    System.out.println	("6. Salir");
    System.out.println("===============================\r");
    System.out.println("Pulsa 0 para volver a ver el menu");
}


public static Tarea entradaTarea() {
	 // solicitamos entrada por pantalla de la nueva tarea
	// se admite cualquier tipo de caracter
	  	Scanner st =new Scanner (System.in);
					
		Tarea t = new Tarea(st.nextLine());
   return t;
	
}


//solicita posicion de la tarea y devuelve el numero del indice de la tarea
// en el ArrayList de Tareas
public static int solicitarPosicion(ArrayList<Tarea> ltareas) {
	  // solicitamos posicion de la tarea que se quiere borrar
	int p = 0;
	boolean posExiste = false;
	// el numero debe ser válido, debe estar entre 1 y
	// tareas.size()
	Scanner sp =new Scanner (System.in);
	while (!posExiste) {
		
		p = sp.nextInt();
		if (p >0 && p <= ltareas.size()) {
			posExiste = true;
			
		}else
			posExiste = false;
	}
	// devuelve la posicion dentro del ArrayList
	return p-1;
}

}
