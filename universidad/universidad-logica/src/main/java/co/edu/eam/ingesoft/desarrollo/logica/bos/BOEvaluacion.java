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
     * dao con los m�todos de persistencia de evaluacion
     */
    private IDAOEvaluacion daoEvaluacion;
    
    /**
     * dao con los m�todos de persistencia de nota
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
     * M�todo para listar las evaluaciones de un curso
     * @param curso, el curso del cual dependen las evaluaciones
     * @return la lista de evaluaciones del curso
     * @throws Exception 
     */
    public List<Evaluacion> listarEvaluacionPorCurso(Curso curso) throws Exception{
        return daoEvaluacion.listarPorCurso(curso);
    }
    
    /**
     * M�todo con la l�gica para sumar el porcentaje de evaluacion de un curso
     * @param curso, el curso al cual se le sumar� el porcentaje
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
     * M�todo con la l�gica para crear una evaluaci�n
     * @param evaluacion, la evaluaci�n que se quiere crear
     * @throws Exception
     */
    public void crear(Evaluacion evaluacion) throws Exception{
        if (sumarPorcentajeEvaluacionCurso(evaluacion.getCurso())==100) {
            throw new ExcepcionNegocio("El curso ya tiene 100% en porcentaje de evaluaci�n");
        }
        
        if ((sumarPorcentajeEvaluacionCurso(evaluacion.getCurso()) + evaluacion.getPorcentaje()) > 100) {
            throw new ExcepcionNegocio("La evaluaci�n que quiere ingresar hace superar el 100% "
                    + "del porcentaje de evaluaci�n");
        }
                
        daoEvaluacion.crear(evaluacion);
    }
    
    /**
     * M�todo de la l�gica para eliminar una evaluaci�n
     * @param eval, la evaluaci�n que se quiere eliminar
     * @throws Exception
     */
    public void eliminar(Evaluacion eval) throws Exception{
        if (daoNota.buscarPorEvaluacion(eval)==null) {
            daoEvaluacion.eliminar(eval);
        } else {
            throw new ExcepcionNegocio("La calificaci�n ya tiene notas registradas");
        }    
    }
    
    
}
