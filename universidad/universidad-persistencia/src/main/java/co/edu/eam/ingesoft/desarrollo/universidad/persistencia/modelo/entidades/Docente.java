package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Clase que presenta un Docente.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */

@Entity
@Table(name="tb_docente")
public class Docente extends Persona implements Serializable{
    
	@Column(name="postgrado_doc")
	private boolean postgrado;
	
	@ManyToOne
	@JoinColumn(name="profesion_doc")
	private Profesion profesion;

    public Docente(){

    }

	/**
	 * @param cedula
	 * @param apellido
	 * @param correo
	 * @param direccion
	 * @param nombre
	 * @param telefono
	 * @param postgrado
	 * @param profesion
	 */
	public Docente(String cedula, String apellido, String correo, String direccion, String nombre, String telefono,
			boolean postgrado, Profesion profesion) {
		super(cedula, apellido, correo, direccion, nombre, telefono);
		this.postgrado = postgrado;
		this.profesion = profesion;
	}

	public boolean isPostgrado() {
		return postgrado;
	}

	public void setPostgrado(boolean postgrado) {
		this.postgrado = postgrado;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}
    
    
    
    
    
    

}
