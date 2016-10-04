package co.edu.eam.ingesoft.desarrollo.logica.bos;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOAsignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOAsignaturaJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOCursoJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;

public class BOCurso {

	private IDAOCurso daoCurso;
	 private IDAOAsignatura daoAsig;
	
	 
	 /**
	     * Coonstructor
	     */
	    public BOCurso() {
	        daoCurso = new DAOCursoJPA();
	        daoAsig = new DAOAsignaturaJPA();
	    }
	/**
     * Método de la lógica para crear un curso
     *
     * @param curso, el curso que se desea crear
	 * @throws Exception 
     */
    public void crear(Curso curso) throws Exception {
        List<Curso> cursosDoc = daoCurso.listarCursoPorDocente(curso.getDocente());
        for (int i = 0; i < cursosDoc.size(); i++) {
            for (int j = 0; j < cursosDoc.get(i).getSesiones().size(); j++) {
                for (int k = 0; k < curso.getSesiones().size(); k++) {
                    if (curso.getSesiones().get(k).getDia()
                            == cursosDoc.get(i).getSesiones().get(j).getDia()) {
                        if (curso.getSesiones().get(k).getHoraInicio() >= cursosDoc.get(i).getSesiones().get(j).getHoraInicio()
                                && curso.getSesiones().get(k).getHoraInicio() < cursosDoc.get(i).getSesiones().get(j).getHoraFinal()) {
                            throw new ExcepcionNegocio("Hay un cruce de horarios en este curso para "
                                    + "el docente");
                        }
                    }
                }
            }
        }
        curso.setCodigo(generarCodigo(curso));
        daoCurso.crear(curso);
    }

    /**
     * Método con la lógica para buscar un curso
     *
     * @param codigo, el código de la asignatura
     * @param cedula, la cédula del docente
     * @return el curso si lo encuentra, de lo contrario null
     * @throws Exception
     */
    public Curso buscar(String codigo, String cedula) throws Exception {
        return daoCurso.buscar(codigo, cedula);
    }

//    /**
//     * Método de la lógica para buscar un curso
//     * @param codigo, código del curso a buscar
//     * @return el curso si lo encuentra, de lo contrario null
//     * @throws PersistenciaException 
//     */
//    public Curso buscar(String codigo,String cedula) throws Exception{
//        return daoCurso.buscar(codigo,cedula);
//    }
    
    public void editar(Curso curso) throws Exception {
        List<Curso> cursosDoc = daoCurso.listarCursoPorDocente(curso.getDocente());
        for (int i = 0; i < cursosDoc.size(); i++) {
            for (int j = 0; j < cursosDoc.get(i).getSesiones().size(); j++) {
                for (int k = 0; k < curso.getSesiones().size(); k++) {
                    if (curso.getCodigo() != cursosDoc.get(i).getCodigo()) {

                        if (curso.getSesiones().get(k).getDia()
                                == cursosDoc.get(i).getSesiones().get(j).getDia()) {
                            if (curso.getSesiones().get(k).getHoraInicio() >= cursosDoc.get(i).getSesiones().get(j).getHoraInicio()
                                    && curso.getSesiones().get(k).getHoraInicio() < cursosDoc.get(i).getSesiones().get(j).getHoraFinal()) {
                                throw new ExcepcionNegocio("Hay un cruce de horarios en este curso para "
                                        + "el docente");
                            }
                        }

                    }

                }
            }
        }
        daoCurso.editar(curso);
    }

    /**
     * Genera un código automático para el curso
     *
     * @param curso, curso al que se le va a generar el código
     * @return
     */
    public String generarCodigo(Curso curso) {
        String time = ((Long) System.nanoTime()).toString();
        String dato = "" + time.charAt(4) + time.charAt(6);
        String dato1 = curso.getAsignatura().getCodigo();
        Calendar fecha = new GregorianCalendar();
        int anio = fecha.get(Calendar.YEAR);
        String codigo = dato + "-" + dato1 + anio + semestreDelAnio();
        return codigo;
    }

    /**
     * calcula en que semestre del año estamos, obtiene el mes actual y calcula,
     * si es antes de junio es el primer semestre y si es despues es el segundo
     * semestre
     *
     * @return un string según el semestre en el que estemos, I si el el primer
     * semestre y II si es el segundo semestre
     */
    public String semestreDelAnio() {
        Calendar fecha = new GregorianCalendar();
        int mes = fecha.get(Calendar.MONTH);
        if (mes >= 0 && mes <= 5) {
            return "I";
        } else {
            return "II";
        }
    }

    /**
     * Método para listar los cursos en los que está una asignatura
     * @param asignatura, la asignatura que se desea buscar en los cursos
     * @return una lista de cursos que incluyen la asignatura
     * @throws Exception 
     */
    public List<Curso> listarCursoPorAsignatura(Asignatura asignatura) throws Exception{
        return daoCurso.listarCursoPorAsignatura(asignatura.getCodigo());
    }
    
    /**
     * Método para listar los cursos en los que está un docente
     * @param docente, el docente que se desea buscar en los cursos
     * @return una lista de cursos que incluyen el docente
     * @throws Exception 
     */
    public List<Curso> listarCursoPorDocente(Docente docente) throws Exception{
        return daoCurso.listarCursoPorDocente(docente);
    }
    /**
     * Método de la lógica para buscar un curso
     * @param codigo, código del curso a buscar
     * @return el curso si lo encuentra, de lo contrario null
     * @throws Exception 
     */
    public Curso buscar(String codigo) throws Exception{
        return daoCurso.buscar(codigo);
    }
}
