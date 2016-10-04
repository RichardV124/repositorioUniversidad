package co.edu.eam.disenosoft.universidad.vista.controladores;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.enumeraciones.TipoAsignaturaEnum;

public class ControladorVentanaAsignatura {

	/**
	 * bo que contiene la lógica de asignatura
	 */
	private BOAsignatura boAsignatura;

	/**
	 * Constructor del ControladorVentanaAsignatura
	 */
	public ControladorVentanaAsignatura() {
		boAsignatura = new BOAsignatura();
	}

	/**
	 * Método para crear una asignatura
	 * 
	 * @param asignatura
	 *            a crear
	 * @throws Exception
	 */
	public void crear(Asignatura asignatura) throws Exception {
		boAsignatura.crear(asignatura);
	}

	/**
	 * Método para buscar una asignatura
	 * 
	 * @param codigo,
	 *            el código para buscar la asignatura
	 * @return la asignatura si la encuentra de lo contrario null
	 * @throws Exception
	 */
	public Asignatura buscar(String codigo) throws Exception {
		return boAsignatura.buscar(codigo);
	}

	/**
	 * Método para editar una asignatura
	 * 
	 * @param asignatura
	 *            a editar
	 * @throws Exception
	 */
	public void editar(Asignatura asignatura) throws Exception {
		boAsignatura.editar(asignatura);
	}

	public void eliminar(String cod) throws Exception {
		boAsignatura.eliminar(cod);
	}
}