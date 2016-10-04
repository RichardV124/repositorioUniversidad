package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Nota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public interface IDAONota {
	 /**
     * Metodo para crear un nota
     * @param nota, el curso que sera creado
     * @throws Exception 
     */
    public void crear (Nota nota) throws Exception;
    
    /**
     * Metodo para buscar un nota
     * @param codigo, el codigo del nota que se desea buscar
     * @return el nota si se encuentra 
     * @throws Exception 
     */
    public Nota buscar (String codigo) throws Exception;
    
        
    /**
     * Metodo para editar un nota
     * @param nota el nota que sera editado
     * @throws Exception 
     */
    public void editar (Nota nota) throws Exception ;
    
    /**
     * Metodo para eliminar un nota
     * @param nota, el nota que sera eliminado
     * @throws Exception 
     */
    public void eliminar(Nota nota) throws Exception;
    
    /**
     * Método para buscar una nota
     * @param registro, el registro de la nota
     * @param eval, la evaluación de la nota
     * @return la nota si la encuentra, de lo contrario null
     * @throws Exception 
     */
    public Nota buscarPorCursoEvaluacion(RegistroCurso registro, Evaluacion eval) throws Exception;
    
    /**
     * Método para listar notas
     * @param estudiante, el estudiante de las notas a listar
     * @return la lista de notas
     * @throws Exception 
     */
    public List<Nota> listarPorEstudiante(Estudiante estudiante) throws Exception;
    
    /**
     * Método para listar notas
     * @param registro, el registro curso de las notas a listar
     * @return la lista de notas
     * @throws Exception 
     */
    public List<Nota> listarPorRegistroCurso(RegistroCurso registro) throws Exception;
     
    /**
     * Método para buscar una nota por evaluacion
     * @param eval, la evaluacion a la que se le bsuca la nota
     * @return la nota
     * @throws Exception 
     */
    public Nota buscarPorEvaluacion(Evaluacion eval) throws Exception;
    
}
