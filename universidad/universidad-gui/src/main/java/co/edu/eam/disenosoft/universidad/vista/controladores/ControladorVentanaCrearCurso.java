package co.edu.eam.disenosoft.universidad.vista.controladores;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;

public class ControladorVentanaCrearCurso {

	/**
	 * BO con la lógica para curso
	 */
	private BOCurso boCurso;

	/**
	 * Constructor
	 */
	public ControladorVentanaCrearCurso() {

		boCurso = new BOCurso();
	}

	/**
	 * Método para crear un curso
	 * @param curso, el curso que se desea crear
	 * @throws Exception
	 */
	public void crearCurso(Curso curso) throws Exception {
		boCurso.crear(curso);
	}

	/**
     * Método para buscar un curso
     * @param asignatura, asignatura del curso
     * @param docente, docente del curso
     * @return el curso si lo encuentra, de lo contrario null
     * @throws Exception 
     */
	public Curso buscarCurso(Asignatura asignatura, Docente docente) throws Exception {
		return boCurso.buscar(asignatura.getCodigo(), docente.getCedula());
	}

	/**
     * Método para editar un curso
     * @param curso, el curso que se desea editar
     * @throws Exception 
     */
	public void editarCurso(Curso curso) throws Exception {
		boCurso.editar(curso);
	}

}
