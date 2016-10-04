package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOProfesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Profesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorEntityManager;

public class DAOProfesionJPA implements IDAOProfesion{

	public Profesion buscar(String codigo) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Profesion.class, codigo);
	}

	public List<Profesion> listar() throws Exception {

		EntityManager em = AdministradorEntityManager.getEntityManager();
        Query query = em.createQuery("SELECT pro FROM Profesion pro");
        return query.getResultList();
	}

}
