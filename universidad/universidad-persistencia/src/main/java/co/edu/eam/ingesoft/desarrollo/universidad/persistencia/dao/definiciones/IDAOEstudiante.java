/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.sql.SQLException;
import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;


/**
 * @author RICHARD VANEGAS
 *
 */
public interface IDAOEstudiante {

	/**
	 * Registrar un estudiante en la Base de datos
	 * 
	 * @param e, Estudiante a registrar           
	 * @throws SQLException
	 */
	public void crear(Estudiante estudiante) throws Exception;
	

	/**
	 * Edita un estudiante de la Base de datos
	 * 
	 * @param e, estudiante a editar
	 */
	public void editar(Estudiante estudiante)throws Exception;
	
	
	/**
	 * Elimina un Estudiante de la base de datos
	  @param cedula, cedula del estudiante a eliminar
	 */
	public void eliminar(String cedula) throws Exception;
	
	
	/**
	 * Busca un estudiante por la cedula en la Base de datos
	 * 
	 * @param cedula, cedula del estudiante a buscar  
	 * @return El estudiante si esta, en caso contrario null
	 */
	public Estudiante buscar(String cedula) throws Exception;
	
	public List<Estudiante> listarTodos() throws Exception;
	
}
