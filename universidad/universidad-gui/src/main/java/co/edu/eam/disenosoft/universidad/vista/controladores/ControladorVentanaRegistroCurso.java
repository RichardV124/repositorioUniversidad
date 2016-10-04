package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOEstudiante;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;

public class ControladorVentanaRegistroCurso {

	private BOEstudiante boEstudiante;
    private BOAsignatura boAsignatura;
    private BORegistroCurso boRegistroCurso;
    private BOCurso boCurso;

    public ControladorVentanaRegistroCurso() {
        boEstudiante = new BOEstudiante();
        boAsignatura = new BOAsignatura();
        boRegistroCurso = new BORegistroCurso();
        boCurso = new BOCurso();
    }

    /**
     * M�todo para buscar un estudiante
     * @param cedula, la cedula del estudiante a buscar
     * @return el estudiante si lo encuentra
     * @throws Exception 
     */
    public Estudiante buscarEstudiante(String cedula) throws Exception{
        return boEstudiante.buscar(cedula);
    }
    
    /**
     * M�todo para buscar una asignatura
     * @param codigo, el c�digo de la asignatura a buscar
     * @return la asignatura si la encuentra
     * @throws Exception 
     */
    public Asignatura buscarAsignatura(String codigo) throws Exception{
        return boAsignatura.buscar(codigo);
    }
    
    /**
     * M�todo para contar los cr�ditos registrados por un estudiante
     * @param estudiante, el estudiante al que se le contar�n los cr�ditos
     * @return un entero con la cantidad de cr�ditos que tiene
     * @throws Exception 
     */
    public int contarCreditosEstudiante(Estudiante estudiante) throws Exception{
        return boRegistroCurso.contarCreditosEstudiante(estudiante);
    }
    
    /**
     * M�todo para listar cursos por asignatura
     * @param asignatura, la asignatura de los cursos a buscar
     * @return la lista con los cursos que incluyen la asignatura
     * @throws Exception 
     */
    public List<Curso> listarCursoPorAsignatura(Asignatura asignatura) throws Exception{
        return boCurso.listarCursoPorAsignatura(asignatura);
    }
    
    /**
     * M�todo para crear un registro curso
     * @param curso, el curso que se va a registrar
     * @param estudiante, el estudiante a quien se le va a registrar
     * @throws PersistenciaException
     * @throws Exception 
     */
    public void crearRegistro(Curso curso, Estudiante estudiante) throws Exception{
        boRegistroCurso.crear(curso, estudiante);
    }
    
    /**
     * M�todo para buscar un Curso
     * @param codigo, el c�digo del curso a buscar
     * @returnel curso si lo encuentra
     * @throws Exception 
     */
    public Curso buscarCurso(String codigo) throws Exception{
        return boCurso.buscar(codigo);
    }
    
    
}
