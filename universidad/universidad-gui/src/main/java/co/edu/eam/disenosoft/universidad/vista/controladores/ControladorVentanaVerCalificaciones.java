package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOEvaluacion;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BONota;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Nota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public class ControladorVentanaVerCalificaciones {

	  
    /**
     * bo con la lógica de asignatura
     */
    private BOAsignatura boAsignatura;

    /**
     * bo con la lógica de curso
     */
    private BOCurso boCurso;
    
    /**
     * bo con la lógica de registro curso
     */
    private BORegistroCurso boRegistroCurso;
    
    /**
     * bo con la lógica de la evaluacion
     */
    private BOEvaluacion boEvaluacion;
    
    /**
     * bo con la lógica de nota
     */
    private BONota boNota;
    
    /**
     * Constructor
     */
    public ControladorVentanaVerCalificaciones() {
        boAsignatura = new BOAsignatura();
        boCurso = new BOCurso();
        boRegistroCurso = new BORegistroCurso();
        boEvaluacion = new BOEvaluacion();
        boNota = new BONota();
    }
    
    /**
     * Método para buscar una asignatura
     * @param codigo, el código para buscar la asignatura
     * @return la asignatura si la encuentra, de lo contrario null
     * @throws Exception 
     */
    public Asignatura buscarAsignatura(String codigo) throws Exception{
        return boAsignatura.buscar(codigo);
    }
    
    /**
     * Método para listar cursos de una asignatura
     * @param asignatura, la asignatura a la que se le van a buscar los cursos
     * @return la lista con los cursos de la asignatura
     * @throws Exception 
     */
    public List<Curso> buscarCursoPorAsignatura(Asignatura asignatura) throws Exception{
        return boCurso.listarCursoPorAsignatura(asignatura);
    }
    
    /**
     * Método para listar los registros de un curso
     * @param curso, el curso al que se le van a buscar los registros
     * @return la lista de registros
     * @throws Exception 
     */
    public List<RegistroCurso> listarRegistrosPorCurso(Curso curso) throws Exception{
        return boRegistroCurso.listarRegistrosPorCurso(curso);
    }
    
    /**
     * Método para listar evaluaciones de un curso
     * @param curso, el curso al que se le van a listar las evaluaciones
     * @return una lista con las evaluaciones
     * @throws Exception 
     */
    public List<Evaluacion> listarEvaluacionPorCurso(Curso curso) throws Exception{
        return boEvaluacion.listarEvaluacionPorCurso(curso);
    }
    
    /**
     * Método para buscar la nota de una evaluación
     * @param eval, la evaluacion a la que se le va a buscar la nota
     * @return la nota si existe, de lo contrario null
     * @throws Exception 
     */
    public Nota buscarNotaEvaluacion(Evaluacion eval) throws Exception{
        return boNota.buscarNotasEvaluacion(eval);
    }
    
	
}
