package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BODocente;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOProfesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Profesion;

public class ControladorVentanaDocente {

	 /**
     * bo que contiene la lógica de docente
     */
    private BODocente boDocente;
    
    /**
     * Bo que contiene la lógica de profesion
     */
    private BOProfesion boProfesion;
    
    /**
     * Constructor del ControladorVentanaProfesor
     */
    public ControladorVentanaDocente() {
        boDocente = new BODocente();
        boProfesion = new BOProfesion();
    }
    
    /**
     * Método para listar todas las profesiones
     * @return una lista con todas las profesiones
     * @throws Exception
     */
    public List<Profesion> listarProfesion() throws Exception{
        return boProfesion.listar();
    }
    
    /**
     * Método para crear un docente
     * @param docente que se va a crear
     * @throws Exception
     */
    public void crearDocente(Docente docente) throws Exception{
        boDocente.crear(docente);
    }
    
    /**
     * Método para buscar una profesion
     * @param codigo, el código con el que se va a buscar la profesion
     * @return la profesion si la encuentra, de lo contrario null
     * @throws PersistenciaException
     */
    public Profesion buscarProfesion(String codigo) throws Exception{
        return boProfesion.buscar(codigo);
    }
    
    /**
     * Método para buscar un docente
     * @param codigo, el código con el que se va a buscar el docente
     * @return el docente si lo encuentra, de lo contrario null
     * @throws PersistenciaException
     */
    public Docente buscarDocente(String codigo) throws Exception{
        return boDocente.buscar(codigo);
    }
    
    /**
     * Método para editar un docente
     * @param nombre
     * @param apellido
     * @param cedula
     * @param correo
     * @param direccion
     * @param telefono
     * @param profesion
     * @param postgrado 
     * @throws PersistenciaException 
     * @throws BusinessException 
     */
    public void editarDocente(String nombre, String apellido, String cedula,
			String correo, String direccion, String telefono,
			Profesion profesion, boolean postgrado) throws Exception{
    	Docente docente = new Docente(cedula, apellido, correo, direccion, nombre, telefono, postgrado, profesion);
        boDocente.editar(docente);
    }

    public void eliminar(String cedula) throws Exception{
		boDocente.eliminar(cedula);
	}
    
}
