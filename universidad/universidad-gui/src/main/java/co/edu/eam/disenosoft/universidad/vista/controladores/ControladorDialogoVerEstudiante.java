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
     * bo con la l�gica de registro
     */
    private BORegistroCurso boRegistro;
    
    /**
     * bo con la l�gica de evaluaci�n
     */
    private BOEvaluacion boEvaluacion;
    
    /**
     * bo con la l�gica de nota
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
     * m�todo para contar los cr�ditos registrados por un estudiante
     * @param estudiante, el estudiante al que se le van a contar los cr�ditos
     * @return un entero con la cantidad de cr�ditos registrados
     * @throws Exception 
     */
    public int contarCreditosEstudiante(Estudiante estudiante) throws Exception{
        return boRegistro.contarCreditosEstudiante(estudiante);
    }
    
    /**
     * M�todo para listar las evaluaciones de un curso
     * @param curso, el curso al que se le van a listar las evaluaciones
     * @return una lista con las evaluaciones de un curso
     * @throws Exception 
     */
    public List<Evaluacion> listarEvaluacionesPorCurso(Curso curso) throws Exception{
        return boEvaluacion.listarEvaluacionPorCurso(curso);
    }
    
    /**
     * M�todo para buscar la nota de una evaluaci�n
     * @param evaluacion, la evaluaci�n a la que se le va a buscar la nota
     * @return la nota si la tiene, de lo contrario null
     * @throws Exception 
     */
    public Nota buscarNotaPorEvaluacion(Evaluacion evaluacion) throws Exception{
        return boNota.buscarNotasEvaluacion(evaluacion);
    }
    
	
}
