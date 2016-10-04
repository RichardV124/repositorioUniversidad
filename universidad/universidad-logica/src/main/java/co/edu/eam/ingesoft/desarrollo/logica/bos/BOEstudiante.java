package co.edu.eam.ingesoft.desarrollo.logica.bos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAODocenteJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa.DAOEstudianteJPA;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;

public class BOEstudiante {


    /**
     * Dao con los m�todos de persistencia de estudiante
     */
    private IDAOEstudiante daoEstudiante;
    
    /**
     * Dao con los m�todos de persistencia de docente
     */
    private IDAODocente daoDocente;

    /**
     * Constructor
     */
    public BOEstudiante() {
        daoEstudiante = new DAOEstudianteJPA();
        daoDocente = new DAODocenteJPA();
    }
	
    /**
     * M�todo de la l�gica para crear un estudiante     *
     * @param estudiante, el estudiante que se quiere guardar
     * @throws Exception
     */
    public void crear(Estudiante estudiante) throws Exception {
        if (daoEstudiante.buscar(estudiante.getCedula()) != null
                || daoDocente.buscar(estudiante.getCedula()) != null) {
            throw new ExcepcionNegocio("Ya existe alguien registrado con la c�dula "
                    + estudiante.getCedula());

        } else {
            daoEstudiante.crear(estudiante);
        }
    }

    /**
     * M�todo de l�gica para buscar un estudiante
     *
     * @param cedula, la c�dula del estudiante a buscar
     * @return el estudiante si lo encuentra
     * @throws Exception
     */
    public Estudiante buscar(String cedula) throws Exception {
        return daoEstudiante.buscar(cedula);
    }
    
    /**
     * M�todo de l�gica para eliminar un estudiante
     *
     * @param cedula, la c�dula del estudiante a eliminar
     * @throws Exception
     */
    public void eliminar(String cedula) throws Exception {
        daoEstudiante.eliminar(cedula);
    }

    /**
     * M�todo de l�gica para editar un estudiante
     * @param estudiante el estudiante que se va a editar
     * @throws Exception  
     */
    public void editar(Estudiante estudiante) throws Exception {
        if (daoEstudiante.buscar(estudiante.getCedula()) == null) {
            throw new ExcepcionNegocio("No se puede editar,ya que no existe un estudiante con c�dula "
                    + estudiante.getCedula());
        } else {
            daoEstudiante.editar(estudiante);
        }
    }
    

    /**
     * M�todo de la l�gica para calcular la edad de un estudiante
     * @param estudiante, el estudiante al que se le va a calcular la edad
     * @return un entero con la edad
     */
    public int calcularEdad(Estudiante estudiante){
        int edad = 0;
        int anioEst = estudiante.getFechaNacimiento().getYear() + 1900;
        int mesEst = estudiante.getFechaNacimiento().getMonth();
        int diaEst = estudiante.getFechaNacimiento().getDate();
        Calendar fecha = new GregorianCalendar();
        int anioFecha = fecha.get(Calendar.YEAR);
        int mesFecha = fecha.get(Calendar.MONTH);
        int diaFecha = fecha.get(Calendar.DAY_OF_MONTH);
        int anio = anioFecha - anioEst;
        int mes = mesFecha - mesEst;
        int dia = diaFecha - diaEst;
        if (mes < 0 || (mes==0 && dia<0)) {
            edad = anio - 1;
        } else {
            edad = anio;
        }        
        return edad;
    }
    
}
