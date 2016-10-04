package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(FallaPK.class)
@Table(name="tb_falla")
public class Falla implements Serializable {

	@Id
	@Column(name="id_falla")
	private int codigo;
	
	@Column(name="numero_fallas", nullable=false)
	private int numeroFallas;
	
	@Id
	@JoinColumns({
		@JoinColumn(name="cedula_est", referencedColumnName="cedula_est", nullable=false),
		@JoinColumn(name="codigo_cur", referencedColumnName="codigo_cur", nullable=false)
	})
	@ManyToOne
	private RegistroCurso codigoCurso;
	
	public Falla() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codigo
	 * @param numeroFallas
	 * @param codigoCurso
	 */
	public Falla(int codigo, int numeroFallas, RegistroCurso codigoCurso) {
		super();
		this.codigo = codigo;
		this.numeroFallas = numeroFallas;
		this.codigoCurso = codigoCurso;
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
	 * @return the numeroFallas
	 */
	public int getNumeroFallas() {
		return numeroFallas;
	}

	/**
	 * @param numeroFallas the numeroFallas to set
	 */
	public void setNumeroFallas(int numeroFallas) {
		this.numeroFallas = numeroFallas;
	}

	/**
	 * @return the codigoCurso
	 */
	public RegistroCurso getCodigoCurso() {
		return codigoCurso;
	}

	/**
	 * @param codigoCurso the codigoCurso to set
	 */
	public void setCodigoCurso(RegistroCurso codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	
	
	
}
