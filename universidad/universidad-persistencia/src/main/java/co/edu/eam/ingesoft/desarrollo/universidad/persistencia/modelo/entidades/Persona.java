package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="tb_persona")
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona implements Serializable {
	
	@Column(name="cedula_per",nullable=false)
	@Id
	protected String cedula;
	
	@Column(name="apellido_per")
	protected String apellido;
	
	@Column(name="correo_per")
	protected String correo;
	
	@Column(name="direccion_per")
	protected String direccion;
	
	@Column(name="nombre_per")
	protected String nombre;
	
	@Column(name="telefono_per")
	protected String telefono;
	
	public Persona (){
		
	}
	

	/**
	 * @param cedula
	 * @param apellido
	 * @param correo
	 * @param direccion
	 * @param nombre
	 * @param telefono
	 */
	public Persona(String cedula, String apellido, String correo, String direccion, String nombre, String telefono) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.correo = correo;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
	}



	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	

}
