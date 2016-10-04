package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;

public class RegistroCursoPK implements Serializable {

	private String estudiante;
	
	private String curso;
	
	public RegistroCursoPK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cedulaEstudiante
	 * @param codigoCurso
	 */
	public RegistroCursoPK(String cedulaEstudiante, String codigoCurso) {
		super();
		this.estudiante = cedulaEstudiante;
		this.curso = codigoCurso;
	}

	/**
	 * @return the cedulaEstudiante
	 */
	public String getCedulaEstudiante() {
		return estudiante;
	}

	/**
	 * @param cedulaEstudiante the cedulaEstudiante to set
	 */
	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.estudiante = cedulaEstudiante;
	}

	/**
	 * @return the codigoCurso
	 */
	public String getCodigoCurso() {
		return curso;
	}

	/**
	 * @param codigoCurso the codigoCurso to set
	 */
	public void setCodigoCurso(String codigoCurso) {
		this.curso = codigoCurso;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
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
		RegistroCursoPK other = (RegistroCursoPK) obj;
		if (estudiante == null) {
			if (other.estudiante != null)
				return false;
		} else if (!estudiante.equals(other.estudiante))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		return true;
	}
	
	
	
}
