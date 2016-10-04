package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Profesion;

public interface IDAOProfesion {
	
	/**
	 * Método para buscar una profesión
	 * 
	 * @param codigo,
	 *            código para buscar la profesión
	 * @return la profesion si la encuentra, de lo contrario null
	 */
	public Profesion buscar(String codigo) throws Exception;

	/**
	 * Método para listar todas las profesiones
	 * 
	 * @throws PersistenciaException
	 * @return la lista de todas las profesiones
	 */
	public List<Profesion> listar() throws Exception;

}
