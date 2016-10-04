package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;


public interface IDAOCurso {

	 
    /**
     * Metodo para crear un curso
     * @param curso, el curso que sera creado
     * @throws PersistenciaException 
     */
    public void crear (Curso curso) throws Exception;
    
    /**
     * Metodo para buscar un curso
     * @param codigo, el codigo del curso que se desea buscar
     * @return el curso si se encuentra 
     * @throws Exception 
     */
    public Curso buscar (String codigo) throws Exception;
    
    /**
     * Método para buscar un curso
     * @param codigo, codigo de la asignatura
     * @param cedula, cedula del docente
     * @return el curso si lo encuentra
     * @throws PersistenciaException 
     */
    public Curso buscar(String codigo, String cedula) throws Exception;
    
    /**
     * Metodo para editar un curso
     * @param curso el curso que sera editado
     * @throws PersistenciaException 
     */
    public void editar (Curso curso) throws Exception ;
    
    /**
     * Metodo para eliminar un curso
     * @param curso, el curso que sera eliminado
     * @throws PersistenciaException 
     */
    public void eliminar(Curso curso) throws Exception;
    
    /**
     * Metodo para poner los curso en una lista
     * @param codigo, el codigo del curso que se va a listar
     * @return la lista de los curso
     * @throws PersistenciaException
     */
    public List<Curso> listarCursoPorAsignatura(String codigo) throws Exception;
    
    /**
     * Método para listar los cursos de un docente
     * @param docente
     * @return 
     * @throws PersistenciaException 
     */
    public List<Curso> listarCursoPorDocente(Docente docente) throws Exception;

   
}
