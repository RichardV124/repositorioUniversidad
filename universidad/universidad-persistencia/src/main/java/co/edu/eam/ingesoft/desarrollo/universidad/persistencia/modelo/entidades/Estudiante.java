/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa un estudiante.
 * 
 * @author LuchoBolivar
 * 
 */
@Entity
@Table(name = "tb_Estudiante")
public class Estudiante extends Persona implements Serializable{
	
	
    @Column(name="fechanacimiento_est",nullable=false )
    @Temporal(TemporalType.DATE)
	private Date fechaNacimiento;


	/**
	 * 
	 */
	public Estudiante() {

	}

	/**
	 * @param cedula
	 * @param apellido
	 * @param correo
	 * @param direccion
	 * @param nombre
	 * @param telefono
	 * @param fechaNacimiento
	 * @param cedula2
	 */
	public Estudiante(String cedula, String apellido, String correo, String direccion, String nombre, String telefono,
			Date fechaNacimiento) {
		super(cedula, apellido, correo, direccion, nombre, telefono);
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	

}
