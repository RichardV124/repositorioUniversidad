package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOEstudiante;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;


public class ControladorVentanaVerRegistroEstudiante {

	 private BORegistroCurso boRegistroCurso;
	    private BOEstudiante boEstudiante;

	    /**
	     * Constructor
	     */
	    public ControladorVentanaVerRegistroEstudiante() {
	        boRegistroCurso = new BORegistroCurso();
	        boEstudiante = new BOEstudiante();
	    }
	
	    
	    /**
	     * Método para contar los créditos registrados por un estudiante
	     * @param estudiante, el estudiante al que se le van a contar los créditos registrados
	     * @return un entero con la cantidad de créditos total
	     * @throws Exception 
	     */
	    public int contarCreditosEstudiante(Estudiante estudiante) throws Exception{
	        return boRegistroCurso.contarCreditosEstudiante(estudiante);
	    }
	    
	    
	    /**
	     * Método para listar los registro cursos de un estudiante
	     * @param estudiante, el estudiante al cual se le buscaran los registros
	     * @return la lista de registros de un estudiante
	     * @throws Exception 
	     */
	    public List<RegistroCurso> listarRegistroCursoPorEstudiante(Estudiante estudiante) throws Exception{
	        return boRegistroCurso.listarPorEstudiante(estudiante);
	    }
	    
	    /**
	     * Método para buscar un estudiante
	     * @param cedula, la cédula del estudiante a buscar
	     * @return el estudiante si lo encuentra
	     * @throws Exception 
	     */
	    public Estudiante buscarEstudiante(String cedula) throws Exception{
	        return boEstudiante.buscar(cedula);
	    }
	    
	    public void eliminarRegistro(RegistroCurso registro) throws Exception{
	        boRegistroCurso.eliminarRegistro(registro);
	    }
	    
}
