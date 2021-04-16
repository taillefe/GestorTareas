package modelo;


/**
 * 
 * @author Laura
 *	clase utilizada para manejar los datos del fichero
 */
public class Tarea {
	
	//tiene dos atributos, un id y un nombre
	private int id;
	private String nombre;
	
	
	public Tarea(int id, String nombre) {
		
		this.id = id;
		this.nombre = nombre;
	}

	public Tarea() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", nombre=" + nombre + "]";
	}
	
	

	
	
}
