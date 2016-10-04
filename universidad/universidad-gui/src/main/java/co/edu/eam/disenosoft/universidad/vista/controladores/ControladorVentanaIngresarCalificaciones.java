package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BODocente;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOEstudiante;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOEvaluacion;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BONota;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Nota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public class ControladorVentanaIngresarCalificaciones {


    /**
     * bo con la lógica de nota
     */
    private BONota boNota;
    
    /**
     * bo con la lógica de registro curso
     */
    private BORegistroCurso boRegistroCurso;
    
    /**
     * bo con la lógica de evaluacion
     */
    private BOEvaluacion boEvaluacion;
    
    /**
     * bo con la lógica de docente
     */
    private BODocente boDocente;
    
    /**
     * bo con la lógica de curso
     */
    private BOCurso boCurso;
    
    /**
     * bo con la lógica de estudiante
     */
    private BOEstudiante boEstudiante;
    
    /**
     * Constructor
     */
    public ControladorVentanaIngresarCalificaciones() {
        boDocente = new BODocente();
        boCurso = new BOCurso();
        boEvaluacion = new BOEvaluacion();
        boRegistroCurso = new BORegistroCurso();
        boNota = new BONota();
        boEstudiante = new BOEstudiante();
    }
    
    /**
     * Método para buscar un docente
     * @param cedula, la cédula del docente a buscar
     * @return el docente si lo encuentra
     * @throws Exception
     */
    public Docente buscarDocente(String cedula) throws Exception{
        return boDocente.buscar(cedula);
    }
    
    public Nota buscarNota(RegistroCurso registro, Evaluacion eval) throws Exception{
        return boNota.buscarNota(registro, eval);
    }
    
    /**
     * Método para buscar un curso
     * @param codigo, código del curso a buscar
     * @return el curso si lo encuentra
     * @throws Exception 
     */
    public Curso buscarCurso(String codigo) throws Exception{
        return boCurso.buscar(codigo);
    }
    
    /**
     * Método para listar cursos de un docente
     * @param docente, el docente al que se le van a buscar los cursos
     * @return la lista de cursos que contienen el docente
     * @throws Exception 
     */
    public List<Curso> listarCursoPorDocente(Docente docente) throws Exception{
        return boCurso.listarCursoPorDocente(docente);
    }
    
    /**
     * Método para listar evaluaciones de un curso
     * @param curso, el curso al cual se le van a buscar las evaluaciones
     * @return la lista de evaluaciones que tiene un curso
     * @throws Exception 
     */
    public List<Evaluacion> listarEvaluacionPorCurso(Curso curso) throws Exception{
        return boEvaluacion.listarEvaluacionPorCurso(curso);
    }
    
    /**
     * Método para listar registros curso de un curso
     * @param curso, el curso al que se le van a buscar los registros
     * @return la lista de registros de ese curso
     * @throws Exception 
     */
    public List<RegistroCurso> listarRegistroCursoPorCurso(Curso curso) throws Exception{
        return boRegistroCurso.listarRegistrosPorCurso(curso);
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
    
    /**
     * Método para crear una nota
     * @param nota, la nota que se quiere crear
     * @throws Exception 
     */
    public void crear(Nota nota) throws Exception{
        boNota.crear(nota);
    }
    
    /**
     * Método para buscar un Registro Curso
     * @param estudiante, el estudiante del registro
     * @param curso, el curso del registro
     * @return el registro curso si lo encuentra
     * @throws Exception 
     */
    public RegistroCurso buscarRegistroCurso(Estudiante estudiante, Curso curso) throws Exception{
        return boRegistroCurso.buscarEstudianteCurso(estudiante, curso);
    }
	
}
