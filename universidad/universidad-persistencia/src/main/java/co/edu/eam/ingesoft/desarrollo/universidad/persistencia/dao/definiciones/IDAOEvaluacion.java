package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;

public interface IDAOEvaluacion {

	 /**
     * Metodo para crear un evaluacion
     * @param evaluacion, el evaluacion que sera creado
     * @throws Exception 
     */
    public void crear (Evaluacion evaluacion) throws Exception;
    
    /**
     * Metodo para buscar un evaluacion
     * @param codigo, el codigo del evaluacion que se desea buscar
     * @return el evaluacion si se encuentra 
     * @throws Exception 
     */
    public Evaluacion buscar (int codigo) throws Exception;
    
        
    /**
     * Metodo para editar un evaluacion
     * @param evaluacion el evaluacion que sera editado
     * @throws Exception 
     */
    public void editar (Evaluacion evaluacion) throws Exception ;
    
    /**
     * Metodo para eliminar un evaluacion
     * @param evaluacion, el evaluacion que sera eliminado
     * @throws Exception 
     */
    public void eliminar(Evaluacion evaluacion) throws Exception;
    
    /**
     * Método para listar evaluacion según un curso
     * @param curso, el curso del cual se listarán las evaluaciones
     * @return la lista de evaluaciones del curso
     * @throws Exception 
     */
    public List<Evaluacion> listarPorCurso(Curso curso) throws Exception;
    
}
	

