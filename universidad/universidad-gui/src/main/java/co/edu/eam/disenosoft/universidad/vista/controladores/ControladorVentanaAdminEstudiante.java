package co.edu.eam.disenosoft.universidad.vista.controladores;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;

public class ControladorVentanaAdminEstudiante {

	private BOEstudiante boEstudiante;
	
	public ControladorVentanaAdminEstudiante(){
		boEstudiante = new BOEstudiante();
	}
	
	public void crear(Estudiante estudiante) throws Exception{
		boEstudiante.crear(estudiante);
	}
	
	public Estudiante buscar(String ced) throws Exception{
		return boEstudiante.buscar(ced);
	}
	
	public void editar(Estudiante estudiante) throws Exception{
		boEstudiante.editar(estudiante);
	}

	public void eliminar(String cedula) throws Exception{
		boEstudiante.eliminar(cedula);
	}
}
