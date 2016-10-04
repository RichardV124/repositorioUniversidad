package co.edu.eam.ingesoft.desarrollo.logica.bos;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEvaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAONota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOEvaluacionJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAONotaJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;

public class BOEvaluacion {

	/**
     * dao con los métodos de persistencia de evaluacion
     */
    private IDAOEvaluacion daoEvaluacion;
    
    /**
     * dao con los métodos de persistencia de nota
     */
    private IDAONota daoNota;

    /**
     * Constructor
     */
    public BOEvaluacion() {
        daoEvaluacion = new DAOEvaluacionJPA();
        daoNota = new DAONotaJPA();
    }
	
    /**
     * Método para listar las evaluaciones de un curso
     * @param curso, el curso del cual dependen las evaluaciones
     * @return la lista de evaluaciones del curso
     * @throws Exception 
     */
    public List<Evaluacion> listarEvaluacionPorCurso(Curso curso) throws Exception{
        return daoEvaluacion.listarPorCurso(curso);
    }
    
    /**
     * Método con la lógica para sumar el porcentaje de evaluacion de un curso
     * @param curso, el curso al cual se le sumará el porcentaje
     * @return un double con el porcentaje total
     * @throws Exception 
     */
    public double sumarPorcentajeEvaluacionCurso(Curso curso) throws Exception{
        List<Evaluacion> lista = listarEvaluacionPorCurso(curso);
        double cont = 0;
        for (int i = 0; i < lista.size(); i++) {
            cont += lista.get(i).getPorcentaje();
        }
        return cont;
    }
    
    /**
     * Método con la lógica para crear una evaluación
     * @param evaluacion, la evaluación que se quiere crear
     * @throws Exception
     */
    public void crear(Evaluacion evaluacion) throws Exception{
        if (sumarPorcentajeEvaluacionCurso(evaluacion.getCurso())==100) {
            throw new ExcepcionNegocio("El curso ya tiene 100% en porcentaje de evaluación");
        }
        
        if ((sumarPorcentajeEvaluacionCurso(evaluacion.getCurso()) + evaluacion.getPorcentaje()) > 100) {
            throw new ExcepcionNegocio("La evaluación que quiere ingresar hace superar el 100% "
                    + "del porcentaje de evaluación");
        }
                
        daoEvaluacion.crear(evaluacion);
    }
    
    /**
     * Método de la lógica para eliminar una evaluación
     * @param eval, la evaluación que se quiere eliminar
     * @throws Exception
     */
    public void eliminar(Evaluacion eval) throws Exception{
        if (daoNota.buscarPorEvaluacion(eval)==null) {
            daoEvaluacion.eliminar(eval);
        } else {
            throw new ExcepcionNegocio("La calificación ya tiene notas registradas");
        }    
    }
    
    
}
