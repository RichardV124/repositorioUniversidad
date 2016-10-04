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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa una calificacion de una evaluacion de un curso.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@Table(name = "tb_nota")
@NamedQueries({
		@NamedQuery(name = Nota.CONSULTAR_NOTAS_REGISTRO_EVALUACION, query = "SELECT nota FROM Nota nota WHERE nota.registroCurso=?1 AND nota.evaluacion=?2"),
		@NamedQuery(name = Nota.CONSULTAR_NOTAS_REGISTROCURSO, query = "SELECT nota FROM Nota nota WHERE nota.registroCurso=?1"),
		@NamedQuery(name = Nota.CONSULTAR_NOTAS_EVALUACIONES, query = "SELECT nota FROM Nota nota WHERE nota.evaluacion=?1") })
public class Nota implements Serializable {

	public static final String CONSULTAR_NOTAS_EVALUACIONES = "Nota.listaNotasEvaluaciones";
	public static final String CONSULTAR_NOTAS_REGISTROCURSO = "Nota.listaNotasRegistrocurso";
	public static final String CONSULTAR_NOTAS_REGISTRO_EVALUACION = "Nota.listaNotaRegistroEvaluacion";
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigoNota;

	@JoinColumns({ @JoinColumn(name = "cedula_est", referencedColumnName = "cedula_est", nullable = false),
			@JoinColumn(name = "codigo_cur", referencedColumnName = "codigo_cur", nullable = false) })
	@ManyToOne
	private RegistroCurso registroCurso;

	/**
	 * Evaluacion a la que pertenece esta nota.
	 */
	@JoinColumn(name = "id_evaluacion")
	@ManyToOne
	private Evaluacion evaluacion;

	/**
	 * Nota que puso el profesor.
	 */
	@Column(name = "valor_nota", nullable = false)
	private double valor;

	/**
	 * bandera que indica si la nota ya fue modificada para no dejar que lo sea
	 * una vez mas.
	 */
	@Column(name = "editada_nota", nullable = false)
	private boolean editada;

	/**
	 * Constructor
	 */
	public Nota() {
		super();
	}

	/**
	 * @param codigoNota
	 * @param registroCurso
	 * @param evaluacion
	 * @param valor
	 * @param editada
	 */
	public Nota(RegistroCurso registroCurso, Evaluacion evaluacion, double valor, boolean editada) {
		super();
		this.registroCurso = registroCurso;
		this.evaluacion = evaluacion;
		this.valor = valor;
		this.editada = editada;
	}

	/**
	 * @return the codigoNota
	 */
	public int getCodigoNota() {
		return codigoNota;
	}

	/**
	 * @param codigoNota
	 *            the codigoNota to set
	 */
	public void setCodigoNota(int codigoNota) {
		this.codigoNota = codigoNota;
	}

	/**
	 * @return the cedulaEstudiante
	 */
	public RegistroCurso getRegistroCurso() {
		return registroCurso;
	}

	/**
	 * @param registroCurso
	 *            the cedulaEstudiante to set
	 */
	public void setRegistroCurso(RegistroCurso registroCurso) {
		this.registroCurso = registroCurso;
	}

	/**
	 * @return the evaluacion
	 */
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	/**
	 * @param evaluacion
	 *            the evaluacion to set
	 */
	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the editada
	 */
	public boolean isEditada() {
		return editada;
	}

	/**
	 * @param editada
	 *            the editada to set
	 */
	public void setEditada(boolean editada) {
		this.editada = editada;
	}

}
