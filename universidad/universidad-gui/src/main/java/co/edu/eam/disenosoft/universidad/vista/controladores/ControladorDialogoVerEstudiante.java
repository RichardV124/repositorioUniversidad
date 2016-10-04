package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOEvaluacion;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BONota;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Nota;

public class ControladorDialogoVerEstudiante {

	  
    /**
     * bo con la lógica de registro
     */
    private BORegistroCurso boRegistro;
    
    /**
     * bo con la lógica de evaluación
     */
    private BOEvaluacion boEvaluacion;
    
    /**
     * bo con la lógica de nota
     */
    private BONota boNota;

    /**
     * Constructor
     */
    public ControladorDialogoVerEstudiante() {
        boRegistro = new BORegistroCurso();
        boEvaluacion = new BOEvaluacion();
        boNota = new BONota();
    }
    
    /**
     * método para contar los créditos registrados por un estudiante
     * @param estudiante, el estudiante al que se le van a contar los créditos
     * @return un entero con la cantidad de créditos registrados
     * @throws Exception 
     */
    public int contarCreditosEstudiante(Estudiante estudiante) throws Exception{
        return boRegistro.contarCreditosEstudiante(estudiante);
    }
    
    /**
     * Método para listar las evaluaciones de un curso
     * @param curso, el curso al que se le van a listar las evaluaciones
     * @return una lista con las evaluaciones de un curso
     * @throws Exception 
     */
    public List<Evaluacion> listarEvaluacionesPorCurso(Curso curso) throws Exception{
        return boEvaluacion.listarEvaluacionPorCurso(curso);
    }
    
    /**
     * Método para buscar la nota de una evaluación
     * @param evaluacion, la evaluación a la que se le va a buscar la nota
     * @return la nota si la tiene, de lo contrario null
     * @throws Exception 
     */
    public Nota buscarNotaPorEvaluacion(Evaluacion evaluacion) throws Exception{
        return boNota.buscarNotasEvaluacion(evaluacion);
    }
    
	
}
