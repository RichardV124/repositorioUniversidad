package co.edu.eam.ingesoft.desarrollo.logica.bos;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAONota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAONotaJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Nota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public class BONota {

	 /**
     * dao con los m�todos de persistencia de nota
     */
    private IDAONota daoNota;

    /**
     * Constructor
     */
    public BONota() {
        daoNota = new DAONotaJPA();
    }
    
    /**
     * M�todo de la l�gica para crear una nota
     * @param nota, la nota que se quiere crear
     * @throws Excepcion
     */
    public void crear(Nota nota) throws Exception{
        if (nota.getValor()>5 || nota.getValor()<0) {
            throw new ExcepcionNegocio("Nota no v�lida, ingrese nota entre 0 y 5");
        }
        Nota nota2 = buscarNota(nota.getRegistroCurso(), nota.getEvaluacion());
        if (nota2 != null) {
            if (nota2.isEditada()) {                
                throw new ExcepcionNegocio("La nota ya ha sido editada");
            } else {
                nota2.setEditada(true);
                nota2.setValor(nota.getValor());
                daoNota.editar(nota2);
            }
        } else {
            daoNota.crear(nota);
        }
    }
    
    /**
     * M�todo de la l�gica para buscar una nota
     * @param registro, el registro donde est� la nota
     * @param eval, la evaluaci�n d�nde se registra la nota
     * @return la nota si la encuentra, de lo contrario null
     * @throws Exception 
     */
    public Nota buscarNota(RegistroCurso registro, Evaluacion eval) throws 	Exception{
        return daoNota.buscarPorCursoEvaluacion(registro, eval);
    }
    
    /**
     * M�todo de la l�gica para listar notas de un registrocurso
     * @param registro, el registro al que se le van a listar las notas
     * @return una lista con las notas encontradas
     * @throws Exception 
     */
    public List<Nota> listarNotasRegistro(RegistroCurso registro) throws Exception{
        return daoNota.listarPorRegistroCurso(registro);
    }
    
    /**
     * M�todo de la l�gica para buscar notas de una evaluaci�n
     * @param eval, la evaluacion a la que se le van a listar las notas
     * @return una nota si la encuentra, de lo contrario null
     * @throws Exception 
     */
    public Nota buscarNotasEvaluacion(Evaluacion eval) throws Exception{
        return daoNota.buscarPorEvaluacion(eval);
    }
	
}
