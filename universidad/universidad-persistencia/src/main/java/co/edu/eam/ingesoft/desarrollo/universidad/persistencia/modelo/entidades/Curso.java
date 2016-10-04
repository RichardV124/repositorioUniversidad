package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa a un curso.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */

@Entity
@Table(name="tb_curso")
@NamedQueries({
    @NamedQuery(name = Curso.CONSULTA_ASIGNATURA, query = "SELECT cur FROM Curso cur where cur.asignatura.codigo=?1"),
    @NamedQuery(name = Curso.CONSULTA_DOC_ASIG, query = "SELECT cur FROM Curso cur WHERE cur.docente.cedula=?1 AND cur.asignatura.codigo=?2"),
    @NamedQuery(name = Curso.CONSULTAR_LISTAR_POR_DOCENTE, query = "SELECT cur FROM Curso cur WHERE cur.docente.cedula=?1")
})
public class Curso implements Serializable {

	public static final String CONSULTA_DOC_ASIG = "Curso.buscarCurso";
    public static final String CONSULTA_ASIGNATURA = "Curso.listarPorAsignatura";
    public static final String CONSULTAR_LISTAR_POR_DOCENTE = "Curso.listarPorDocente";

	
	/**
	 * Codigo del curso. el codigo se forma con el codigo de la
	 * asignatura semestre del año (I o II)
	 */
	@Id
	@Column(name="codigo_curso")
	private String codigo;

	/**
	 * Docente que imparte la asignatura.
	 */
	
	@JoinColumn(name="cedula_docente", nullable=false)
	@ManyToOne
	private Docente docente;

	/**
	 * Asignatura de este curso.
	 */
	@JoinColumn(name="codigo_asignatura", nullable=false)
	@ManyToOne
	private Asignatura asignatura;

	/**
	 * Sesiones del curso. las sesiones son los dias en que los estudiantes y el
	 * profesor se encuentran para la clase.
	 */
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="curso")
	private List<SesionCurso> sesiones;
	
	/**
	 * Estudiantes registrados en este curso.
	 */
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="curso")
	private List<RegistroCurso> estudiantes;
	
	/**
	 * Evaluaciones del curso.
	 */
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="curso")
	private List<Evaluacion> evaluaciones;
	
	/**
	 * Constructor.
	 */
	public Curso() {
		super();
	}
	

	/**
	 * @param codigo
	 * @param cedulaDocente
	 * @param asignatura
	 * @param sesiones
	 * @param estudiantes
	 * @param evaluaciones
	 */
	public Curso(String codigo, Docente cedulaDocente, Asignatura asignatura) {
		super();
		this.codigo = codigo;
		this.docente = cedulaDocente;
		this.asignatura = asignatura;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	/**
	 * @return the cedulaDocente
	 */
	public Docente getDocente() {
		return docente;
	}

	/**
	 * @param cedulaDocente the cedulaDocente to set
	 */
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	/**
	 * @return the asignatura
	 */
	public Asignatura getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura
	 *            the asignatura to set
	 */
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	/**
	 * @return the sesiones
	 */
	public List<SesionCurso> getSesiones() {
		return sesiones;
	}

	/**
	 * @param sesiones the sesiones to set
	 */
	public void setSesiones(List<SesionCurso> sesiones) {
		this.sesiones = sesiones;
	}

	/**
	 * @return the estudiantes
	 */
	public List<RegistroCurso> getEstudiantes() {
		return estudiantes;
	}

	/**
	 * @param estudiantes the estudiantes to set
	 */
	public void setEstudiantes(List<RegistroCurso> estudiantes) {
		this.estudiantes = estudiantes;
	}

	/**
	 * @return the evaluaciones
	 */
	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	/**
	 * @param evaluaciones the evaluaciones to set
	 */
	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((docente == null) ? 0 : docente.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (docente == null) {
			if (other.docente != null)
				return false;
		} else if (!docente.equals(other.docente))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return codigo;
	}

	
	
}
