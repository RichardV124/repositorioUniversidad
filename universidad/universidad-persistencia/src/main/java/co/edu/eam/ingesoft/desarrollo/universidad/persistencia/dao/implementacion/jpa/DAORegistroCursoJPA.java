package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAORegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorEntityManager;

public class DAORegistroCursoJPA implements IDAORegistroCurso {

	public List<RegistroCurso> listarPorEstudiante(String cedula) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(RegistroCurso.CONSULTA_ESTUDIANTE);
		// Seteamos los parametros
		query.setParameter(1, cedula);
		return query.getResultList();
	}

	public List<RegistroCurso> listarPorCodigoCurso(String codigo) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(RegistroCurso.CONSULTA_LISTA_ESTUDIANTE);
		// Seteamos los parametros
		query.setParameter(1, codigo);
		return query.getResultList();

	}

	public void crear(RegistroCurso registroCurso) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(registroCurso);
		
		em.getTransaction().commit();
		
	}

	public void eliminar(RegistroCurso registroCurso) throws Exception {
		// TODO Auto-generated method stub

	}

	public RegistroCurso buscarRegistroCurso(Estudiante estudiante, Curso curso) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();

		Query query = em.createNamedQuery(RegistroCurso.CONSULTA_REGISTRO_POR_ESTUDIANTE_CURSO);
		query.setParameter(1, estudiante);
		query.setParameter(2, curso);
		List<RegistroCurso> cursos = query.getResultList();
		if (cursos.size() > 0) {
			return cursos.get(0);
		} else {
			return null;
		}
	}

}
