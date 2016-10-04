package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAONota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Nota;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorEntityManager;

public class DAONotaJPA implements IDAONota {

	public void crear(Nota nota) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.persist(nota);

		em.getTransaction().commit();
	}

	public Nota buscar(String codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void editar(Nota nota) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(nota);

		em.getTransaction().commit();
	}

	public void eliminar(Nota nota) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.remove(nota);
		em.getTransaction().commit();
	}

	public Nota buscarPorCursoEvaluacion(RegistroCurso registro, Evaluacion eval) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Nota.CONSULTAR_NOTAS_REGISTRO_EVALUACION);
		query.setParameter(1, registro);
		query.setParameter(2, eval);
		List<Nota> lista = query.getResultList();
		if (lista.size() > 0) {
			return lista.get(0);
		} else {
			return null;
		}
	}

	public List<Nota> listarPorEstudiante(Estudiante estudiante) throws Exception {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public List<Nota> listarPorRegistroCurso(RegistroCurso registro) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Nota.CONSULTAR_NOTAS_REGISTROCURSO);
		query.setParameter(1, registro);
		return query.getResultList();
	}

	public Nota buscarPorEvaluacion(Evaluacion eval) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query query = em.createNamedQuery(Nota.CONSULTAR_NOTAS_EVALUACIONES);
		query.setParameter(1, eval);
		List<Nota> lista = query.getResultList();
		if (lista.size() > 0) {
			return lista.get(0);
		} else {
			return null;
		}
	}
}
