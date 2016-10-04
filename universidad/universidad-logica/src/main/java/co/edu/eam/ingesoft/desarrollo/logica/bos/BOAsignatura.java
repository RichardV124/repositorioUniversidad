package co.edu.eam.ingesoft.desarrollo.logica.bos;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOAsignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOAsignaturaJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;

public class BOAsignatura {

	  /**
     * dao con los m�todos de persistencia de asignatura
     */
    private IDAOAsignatura daoAsignatura;

    /**
     * Constructor
     */
    public BOAsignatura() {
        daoAsignatura = new DAOAsignaturaJPA();
    }
    
    
    
    /**
     * M�todo con la l�gica para crear una asignatura
     * @param asignatura, la asignatura que se quiere crear
     * @throws Exception 
     */
    public void crear(Asignatura asignatura) throws Exception{
        if (daoAsignatura.buscar(asignatura.getCodigo()) != null) {
            throw new ExcepcionNegocio("Ya existe una asignatura con el "
                    + "c�digo " + asignatura.getCodigo());
        } else {
            daoAsignatura.crear(asignatura);
        }
    }
    
    /**
     * M�todo con la l�gica de buscar Asignatura
     * @param codigo, c�digo con el que se busca la asignatura
     * @return la asignatura si la encuentra, de lo contrario null
     * @throws Exception 
     */
    public Asignatura buscar(String codigo) throws Exception{
        return daoAsignatura.buscar(codigo);
    }
    
    /**
     * M�todo con la l�gica para editar una asignatura
     * @param asignatura, la asignatura que se quiere editar
     * @throws Exception
     */
    public void editar(Asignatura asignatura) throws Exception{
        if (daoAsignatura.buscar(asignatura.getCodigo()) == null) {
            throw new ExcepcionNegocio("No se puede editar, no existe asignatura con "
                    + "c�digo " + asignatura.getCodigo());
        } else {
            daoAsignatura.editar(asignatura);
        }
    }
    
    /**
     * M�todo de l�gica para eliminar una asignatura
     *
     * @param cod, el codigo de la asignatura a eliminar
     * @throws Exception
     */
    public void eliminar(String cod) throws Exception {
        daoAsignatura.eliminar(cod);
    }
    	
	
}
