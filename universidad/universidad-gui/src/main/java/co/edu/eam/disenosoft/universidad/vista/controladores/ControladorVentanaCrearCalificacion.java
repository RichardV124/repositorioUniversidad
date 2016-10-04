package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOEvaluacion;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BONota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Nota;

public class ControladorVentanaCrearCalificacion {

	  private BOCurso boCurso;
	    private BOAsignatura boAsignatura;
	    private BOEvaluacion boEvaluacion;
	    private BONota boNota;

	    public ControladorVentanaCrearCalificacion() {
	        boCurso = new BOCurso();
	        boAsignatura = new BOAsignatura();
	        boEvaluacion = new BOEvaluacion();
	        boNota = new BONota();
	    }
	
	    
	    /**
	     * M�todo para listar los cursos de una asignatura
	     * @param asignatura, la asignatura a la qeu se le buscan los cursos
	     * @return la lista con los cursos que tienen la asignatura
	     * @throws PersistenciaException 
	     */
	    public List<Curso> listarCursosPorAsignatura(Asignatura asignatura) throws Exception{
	        return boCurso.listarCursoPorAsignatura(asignatura);
	    }

	    /**
	     * M�todo para buscar una Asignatura
	     * @param codigo, c�digo con el que se va a buscar la asignatura
	     * @return la asignatura si la encuentra, de lo contrario null
	     * @throws PersistenciaException 
	     */
	    public Asignatura buscarAsignatura(String codigo) throws Exception{
	        return boAsignatura.buscar(codigo);
	    }
	    
	    /**
	     * M�todo para listar las evaluaciones de un curso
	     * @param curso, el curso del cual dependen las evaluaciones
	     * @return la lista de evaluaciones del curso
	     * @throws PersistenciaException 
	     */
	    public List<Evaluacion> listarEvaluacionPorCurso(Curso curso) throws Exception{
	        return boEvaluacion.listarEvaluacionPorCurso(curso);
	    }
	    
	    /**
	     * M�todo para buscar notas de una evaluacion
	     * @param eval, la evaluacion a la que se le busca la nota
	     * @return una nota si la encuentra, de lo contrario null
	     * @throws Exception 
	     */
	    public Nota listarNotasEvaluacion(Evaluacion eval) throws Exception{
	        return boNota.buscarNotasEvaluacion(eval);
	    }
	    
	    /**
	     * M�todo para eliminar una evaluaci�n
	     * @param eval la evaluaci�n que se desea eliminar
	     * @throws Exception 
	     */
	    public void eliminarEvaluacion(Evaluacion eval) throws Exception{
	        boEvaluacion.eliminar(eval);
	    }
	    
	    /**
	     * M�todo para buscar un curso 
	     * @param codigo, c�digo del curso
	     * @return el curso si lo encuentra
	     * @throws Exception 
	     */
	    public Curso buscarCurso(String codigo) throws Exception{
	        return boCurso.buscar(codigo);
	    }
	    
	    /**
	     * M�todo para sumar el porcentaje total de evaluacion de un curso
	     * @param curso, el curso al cual se le sumar� el  total de evaluaci�n
	     * @return un double con la suma del porcentaje total
	     * @throws Exception 
	     */
	    public double sumarPorcentajeEvaluacionCurso(Curso curso) throws Exception{
	        return boEvaluacion.sumarPorcentajeEvaluacionCurso(curso);
	    }
	 
	    /**
	     * M�todo para crear una evaluaci�n
	     * @param evaluacion, la evaluaci�n que se quiere crear
	     * @throws Exception 
	     */
	    public void crearEvaluacion(Evaluacion evaluacion) throws Exception{
	        boEvaluacion.crear(evaluacion);
	    }
	    
}
