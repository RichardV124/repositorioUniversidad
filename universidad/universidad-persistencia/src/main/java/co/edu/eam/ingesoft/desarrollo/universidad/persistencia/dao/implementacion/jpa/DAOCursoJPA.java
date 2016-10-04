package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorEntityManager;

public class DAOCursoJPA implements IDAOCurso {
	/**
	 * Metodo para buscar un curso por asignatura
	 * 
	 * @param codigo,
	 *            el codigo del curso que se va a buscar @return, la lista con
	 *            los cursos encontrados
	 * @throws PersistenciaException
	 */
	public List<Curso> listarCursoPorAsignatura(String codigo) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Curso.CONSULTA_ASIGNATURA);
		// Seteamos los parametros
		query.setParameter(1, codigo);
		return query.getResultList();
	}

	public Curso buscar(String codigo, String cedula) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Curso.CONSULTA_DOC_ASIG);
		// Seteamos los parametros
		query.setParameter(1, cedula);
		query.setParameter(2, codigo);
		List<Curso> lista = query.getResultList();
		for (int i = 0; i < lista.size(); i++) {
			Curso cur = lista.get(i);
			return cur;
		}
		return null;

	}

	public List<Curso> listarCursoPorDocente(Docente docente) {

		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Curso.CONSULTAR_LISTAR_POR_DOCENTE);
		query.setParameter(1, docente.getCedula());
		return query.getResultList();
	}

	public void crear(Curso curso) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Curso c = em.find(Curso.class, curso.getCodigo());
		if (c == null) {
			em.getTransaction().begin();

			em.persist(curso);

			em.getTransaction().commit();
		}
	}

	public void editar(Curso curso) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(curso);

		em.getTransaction().commit();
	}

	public void eliminar(Curso curso) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.remove(curso);
		em.getTransaction().commit();
	}

	public Curso buscar(String codigo) throws Exception {
		 EntityManager em = AdministradorEntityManager.getEntityManager();
		
		 return em.find(Curso.class, codigo);
	}

}
