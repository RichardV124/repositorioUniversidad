package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
 * Clase que reprenta un curso registrado por un estudiante.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@IdClass(RegistroCursoPK.class)
@Table(name="tb_registrocurso")
@NamedQueries({
@NamedQuery(name = RegistroCurso.CONSULTA_ESTUDIANTE,query = "SELECT regCur FROM RegistroCurso regCur WHERE regCur.estudiante.cedula=?1"),
@NamedQuery(name = RegistroCurso.CONSULTA_LISTA_ESTUDIANTE,query = "SELECT regCur FROM RegistroCurso regCur WHERE regCur.curso.codigo=?1"),
@NamedQuery(name = RegistroCurso.CONSULTA_REGISTRO_POR_ESTUDIANTE_CURSO, query ="SELECT reg FROM RegistroCurso reg WHERE reg.estudiante=?1 AND reg.curso=?2")
})
public class RegistroCurso implements Serializable {
	
	  public static final String CONSULTA_REGISTRO_POR_ESTUDIANTE_CURSO = "Re";
	    public static final String CONSULTA_ESTUDIANTE="RegistroCurso.listarPorEstudiante";
	    public static final String CONSULTA_LISTA_ESTUDIANTE = "RegistroCurso.listarEstudiantes";

	/**
	 * Estudiante que registro el curso.
	 */
	@Id
	@JoinColumn(name="cedula_est")
	@ManyToOne
	private Estudiante estudiante;

	/**
	 * Curso que registro el estudiante.
	 */
	@Id
	@JoinColumn(name="codigo_cur")
	@ManyToOne
	private Curso curso;

	/**
	 * Notas que el estudiante tiene registradas en este curso.
	 */
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="registroCurso")
	private List<Nota> notas;

	public RegistroCurso() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param estudiante
	 * @param curso
	 * @param notas
	 */
	public RegistroCurso(Estudiante estudiante, Curso curso, List<Nota> notas) {
		super();
		this.estudiante = estudiante;
		this.curso = curso;
		this.notas = notas;
	}

	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante
	 *            the estudiante to set
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the notas
	 */
	public List<Nota> getNotas() {
		return notas;
	}

	/**
	 * @param notas
	 *            the notas to set
	 */
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroCurso other = (RegistroCurso) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (estudiante == null) {
			if (other.estudiante != null)
				return false;
		} else if (!estudiante.equals(other.estudiante))
			return false;
		return true;
	}	
	
}
