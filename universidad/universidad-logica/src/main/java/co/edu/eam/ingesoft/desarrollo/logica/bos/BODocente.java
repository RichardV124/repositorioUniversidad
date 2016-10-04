package co.edu.eam.ingesoft.desarrollo.logica.bos;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAODocenteJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOEstudianteJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;

public class BODocente {

	  /**
     * dao con los m�todos de persistencia de estudiante
     */
    private IDAOEstudiante daoEstudiante;
    /**
     * dao con los m�todos de persistencia de docente
     */
    private IDAODocente daoDocente;

    /**
     * Constructor
     */
    public BODocente() {
        daoEstudiante = new DAOEstudianteJPA();
        daoDocente = new DAODocenteJPA();
    }
    
    
    
    /**
     * M�todo con la l�gica para crear un docente
     * @param docente, el docente que se desea crear
     * @throws Exception
     */
    public void crear(Docente docente) throws Exception{
        if (daoEstudiante.buscar(docente.getCedula()) != null
                || daoDocente.buscar(docente.getCedula()) != null) {
            throw new ExcepcionNegocio("Ya existe alguien registrado con la c�dula "
                    + docente.getCedula());
        } else {
            daoDocente.crear(docente);
        }
    }
    
    /**
     * M�todo con la l�gica para buscar docente
     * @param cedula, la c�dula del docente a buscar
     * @return el docente si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public Docente buscar(String cedula) throws Exception{
        return daoDocente.buscar(cedula);
    }
    
    /**
     * M�todo con la l�gica para editar un docente
     * @param docente, el docente que se desea editar
     * @throws Exception
     */
    public void editar(Docente docente) throws Exception{
        if (daoDocente.buscar(docente.getCedula()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe un "
            		+ "docente con c�dula "+ docente.getCedula());
        } else {
            daoDocente.editar(docente);
        }
    }
    
    /**
     * M�todo de l�gica para eliminar un docente
     *
     * @param cedula, la c�dula del docente a eliminar
     * @throws Exception
     */
    public void eliminar(String cedula) throws Exception {
        daoDocente.eliminar(cedula);
    }
    	
}
