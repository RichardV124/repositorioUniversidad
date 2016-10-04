/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Profesion;

/**
 * @author RICHARD VANEGAS
 *
 */
public interface IDAODocente {
	
	/**
	 * Registrar un docente en la Base de datos
	 * 
	 * @param docente, Docente a registrar           
	 */
	public void crear(Docente docente) throws Exception;
	
	
	/**
     * Edita un docente en la Base de datos
     *
     * @param d , docente que se va a editar
	 * @throws Exception 
     */
	public void editar(Docente docente)throws Exception;
	
	
	/**
	 * Elimina un docente de la base de datos
	  @param cedula, cedula del docente a eliminar 
	 * @throws SQLException 
	 */
	public void eliminar(String cedula) throws Exception;
	
	
	/**
	 * Busca un docente en la base de datos
	  @param cedula, cedula del docente a buscar
	  @return Docente, el docente que se encontro en la busqueda; o null si el docente no es encontrado 
	 */
	public Docente buscar(String cedula) throws Exception;
	
	
	
	public List<Docente> listarTodos() throws Exception;
	
	
	/**
	 * Crea una lista(ArrayList) con las profesiones registradas en la base de datos
	 @return listar, lista de profesiones
	 */
	public ArrayList<Profesion> listarProfesion() throws Exception;
	
}
