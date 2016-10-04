package co.edu.eam.ingesoft.desarrollo.logica.bos;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOCursoJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOEstudianteJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAORegistroCursoJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public class BORegistroCurso {

	   /**
     * dao con los m�todos de persistencia del registro curso
     */
    private IDAORegistroCurso daoRegistroCurso;

    /**
     * dao con los m�todos de persistencia de curso
     */
    private IDAOCurso daoCurso;

    /**
     * dao con los m�todos de persistencia de estudiante
     */
    private IDAOEstudiante daoEstudiante;

    /**
     * Constructor
     */
    public BORegistroCurso() {
        daoRegistroCurso = new DAORegistroCursoJPA();
        daoCurso = new DAOCursoJPA();
        daoEstudiante = new DAOEstudianteJPA();
    }

    /**
     * M�todo en la l�gica para listar registro cursos
     *
     * @param estudiante, el estudiante al que se le listar�n los registro
     * cursos
     * @return una lista con los registro curso
     * @throws Exception
     */
    public List<RegistroCurso> listarPorEstudiante(Estudiante estudiante) throws Exception {
        return daoRegistroCurso.listarPorEstudiante(estudiante.getCedula());
    }

    /**
     * M�todo en la l�gica para listar registro cursos
     * @param curso, el curso al que se le listaran los registro cursos
     * @return una lista con los registro curso
     * @throws Exception 
     */
    public List<RegistroCurso> listarRegistrosPorCurso(Curso curso) throws Exception{
        return daoRegistroCurso.listarPorCodigoCurso(curso.getCodigo());
    }
    
    /**
     * M�todo de la l�gica para contar los c�reditos registrados por un
     * estudiante     *
     * @param estudiante
     * @return
     * @throws Exception
     */
    public int contarCreditosEstudiante(Estudiante estudiante) throws Exception {
        List<RegistroCurso> lista = listarPorEstudiante(estudiante);
        int cont = 0;
        for (int i = 0; i < lista.size(); i++) {
            cont = cont + lista.get(i).getCurso().getAsignatura().getNumeroCreditos();
        }
        return cont;
    }

    /**
     * M�todo que incluye la l�gica para un registro curso
     * @param curso, el curso que se va a registrar
     * @param estudiante, el estudiante que necesita el curso
     * @throws Exception 
     */
    public void crear(Curso curso, Estudiante estudiante) throws Exception {

        if (contarCreditosEstudiante(estudiante) >= 12) {
            throw new ExcepcionNegocio("El estudiante alcanz� el l�mite de cr�ditos");
        }
        
        if ((contarCreditosEstudiante(estudiante)+curso.getAsignatura().getNumeroCreditos())>12 ) {
            throw new ExcepcionNegocio("Los cr�ditos son insuficientes");
        }
        
        if (daoCurso.buscar(curso.getCodigo()).getEstudiantes().size() == 10) {
            throw new ExcepcionNegocio("El curso ya tiene su cupo m�ximo");
        }
        
        List<RegistroCurso> lista = listarPorEstudiante(estudiante);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCurso().getAsignatura().getCodigo().equals(curso.getAsignatura().getCodigo())) {
                throw new ExcepcionNegocio("El estudiante ya tiene la asignatura registrada");
            }
        }
        
        RegistroCurso registroCurso = new RegistroCurso();
        registroCurso.setCurso(curso);
        registroCurso.setEstudiante(estudiante);
        daoRegistroCurso.crear(registroCurso);
    }

    /**
     * M�todo de la l�gica para buscar un registro cursoi
     * @param estudiante, el estudiante del registro
     * @param curso, el curso del registro
     * @return el registrocurso si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public RegistroCurso buscarEstudianteCurso(Estudiante estudiante, Curso curso) throws Exception{
        return daoRegistroCurso.buscarRegistroCurso(estudiante, curso);
    }
    
    /**
     * M�todo en la l�gica para eliminar un registro
     * @param registro, el registro que se desea eliminar
     * @throws Exception 
     */
    public void eliminarRegistro(RegistroCurso registro) throws Exception{
        if (registro.getNotas().size() == 0) {
            daoRegistroCurso.eliminar(registro);
        } else {
            throw new ExcepcionNegocio("El Curso ya tiene notas registradas");
        }
    }
    
	
}
