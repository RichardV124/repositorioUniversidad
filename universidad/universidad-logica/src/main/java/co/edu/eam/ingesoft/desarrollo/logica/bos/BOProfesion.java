package co.edu.eam.ingesoft.desarrollo.logica.bos;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOProfesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOProfesionJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Profesion;

public class BOProfesion {

	/**
     * Dao con los métodos de persistencia de profesion
     */
    private IDAOProfesion daoProfesion;

    /**
     * Constructor
     */
    public BOProfesion() {
        daoProfesion = new DAOProfesionJPA();
    }
    
    /**
     * Método de la lógica para buscar profesion
     * @param codigo, código para buscar la profesion
     * @return una profesion si la encuentra, de lo contrario null
     * @throws Exception 
     */
    public Profesion buscar(String codigo) throws Exception{
        return daoProfesion.buscar(codigo);
    }
    
    /**
     * Método de la lógica para listar profesiones
     * @return una lista con las profesiones de la base de datos
     * @throws Exception 
     */
    public List<Profesion> listar() throws Exception{
        return daoProfesion.listar();
    }
    
	
}
