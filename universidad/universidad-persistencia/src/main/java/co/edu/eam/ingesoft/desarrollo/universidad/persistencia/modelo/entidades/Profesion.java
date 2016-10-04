package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * Clase que representa una profesion docente.
 * @author Camilo Andres Ferrer Butsos.
 *
 */
@Entity
@Table(name="tb_profesion")
public class Profesion implements Serializable{
	
	/**
	 * codigo de la profesion.
	 */
	@Id
	@Column(name="codigo_prof")
	private String codigo;
	/**
	 * Nombre de la profesion.
	 */
	@Column(name="nombre_prof", nullable=false)
	private String nombre;
	
	/**
	 * COnstructor.
	 */
	public Profesion() {
		super();
	}

	/**
	 * @param codigo
	 * @param nombre
	 */
	public Profesion(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
