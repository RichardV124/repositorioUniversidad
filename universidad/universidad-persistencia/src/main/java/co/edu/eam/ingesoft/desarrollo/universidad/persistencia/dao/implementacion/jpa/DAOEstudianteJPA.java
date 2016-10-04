package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorEntityManager;

public class DAOEstudianteJPA implements IDAOEstudiante{

	public void crear(Estudiante estudiante) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Estudiante e = buscar(estudiante.getCedula());
		if(e==null){
		em.getTransaction().begin();
		
		em.persist(estudiante);
		
		em.getTransaction().commit();
		}
	}

	public void editar(Estudiante estudiante) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		
		em.merge(estudiante);
		
		em.getTransaction().commit();

	}

	public void eliminar(String cedula) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		Estudiante e = buscar(cedula);
		if(e!=null){
		em.remove(e);
		}
		em.getTransaction().commit();
	}

	public Estudiante buscar(String cedula) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Estudiante.class, cedula);
	}

	public List<Estudiante> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
