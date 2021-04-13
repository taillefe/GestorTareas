package modelo;


/**
 * 
 * @author Laura
 *	clase utilizada para manejar los datos del fichero
 */
public class Tarea {
	
	
	private String nombre;
	
	public Tarea(String nombre) {
		this.nombre = nombre;
		
	}

	public Tarea() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Tarea [nombre=" + nombre + "]";
	}

	
}
