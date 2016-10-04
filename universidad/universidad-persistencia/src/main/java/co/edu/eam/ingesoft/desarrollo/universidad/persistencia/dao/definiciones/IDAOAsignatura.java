package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;

public interface IDAOAsignatura {
	/**
	 * Permite crear una nueva asignatura
	 * @param asignatura Asignatura que se desea crear
	 * @throws Exception en caso de que falle la conexión
	 */
	public void crear(Asignatura asignatura) throws Exception;

	/**
	 * Permite editar una de las asignaturas creadas
	 * @param asignatura Asignatura que se desea editar
	 * @throws Exception en caso de que falle la conexión
	 */
	public void editar(Asignatura asignatura) throws Exception;

	/**
	 * Permite buscar una de las asignaturas registradas
	 * @param codigo código de la asignatura que se desea buscar
	 * @return la asignatura si la encuentra, de lo contrario null
	 * @throws Exception en caso de que falle la conexión
	 */
	public Asignatura buscar(String codigo) throws Exception;

	/**
	 * Permite eliminar un asignatura
	 * @param codigo código de la asignatura que se desea eliminar
	 * @throws Exception en caso de que falle la conexión
	 */
	public void eliminar(String codigo) throws Exception;

	
	/**
     * Método para listar todas las asignaturas
     * @throws Exception
     * @return la lista de todas las asignaturas
     */
    public List<Asignatura> listar() throws Exception;
}

