package vista;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import controlador.GestionFicheros;
import controlador.ProcesadorTareas;
import modelo.Tarea;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ProgramaGestor {
	
	

	public static void main(String[] args) { 
		
				
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		
		//se cargan las tareas en el ArrayList
		tareas = ProcesadorTareas.cargarTareas(GestionFicheros.RUTA_FICHERO);
		
		//se hace un listado de las tareas cargadas y se muestra por pantalla
		ProcesadorTareas.listarTareas(tareas);
		
		//se muestran las opciones del menu
		VistaTareas.MostrarMenu(tareas);
		
    }
	
	
	
}
