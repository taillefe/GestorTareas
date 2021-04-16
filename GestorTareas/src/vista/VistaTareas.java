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
	                	
	                	//pasamos como parametro el id automaticamente
	                	// leemos el id de la ultima tarea y le sumamos 1
	                	int  ultimoId = tareas.get(tareas.size()-1).getId();
	                	Tarea tarCrear = entradaTarea(ultimoId + 1);
	                	
	                	//se añade al final del ArrayList tareas
	                    ProcesadorTareas.crearNuevaTarea(tareas,tarCrear);
	                    break;
	                case 2: //lista las tareas en memoria
	                   ProcesadorTareas.listarTareas(tareas);
	                    break;
	                case 3:
	                    // solicita posicion de la tarea que se quiere borrar
	                	// devuelve el valor del id de la Tarea
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
	                	System.out.println("\rModifica Tarea num: "+ pos);
	                	
	                	// pasamos como parametro el id interno de la tarea
	                	// que vamos a modificar para que este no se modifique
	                	int id = tareas.get(posModificar).getId();
	                	Tarea tarModificar = entradaTarea(id);
	                	ProcesadorTareas.modificarTareaPorPosicion(tareas,posModificar,tarModificar);
	                    break;
	               
	                case 5: //salir
	                    salir = true;
	                    break;
	                case 0:
	                	opcionesMenu();
	                	break;
	                default:
	                    System.out.println("Solo números entre 0 y 5");
	            }
	            
	    }
	    // guarda automaticamente las tareas del ArrayList en el fichero
	    // cuando el usuario sale de la aplicacion
    	ProcesadorTareas.guardarTareas(tareas, GestionFicheros.RUTA_FICHERO);
        
    }


public static void opcionesMenu() {
   
    System.out.println("\r===============================");
	System.out.println("       GESTOR DE TAREAS");
	System.out.println("===============================");
    System.out.println	("1. Crear Nueva Tarea");
    System.out.println	("2. Listar Tareas");
    System.out.println	("3. Borrar Tarea por posición");
    System.out.println	("4. Modificar Tarea por posición");
    System.out.println	("5. Salir");
    System.out.println("===============================");
    System.out.println("Pulsa 0 para volver a ver el menu");
}


public static Tarea entradaTarea(int id) {
	 // solicitamos entrada por pantalla de la nueva tarea
	// se admite cualquier tipo de caracter
	  	Scanner st =new Scanner (System.in);
	  	
		// como id se le pasa el siguiente libre automaticamente
	  	// se ha pasado por parametro
		Tarea t = new Tarea(id, st.nextLine());
   return t;
	
}


//solicita posicion de la tarea y devuelve el numero del indice de la tarea
// en el ArrayList de Tareas
public static int solicitarPosicion(ArrayList<Tarea> ltareas) {
	  // solicitamos posicion de la tarea que se quiere borrar
	int p = 0;
	boolean posExiste = false;
	// el numero debe ser válido, debe estar entre 1 y
	// el mayor id de Tarea
	// calculo del mayor id de las tareas guardadas
	// debe ser el ultimo porque siempre están ordenadas
	// id de la ultima posicion del ArrayList
//	int mayorId = ltareas.get(ltareas.size()-1).getId();
//	System.out.println("mayorId : "+ mayorId);
	Scanner sp =new Scanner (System.in);
	while (!posExiste) {
		
		p = sp.nextInt();
		if (p >0 && p <= ltareas.size()) {
			posExiste = true;
			
		}else {
			posExiste = false;
			System.out.println("introducir posicion correcta");
		}
	}
	// devuelve la posicion dentro del ArrayList
	return p-1;
}

}
