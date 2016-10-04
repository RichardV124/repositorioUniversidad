/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa la evaluacion de un curso.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@Table(name="tb_evaluacion")
@NamedQueries(
        {@NamedQuery(name = Evaluacion.LISTAR_EVALUACIONES_POR_CURSO, query = "SELECT eval FROM Evaluacion eval WHERE eval.curso.codigo=?1")
        })
public class Evaluacion implements Serializable{

	public static final String LISTAR_EVALUACIONES_POR_CURSO="Evaluacion.listarEvaluacionesPorCurso";
    
	
	@Id
	@Column(name="ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	/**
	 * Curso al que pertenece esta evaluacion.
	 */
	@JoinColumn(name="codigo_cur", nullable=false)
	@ManyToOne
	private Curso curso;

	/**
	 * Nombre de la evaluacion;
	 */
	@Column(name="nombre_eval", nullable=false)
	private String nombre;

	/**
	 * Porcentaje que vale esta evaluacion dentro del curso.
	 */
	@Column(name="porcentaje_eval", nullable=false)
	private double porcentaje;

	/**
	 * Constructor.
	 */
	public Evaluacion() {
		super();
	}



	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}



	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	/**
	 * @param codigo
	 * @param curso
	 * @param nombre
	 * @param porcentaje
	 */
	public Evaluacion(Curso curso, String nombre, double porcentaje) {
		super();
		this.curso = curso;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}



	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
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

	/**
	 * @return the porcentaje
	 */
	public double getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}



	@Override
	public String toString() {
		return nombre;
	}
	
	

	
	
}
