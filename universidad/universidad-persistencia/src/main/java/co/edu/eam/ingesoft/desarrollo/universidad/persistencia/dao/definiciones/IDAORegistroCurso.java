package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public interface IDAORegistroCurso {

	/**
	 * M�todo para listar RegistroCurso por estudiante
	 * 
	 * @param cedula, la c�dula del estudiante
	 * @return la lista de los registro curso del estudiante
	 * @throws Exception
	 */
	public List<RegistroCurso> listarPorEstudiante(String cedula) throws Exception;

	/**
	 * M�todo para listar RegistroCurso por el curso
	 * 
	 * @param codigo, el c�digo del curso
	 * @return la lista de los regisro curso del curso
	 * @throws Exception
	 */
	public List<RegistroCurso> listarPorCodigoCurso(String codigo) throws Exception;

	/**
	 * M�todo para crear un RegistroCurso
	 * 
	 * @param registroCurso, el registrocurso que se quiere crear
	 * @throws Exception
	 */
	public void crear(RegistroCurso registroCurso) throws Exception;

	/**
	 * M�todo para eliminar un RegistroCurso
	 * 
	 * @param registroCurso
	 * @throws Exception
	 */
	public void eliminar(RegistroCurso registroCurso) throws Exception;

	/**
	 * M�todo para buscar un registro curso por estudiante y curso
	 * 
	 * @param estudiante,
	 *            el estudiante del registro
	 * @param curso,
	 *            el curso del registro
	 * @return el registro curso si existe, de lo contrario null
	 * @throws Exception
	 */
	public RegistroCurso buscarRegistroCurso(Estudiante estudiante, Curso curso) throws Exception;

}
