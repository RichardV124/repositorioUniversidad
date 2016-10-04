package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOEstudiante;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public class ControladorVentanaVerCurso {

	  
    /**
     * bo con la l�gica de curso
     */
    private BOCurso boCurso;

    /**
     * bo con la l�gica de asignatura
     */
    private BOAsignatura boAsignatura;
    
    /**
     * bo con la l�gica de registro curso
     */
    private BORegistroCurso boRegistroCurso;
    
    /**
     * bo con la l�gica de estudiante
     */
    private BOEstudiante boEstudiante;
    
    /**
     * Constructor
     */
    public ControladorVentanaVerCurso() {
        boCurso = new BOCurso();
        boAsignatura = new BOAsignatura();
        boRegistroCurso = new BORegistroCurso();
        boEstudiante = new BOEstudiante();
    }
    

    /**
     * M�todo para calcular la edad de un estudiante
     * @param estudiante, el estudiante al que se le va a calcular la edad
     * @return un int con la edad
     */
    public int calcularEdad(Estudiante estudiante){
        return boEstudiante.calcularEdad(estudiante);
    }
    
    /**
     * M�todo para listar los cursos de una asignatura
     * @param asignatura, la asignatura a la que se le van a listar los cursos
     * @return una lista con los cursos que incluyen la asignatura
     * @throws  Exception 
     */
    public List<Curso> listarCursosPorAsignatura(Asignatura asignatura) throws Exception{
        return boCurso.listarCursoPorAsignatura(asignatura);
    }
    
    /**
     * M�todo para buscar una asignatura
     * @param codigo, el c�digo de la asignatura a buscar
     * @return la asignatura si la encuentra, de lo contrario null 
     * @throws Exception 
     */
    public Asignatura buscarAsignatura(String codigo) throws Exception{
        return boAsignatura.buscar(codigo);
    }
    
    /**
     * M�todo para listar los registros de un curso
     * @param curso, el curso al que se le van a buscar los registros
     * @return la lista de registros
     * @throws Exception 
     */
    public List<RegistroCurso> listarRegistrosPorCurso(Curso curso) throws Exception{
        return boRegistroCurso.listarRegistrosPorCurso(curso);
    }
    
    /**
     * M�todo para buscar un curso
     * @param codigo, el c�digo del curso a buscar
     * @return el curso si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public Curso buscarCurso(String codigo) throws Exception{
        return boCurso.buscar(codigo);
    }
	
}
